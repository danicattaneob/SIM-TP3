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
public class Poisson implements IModeloDistr{
    
    private  double lambda;
    private double p;
    private double x;
    private double a;
    private RandomAbs random;

    public Poisson(double lambda, boolean RndCong) {
        this.lambda = lambda;
        this.p = 1;
        this.x = -1;
        this.a = Math.pow(Math.E,(this.lambda*(-1)));
        
        if(RndCong){
            random = new RandomCong();
        }else{
            random = new RandomJava();
        }
    }
    
    @Override
    public LinkedList<Double> generarSerie(double cantidad) {

        LinkedList<Double> list = new LinkedList<>();

        for (int i = 0; i < cantidad; i++) {            
            list.add(generarProximoNumero());            
        }
        return list;    
    }
 
    @Override
    public double generarProximoNumero() {
    double L = Math.exp(-lambda);
    double p = 1.0;
    int k = 0;

    do {
        k++;
        p *= Math.random();
    } while (p > L);
    return k - 1;      
    }
    
    public boolean pruebaChi(double intervalos,LinkedList<Double> serie,double cantidad)
    {
        double tablaChi[]={3.84,5.99,7.81,9.49,11.1,12.6,14.1,15.5,16.9,18.3,19.7,21.0,22.4,23.7,25.0,26.3,27.6,28.9,30.1};
        LinkedList<Double> fe=frecEsperada(intervalos,serie,cantidad);
        //LinkedList<Integer> fo=frecObtenida(intervalos,serie);
        double res=0;
        for (int i = 0; i < intervalos; i++) {
            res+=fe.get(i);
        }
        if(res<tablaChi[(int)intervalos-1]){
            return true;
        }else{
            return false;
        }
    }
    public LinkedList<Double> frecEsperada(double intervalos, LinkedList<Double> serie, double cantidad)
    {
        double NP = 0;
        for (int i = 0; i < serie.size(); i++) {
            NP = NP + serie.get(i);
            
        }
    LinkedList<Double> listFE = new LinkedList<>();
    LinkedList<Double> P=new LinkedList<>();
        for (int i = 0; i < intervalos; i++) {
            listFE.add(0.0);//Seteo en cero
            P.add(0.0);
        }
        bubbleSort(serie);
        double rango = serie.getLast() - serie.getFirst();
        double amp = rango / intervalos;
        double amplitud = Math.round(amp); //redondeo para que el intervalo contenga los primeros y ultimos 
        
            for (int j = 0; j < intervalos; j++) {
                    P.set(j,((Math.pow(lambda,serie.getFirst()+amplitud*j)*Math.exp(-lambda))/factorial(serie.getFirst()+amplitud*j)));
            }
        for (int i = 0; i < intervalos; i++) {
            listFE.set(i,(Math.floor(P.get(i)*NP)));            
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
                }
            }
        }
        return listFO;
    }
    
    public static long factorial(double number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
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
