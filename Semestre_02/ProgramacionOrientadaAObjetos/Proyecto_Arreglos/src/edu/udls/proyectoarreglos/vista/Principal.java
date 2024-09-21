/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectoarreglos.vista;
import javax.swing.JOptionPane;
import edu.udls.proyectoarreglos.control.Operaciones;

/**
 *
 * @author Ivan
 */
public class Principal {
    public static void main(String args[]){
        int [] arreglo1 = solicitarDatos();
        int edadMaxima = Operaciones.edadMaxima(arreglo1);
        int edadMinima = Operaciones.edadMinima(arreglo1);
        float edadPromedio = Operaciones.edadPromedio(arreglo1);
        
        imprimirDatos(edadMaxima, edadMinima, edadPromedio);
    }
    
    public static int[] solicitarDatos(){
        int cantidadAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de alumnos del grupo."));
        
        int [] arregloGrupo = new int[cantidadAlumnos];
        
        for(int i=0; i<arregloGrupo.length; i++){
            arregloGrupo[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno " + (i+1)));
        }
        return arregloGrupo;
    }
    
    public static void imprimirDatos(int edadMaxima, int edadMinima, float edadPromedio){
        JOptionPane.showMessageDialog(null, "La edad maxima es de: " + edadMaxima);
        JOptionPane.showMessageDialog(null, "La edad minima es de: " + edadMinima);
        JOptionPane.showMessageDialog(null, "La edad promedio es de: " + edadPromedio);
    }
    
}
