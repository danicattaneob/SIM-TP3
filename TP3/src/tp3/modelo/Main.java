/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo;

import tp3.modelo.random.RandomCong;
import java.util.LinkedList;
import tp3.modelo.distribuciones.Uniforme;
import tp3.modelo.distribuciones.Exponencial;

/**
 *
 * @author valter
 */
public class Main {
    
    public static void main(String[] args){
////        ////////////////////////////////// UNIFORME
        Uniforme u = new Uniforme(95,100,false);
        //para el generador RND
//        u.setA(13);//cte multiplicativa
//        u.setC(7); //cte aditiva
//        u.setM(8);//modulo
//        //para la distribucion
//        u.setA2(95); //limite inferior intervalo
//        u.setB(100);//limite superior intervalo
          LinkedList<Double> serie = u.generarSerie(100);
          System.out.println(serie); //le paso la cantidad de valores que quiero
        System.out.println(u.frecObtenida(5, serie));
       // System.out.println(u.pruebaChi(5, serie));
////        ////////////////////////////////// EXPONENCIAL
        Exponencial ex = new Exponencial(3,false);
//        ex.setA(13);//cte multiplicativa
//        ex.setC(3); //cte aditiva
//        ex.setM(8);//modulo
//        ex.setMe(5);
        System.out.println(ex.generarSerie(10));
////        ///////////////////////////////// NORMAL  
//        Normal n = new Normal(2, 323, 4);
////      LinkedList l=n.generarSerie(1);
////      System.out.println(l.toString());
////      System.out.println("sida");
//        System.out.println(n.generarSerie(10));

//        RandomCong ran = new RandomCong();
//        //System.out.println(ran.getNumeroPrimo());
//        System.out.println("------------------/");
//        System.out.println(ran.getA() + " - " + ran.getM() + " - " + ran.getXi());
//        System.out.println("------------------/");
//        for (int i = 0; i < 15; i++) {
//                System.out.println(ran.generarRandom());
//            
//        }
        
    }
}
