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
public class Main {
    
    public static void main(String[] args){
//        ////////////////////////////////// UNIFORME
        Uniforme u = new Uniforme();
        //para el generador RND
        u.setA(13);//cte multiplicativa
        u.setC(7); //cte aditiva
        u.setM(8);//modulo
        //para la distribucion
        u.setA2(95); //limite inferior intervalo
        u.setB(100);//limite superior intervalo
        System.out.println(u.generarSerie(6, 10)); //le paso la semilla y la cantidad de valores que quiero
//        ////////////////////////////////// EXPONENCIAL
        Exponencial ex = new Exponencial();
        ex.setA(13);//cte multiplicativa
        ex.setC(3); //cte aditiva
        ex.setM(8);//modulo
        ex.setMe(5);
        System.out.println(ex.generarSerie(6, 10));
//        ///////////////////////////////// NORMAL  
        Normal n = new Normal(2, 323, 4);
//      LinkedList l=n.generarSerie(1);
//      System.out.println(l.toString());
//      System.out.println("sida");
        System.out.println(n.generarSerie(10));
    }
}
