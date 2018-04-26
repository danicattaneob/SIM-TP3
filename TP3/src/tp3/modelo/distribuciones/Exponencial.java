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
public class Exponencial implements IModeloDistr{
    
    private RandomAbs random;
    private int me; //media

    public void setMe(int me) {
        this.me = me;
    }

    public Exponencial(int me,  boolean RndCong) {
        this.me = me;
        
        if(RndCong){
            random = new RandomCong();
        }else{
            random = new RandomJava();
        }
    }
    
    
    @Override
    public LinkedList<Double> generarSerie( int cantidad) {
        LinkedList<Double> list = new LinkedList<>();
       
        for (int i = 0; i < cantidad; i++) {            
            list.add(generarProximoNumero());            
        }
        return list;    
    }
 
    @Override
    public double generarProximoNumero() {
       return (-me)*(Math.log( 1-random.generarRandom()));
    }
}
