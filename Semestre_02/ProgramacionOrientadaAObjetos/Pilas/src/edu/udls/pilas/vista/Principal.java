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
public class Principal {
    public static void main(String args[]){
        boolean salida = false;
        Pila pilota = new Pila();
        
        do{
            int decisionMenu = mostrarMenu();
            
            switch(decisionMenu){
                case 1:
                    String valor = JOptionPane.showInputDialog("Ingresa el valor que deseas ingresar");
                    pilota.push(valor);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, pilota.pop());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Tamaño: " + pilota.verTam());
                    break;
                case 4: 
                    JOptionPane.showMessageDialog(null, "Cima: " + pilota.verCima());
                    break;
                case 5:
                    pilota.limpiarPila();
                    break;
                case 6:
                    salida = true;
                    break;
            }
        }while(salida == false); 
    }
    
    public static int mostrarMenu(){
        int decisionMenu;
        String mensajeMenu = "- Ingresa 1 para agregar\n- Ingresa 2 para eliminar\n- Ingresa 3 para ver tamaño\n- Ingresa 4 para ver cima\n- Ingresa 5 para limpiar pila\n- Ingresa 6 para salir\n";
        
        decisionMenu = Integer.parseInt(JOptionPane.showInputDialog(mensajeMenu));
        
        return decisionMenu;
    }
}
