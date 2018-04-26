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
public class Normal implements IModeloDistr{
    
    private double sigma;
    private double mu;
    private RandomAbs random;
    private double[] par = new double[2];
    private boolean flagPar; //Esta en falso cuando tiene que leer el primer num del par
    
    public Normal(double sigma, double mu,int semilla, boolean RndCong)
    {
        this.sigma = sigma;
        this.mu = mu;
        flagPar = false;
        
        if(RndCong){
            random = new RandomCong();
        }else{
            random = new RandomJava();
        }
    }
    
    @Override
    public LinkedList<Double> generarSerie(int cantidad) {
        LinkedList<Double> list = new LinkedList<>();
        for (int i = 0; i < cantidad; i++) {            
                double[] aux = generarProximoPar();  
                list.add(aux[0]);
                int aux2=i+1;
                if (aux2<cantidad) {
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

        n1 = ( (Math.pow( ((-2.0) * (Math.log(rnd1))) , 0.5)) * Math.cos(2.0 * Math.PI * rnd2) ) * sigma + mu;
        n2 = ( (Math.pow( ((-2.0) * (Math.log(rnd1))) , 0.5)) * Math.sin(2.0 * Math.PI * rnd2) ) * sigma + mu;

        v[0] = n1;
        v[1] = n2;
        return v;
    }

    @Override
    public double generarProximoNumero() {
        if(flagPar){
            flagPar = false;
            return par[1];
        }else{
            par = generarProximoPar();
            flagPar = true;
            return par[0];
        }
    }
    
}
