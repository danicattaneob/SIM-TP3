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
//import java.util.Random;
/**
 *
 * @author valter
 */
public class Uniforme implements IModeloDistr{

    private RandomAbs random;
    private int a;//extremo intervalo
    private int b;//extremo intervalo
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Uniforme(int a, int b, boolean RndCong) {
        this.a = a;
        this.b = b;
        
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
       return this.a+(random.generarRandom() * (this.b-this.a));    
    }

  
    
    
}
