/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JOptionPane;
import edu.udls.arreglosbidi.control.Operaciones;

/**
 *
 * @author Ivan
 */
public class Principal {
    public static void main(String args[]){
        int [][]a1 = solicitarDatos();
        int [][]a2 = solicitarDatos();
        int [][]a3 = Operaciones.multiplicarArreglosPP(a1, a2);
        int [][]a4 = Operaciones.sumarArreglosPP(a1, a2);
        int [][]a5 = Operaciones.restarArreglosPP(a1, a2);
        
        imprimirArreglo(a1);
        imprimirArreglo(a2);
        imprimirArreglo(a3);
        imprimirArreglo(a4);
        imprimirArreglo(a5);
    }
    
    public static int [][] solicitarDatos(){
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Indica el numero de filas: "));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Indica el numero de columnas: "));
        
        int[][] arreglo1 = new int[filas][columnas];
        
        for(int i=0; i<arreglo1.length; i++){
            for(int z=0; z<arreglo1[i].length; z++){
                arreglo1[i][z] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del arreglo en la posicion {" + i + "," + z + "}"));
            }
        }
        return arreglo1;
    }
    
    public static void imprimirArreglo(int[][] a){
        String mensaje = "";
        
        for(int i=0; i<a.length; i++){
            for(int z=0; z<a[i].length; z++){
                mensaje+=a[i][z]+"   ";
            }
            mensaje+=" \n ";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
}