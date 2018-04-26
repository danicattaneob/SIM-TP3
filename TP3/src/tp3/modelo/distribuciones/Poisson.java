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
    
    private  double lamda;
    private double p;
    private double x;
    private double a;
    private RandomAbs random;

    public Poisson(double lamda, boolean RndCong) {
        this.lamda = lamda;
        this.p = 1;
        this.x = -1;
        this.a = Math.pow(Math.E,(this.lamda*(-1)));
        
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
            list.add(generarProximoNumero());            
        }
        return list;    
    }
 
    @Override
    public double generarProximoNumero() {
        do{
            double u = (random.generarRandom());
            this.p = p * u;
            this.x = x + 1;
        }while(this.p >= this.a);
       return x;       
    }
    
}
