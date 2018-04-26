/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo;

import java.util.LinkedList;
//import java.util.Random;
/**
 *
 * @author valter
 */
public class Uniforme {
private int semilla = 0;
//    Random random;
    private int a; //constatne multiplicativa
    private int c; //constante aditiva
    private int m; //modulo
    private int xi; //valor inicial
    private int a2;//extremo intervalo
    private int b;//extremo intervalo
    
    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }
    

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
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
//        random = new Random(semilla);
        for (int i = 0; i < cantidad; i++) {            
            list.add(this.a2+(generarProximoNumero()*(this.b-this.a2)));            
        }
        return list;    
    }
 
    private double generarProximoNumero() {
       this.xi = ( (a * xi) + c) % m;
       return (double) xi/ (double) m;       
    }
    
  
    
    
}
