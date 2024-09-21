/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.pilas.vista;
import edu.udls.pilas.modelo.Pila;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class PrincipalDos {
    public static void main(String args[]){
        String ecuacion = JOptionPane.showInputDialog("Ingresa la ecuacion");
        
        if(validarEcuacion(ecuacion) == true)
            JOptionPane.showMessageDialog(null, "Ecuacion Correcta");
        else
            JOptionPane.showMessageDialog(null, "Ecuacion mal balanceada");
    }
    
    public static boolean validarEcuacion(String ecuacion){
        boolean bandera = false;
        Pila pila = new Pila();
        
        for(int i = 0; i < ecuacion.length(); i++){
            String n = String.valueOf(ecuacion.charAt(i));
            
            if(n.equals("(")){
                pila.push(n);
            }
            
            if(n.equals(")")){
                if(pila.verTam() == 0){
                    bandera = false;
                    return bandera;
                }
                else pila.pop();
            }
        }
        
        if(pila.verTam() == 0) 
            bandera = true;
        else 
            bandera = false;
        
        return bandera;
    }
}