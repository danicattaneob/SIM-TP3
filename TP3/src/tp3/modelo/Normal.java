/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author valter
 */
public class Normal {
    
    private double sigma;
    private double mu;
    private int semilla;
    
    public Normal(double sigma, double mu,int semilla)
    {
        this.sigma=sigma;
        this.mu=mu;
        this.semilla=semilla;
    }
    
    
    
        public LinkedList<Double> generarSerie(int cantidad) {
        LinkedList<Double> list = new LinkedList<>();

        for (int i = 0; i < cantidad; i++) {            
                double[] aux=generarProximoPar();  
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
        Random random=new Random( this.semilla);
        double n1, n2, rnd1, rnd2;
        double v[] = new double[2];
        rnd1 = random.nextDouble();
        rnd2 = random.nextDouble();

        n1 = ( (Math.pow( ((-2.0) * (Math.log(rnd1))) , 0.5)) * Math.cos(2.0 * Math.PI * rnd2) ) * sigma + mu;
        n2 = ( (Math.pow( ((-2.0) * (Math.log(rnd1))) , 0.5)) * Math.sin(2.0 * Math.PI * rnd2) ) * sigma + mu;

        v[0] = n1;
        v[1] = n2;

        return v;

    }
    
}
