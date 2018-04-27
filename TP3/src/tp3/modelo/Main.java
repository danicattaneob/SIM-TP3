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
import tp3.modelo.distribuciones.Normal;
import tp3.modelo.distribuciones.Poisson;
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
        System.out.println(u.pruebaChi(5, serie));
       // System.out.println(u.pruebaChi(5, serie));
////        ////////////////////////////////// EXPONENCIAL
        Exponencial ex = new Exponencial(3,false);
//        ex.setA(13);//cte multiplicativa
//        ex.setC(3); //cte aditiva
//        ex.setM(8);//modulo
//        ex.setMe(5);
        LinkedList<Double> serie2=ex.generarSerie(100);
        System.out.println(serie2);
        System.out.println(ex.pruebaChi(5, serie2, 0.38, 100));
////        ///////////////////////////////// NORMAL  
         Normal n = new Normal(5.11, 1.33, false);
         LinkedList<Double> serie3=n.generarSerie(100);
         System.out.println(serie3);
         System.out.println(n.pruebaChi(100, 5, serie3));
////      LinkedList l=n.generarSerie(1);
////      System.out.println(l.toString());
////      System.out.println("sida");
//        System.out.println(n.generarSerie(10));
Poisson p=new Poisson(15,false);
LinkedList<Double> serie4=p.generarSerie(100);
        System.out.println(serie4);
        System.out.println(p.pruebaChi(100, 5, serie3, 50));
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
