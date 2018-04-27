/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modelo.distribuciones;

import java.util.LinkedList;

/**
 *
 * @author Dani
 */
public interface IModeloDistr {
    
    public LinkedList<Double> generarSerie(int cantidad);
    public double generarProximoNumero();
    public boolean pruebaChi(int intervalos,LinkedList<Double> serie,int cantidad);
    public LinkedList<Integer> frecObtenida(int intervalos, LinkedList<Double> serie);
    
    
    
}
