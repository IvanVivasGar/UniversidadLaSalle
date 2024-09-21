/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.arreglosbidi.control;

/**
 *
 * @author Ivan
 */
public class Operaciones {
    
    public static int[][] multiplicarArreglosPP (int[][] a1, int[][] a2){
        
        int[][] a3 = new int[a1.length][a1[0].length];
        
        for(int i=0; i<a1.length; i++){
            for(int z=0; z<a1[i].length; z++){
                a3[i][z] = a1[i][z] * a2[i][z];
            }
        }
        return a3;
    }
    
}
