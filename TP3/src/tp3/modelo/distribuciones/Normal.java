/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo.distribuciones;

import java.util.LinkedList;
import tp3.modelo.random.RandomAbs;
import tp3.modelo.random.RandomCong;
import tp3.modelo.random.RandomJava;

/**
 *
 * @author valter
 */
public class Normal implements IModeloDistr {

    private double desvN;
    private double mediaN;
    private RandomAbs random;
    private double[] par = new double[2];
    private boolean flagPar; //Esta en falso cuando tiene que leer el primer num del par

    public Normal(double desvN, double mediaN, boolean RndCong) {
        this.desvN = desvN;
        this.mediaN = mediaN;
        flagPar = false;

        if (RndCong) {
            random = new RandomCong();
        } else {
            random = new RandomJava();
        }
    }

    @Override
    public LinkedList<Double> generarSerie(double cantidad) {
        LinkedList<Double> list = new LinkedList<>();
        for (int i = 0; i < cantidad; i++) {
            double[] aux = generarProximoPar();
            list.add(aux[0]);
            int aux2 = i + 1;
            if (aux2 < cantidad) {
                list.add(aux[1]);
                i++;
            }
        }
        return list;
    }

    private double[] generarProximoPar() {
        double n1, n2, rnd1, rnd2;
        double v[] = new double[2];
        rnd1 = random.generarRandom();
        rnd2 = random.generarRandom();

        n1 = ((Math.pow(((-2.0) * (Math.log(rnd1))), 0.5)) * Math.cos(2.0 * Math.PI * rnd2)) * desvN + mediaN;
        n2 = ((Math.pow(((-2.0) * (Math.log(rnd1))), 0.5)) * Math.sin(2.0 * Math.PI * rnd2)) * desvN + mediaN;

        v[0] = n1;
        v[1] = n2;
        return v;
    }

    @Override
    public double generarProximoNumero() {
        if (flagPar) {
            flagPar = false;
            return par[1];
        } else {
            par = generarProximoPar();
            flagPar = true;
            return par[0];
        }
    }

    public boolean pruebaChi(double intervalos, LinkedList<Double> serie, double cantidad) {
        double tablaChi[] = {3.84, 5.99, 7.81, 9.49, 11.1, 12.6, 14.1, 15.5, 
            16.9, 18.3, 19.7, 21.0, 22.4, 23.7, 25.0, 26.3, 27.6, 28.9, 30.1};
        LinkedList<Double> fe = frecEsperada(intervalos, serie, cantidad);
        //LinkedList<Integer> fo=frecObtenida(intervalos,serie);
        double res = 0;
        for (int i = 0; i < intervalos; i++) {
            res += fe.get(i);
        }
        if (res < tablaChi[(int)intervalos - 1]) {
            return true;
        } else {
            return false;
        }
    }

    public LinkedList<Double> frecEsperada(double intervalos, LinkedList<Double> serie, double cantidad) {
        LinkedList<Double> listFE = new LinkedList<>();
        LinkedList<Double> fmc = new LinkedList<>();
        LinkedList<Double> p = new LinkedList<>();
        for (int i = 0; i < intervalos; i++) {
            listFE.add(0.0);//Seteo en cero
            fmc.add(0.0);
            p.add(0.0);
        }
        bubbleSort(serie);
        double rango = serie.getLast() - serie.getFirst();
        double amp = rango / intervalos;
        double amplitud = Math.round(amp); //redondeo para que el intervalo contenga los primeros y ultimos 

        for (int j = 0; j < intervalos; j++) {
            fmc.set(j, (Math.exp(-0.5 * Math.pow(((((serie.getFirst() * 2 + amplitud * j + amplitud * (j + 1)) / 2) - mediaN) / desvN), 2)) / (desvN * Math.sqrt(2 * Math.PI))));
        }
        for (int i = 0; i < intervalos; i++) {
            p.set(i, (fmc.get(i) * amplitud));
        }
        for (int i = 0; i < intervalos; i++) {
            listFE.set(i, cantidad * p.get(i));

        }
        return listFE;
    }

    public LinkedList<Integer> frecObtenida(double intervalos, LinkedList<Double> serie)
    {
        LinkedList<Integer> listFO = new LinkedList<>();
        for (int i = 0; i < intervalos; i++) {
            listFO.add(0);//Seteo en cero
        }
        bubbleSort(serie);
        double rango = serie.getLast() - serie.getFirst();
        double amp = rango / intervalos;
        double amplitud = Math.round(amp); //redondeo para que el intervalo contenga los primeros y ultimos 
        for (int i = 0; i < serie.size(); i++) {
            for (int j = 0; j < intervalos; j++) {
                if (serie.get(i) >= (serie.getFirst() + amplitud * j) && serie.get(i) < (serie.getFirst() + amplitud * (j + 1))) {
                    listFO.set(j, listFO.get(j)+1);
                    break;
                }
            }
        }
        return listFO;
    }
    
    private void bubbleSort(LinkedList<Double> v) {
        boolean ordenado = false;
        int n = v.size();
        for (int i = 0; i < n - 1 && !ordenado; i++) {
            ordenado = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (v.get(j) > v.get(j + 1)) {
                    double aux = v.get(j);
                    v.set(j, v.get(j + 1));
                    v.set(j + 1, aux);
                    ordenado = false;
                }
            }
        }
    }

}
