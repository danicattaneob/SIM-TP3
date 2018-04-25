/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo;

import java.util.LinkedList;

/**
 *
 * @author valter
 */
public class Poisson {
    
    private  double lamda;
    private double p;
    private double x;
    private double a;

    public Poisson(double lamda) {
        this.lamda = lamda;
        this.p=1;
        this.x=-1;
        this.a=Math.pow(Math.E,(this.lamda*(-1)));
    }
    
   
    public LinkedList<Double> generarSerie(int cantidad) {

        LinkedList<Double> list = new LinkedList<>();

        for (int i = 0; i < cantidad; i++) {            
            list.add(generarProximoNumero());            
        }
        return list;    
    }
 
    private double generarProximoNumero() {
                  while(this.p>=this.a)
        {
            double u=(Math.random()*1);
            this.p=p*u;
            this.x=x+1;
            
        }
       return x;       
    }
    
}
