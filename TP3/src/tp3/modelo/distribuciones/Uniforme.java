/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo.distribuciones;

import java.text.DecimalFormat;
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
    
    
    public LinkedList<Integer> frecObtenida(int intervalos, LinkedList<Double> serie)
    {
        LinkedList<Integer> listFO = new LinkedList<>();
        for (int i = 0; i < intervalos; i++) {
            listFO.add(0);//Seteo en cero
        }
        bubbleSort(serie);
        double rango = serie.getLast() - serie.getFirst();
        double amp = rango / intervalos;
        double amplitud = Math.round(amp); //redondeo para que el intervalo contenga los primeros y ultimos 
        for (int i = 0; i < serie.size(); i++) {
            for (int j = 0; j < intervalos; j++) {
                if (serie.get(i) >= (serie.getFirst() + amplitud * j) && serie.get(i) < (serie.getFirst() + amplitud * (j + 1))) {
                    listFO.set(j, listFO.get(j)+1);
                }
            }
        }
        return listFO;
    }
    
    
    
    
    
//  public String pruebaChi(int intervalos, LinkedList<Double> serie)
//  {
//      //CALCULO FE
//      double fe=serie.size()/intervalos;
//      while(5 > fe) {
//          intervalos--;//como no puede ser la frecuencia esperada menor a 5, reduzco intervalos
//          fe=serie.size()/intervalos;
//      }
//      //CALCULO FO
//      LinkedList<Double> listFO= new LinkedList<>(); //columna FO
//      for (int i = 0; i < listFO.size(); i++) listFO.set(i,0.0);//Seteo en cero
//      LinkedList<Double> listLimInf= new LinkedList<>(); 
//      listLimInf= limInferior(serie,intervalos); //columna limites inferiores intervalo
//      LinkedList<Double> listLimSup= new LinkedList<>(); 
//      listLimSup= limSuperior(serie,intervalos);//columna limites superiores intervalo
//      int i = 0;
//      while (i < intervalos) {
//          double x = 0; //contador de frecuencias          
//          for (int k = 0; k < serie.size(); k++) {
//              if (serie.get(k) > listLimInf.get(i) && serie.get(k) < listLimSup.get(i)) {//veo si esta adentro del intervalo
//                  x++;
//              }
//          }
//          listFO.set(i, x); //seteo la cantidad de frecuencias observadas
//          i++;
//      }
//      //CALCULO CHI
//      LinkedList<Double> c= new LinkedList<>();
//      for (int j = 0; j < intervalos; j++) {          
//          c.set(j,Math.pow((listFO.get(j)-fe),2)/fe);     //para cada intervalo calculo     
//      }
//      double chi=0;
//      //HAGO SUMATORIA
//      for (int j = 0; j <intervalos; j++) {
//          chi+=c.get(j);          
//      }
//      if(chi<5){
//          return "si";
//      }else{
//          return "no";
//      }           
//  }
    //para obtener el lista con lim inferiores 
//    public LinkedList<Double> limInferior(LinkedList<Double> serie, int intervalos) {
//        LinkedList<Double> list = new LinkedList<>();
//        bubbleSort(serie);
//        double rango = serie.getFirst() - serie.getLast();
//        double amp = rango / intervalos;
//        double amplitud = Math.round(amp); //redondeo para que el intervalo contenga los primeros y ultimos valores de la serie
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, (serie.getFirst() + amplitud * i));   //lista con lim inferiores de los intervalos  
//        }
//        return list;
//    }
//    //para obtener el lista con lim superiores 
//    public LinkedList<Double> limSuperior(LinkedList<Double> serie, int intervalos) {
//        LinkedList<Double> list = new LinkedList<>();
//        bubbleSort(serie);
//        double rango = serie.getLast() - serie.getFirst();
//        double amp = rango / intervalos;
//        double amplitud = Math.round(amp); //redondeo para que el intervalo contenga los primeros y ultimos valores de la serie
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, (serie.getFirst() + amplitud * (i + 1)));   //lista con lim superiores de los intervalos  
//        }
//        return list;
//    }
    //para ordenar la serie y obtener el menor y mayor
    private void bubbleSort(LinkedList<Double> v) {
        boolean ordenado = false;
        int n = v.size();
        for (int i = 0; i < n - 1 && !ordenado; i++) {
            ordenado = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (v.get(j) > v.get(j + 1)) {
                    double aux = v.get(j);
                    v.set(j, v.get(j + 1));
                    v.set(j + 1, aux);
                    ordenado = false;
                }
            }
        }
    }
    
}
