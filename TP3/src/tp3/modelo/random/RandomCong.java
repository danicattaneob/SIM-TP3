/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo.random;

import java.util.ArrayList;

/**
 *
 * @author Dani
 */
public class RandomCong extends RandomAbs{
    
    private int a; //constatne multiplicativa
    private int c; //constante aditiva
    private int m; //modulo
    private int xi; //valor inicial

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

    public int getXi() {
        return xi;
    }

    public RandomCong(int a, int c, int m, int xi) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.xi = xi;
    }

    public RandomCong() {
        this.a = 1 + 4 * ((int)(Math.random() * 25));
        this.c = this.getNumeroPrimo();
        this.m = (int) Math.pow(2, Math.random() * 8 + 5);
        this.xi = this.getNumeroPrimo();
    }
    
    private int getNumeroPrimo(){
        int i;
       int num;
       //Empty String
       ArrayList<Integer> primeNumbers = new ArrayList();

       for (i = 1; i <= 100; i++)         
       { 		  	  
          int counter=0; 	  
          for(num =i; num>=1; num--)
	  {
             if(i%num==0)
	     {
 		counter = counter + 1;
	     }
	  }
	  if (counter ==2)
	  {
	     //Appended the Prime number to the String
	     primeNumbers.add(i);
	  }	
       }
       return primeNumbers.get((int)(Math.random() * 23));
    }
        
    
    @Override
    public double generarRandom() {
       this.xi = ( (a * xi) + c) % m;
       double ri = (double) xi/ (double) m;        
       return ((int)(ri * 10000)) / (double)10000;
    }
}
