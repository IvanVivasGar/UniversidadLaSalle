/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectoarreglos.control;

/**
 *
 * @author Ivan
 */
public class Operaciones {
    
    public static int edadMaxima(int arreglo1[]){
        int edadMaxima=0;
        
        for (int i=0; i<(arreglo1.length - 1); i++){
            if (arreglo1[i]<arreglo1[i+1]){
                edadMaxima = arreglo1[i+1];
            }
        }
        return edadMaxima;
    }
    
    public static int edadMinima(int arreglo1[]){
        int edadMinima=0;
        
        for (int i=0; i<(arreglo1.length - 1); i++){
            if (arreglo1[i]>arreglo1[i+1]){
                edadMinima = arreglo1[i+1];
            }
        }
        return edadMinima;
    }
    
    public static float edadPromedio(int arreglo1[]){
        int edadPromedio, sumatoriaEdades=0;
        
        for(int i=0; i<arreglo1.length; i++){
            sumatoriaEdades+=arreglo1[i];
        }
        edadPromedio=sumatoriaEdades/arreglo1.length;
        return edadPromedio;
    }
    
}
