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
public class Exponencial {
    private int semilla = 0;
 
    private int xi; //semilla
    private int a; //constante multiplicativa
    private int c; //constante aditiva
    private int m; //modulo
   private int me; //media

    public void setMe(int me) {
        this.me = me;
    }
    
   
     public int getSemilla() {
        return semilla;
    }

    public int getXi(){
        return xi;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }
    
   
    public LinkedList<Double> generarSerie(int semilla, int cantidad) {
        this.semilla = semilla;
        this.xi = semilla;
        LinkedList<Double> list = new LinkedList<>();
       
        for (int i = 0; i < cantidad; i++) {            
            list.add((-me)*(Math.log( 1-generarProximoNumero())));            
        }
        return list;    
    }
 
    private double generarProximoNumero() {
       this.xi = ( (a * xi) + c) % m;
       return (double) xi/ (double) m;       
    }
}
