/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.seriefibonacci.control;

import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */

public class SerieFibonacci {
    public static void main(String args[]){
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero hasta el cual quieres la serie"));
        JOptionPane.showMessageDialog(null, calcularFibonacci(numero));
    }
    
    private static int calcularFibonacci(int n){
        if (n <= 1) {
            return n;
        } 
        else 
        {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
}
