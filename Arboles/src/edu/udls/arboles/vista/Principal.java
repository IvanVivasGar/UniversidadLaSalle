/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.arboles.vista;
import edu.udls.arboles.modelo.Arbol;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class Principal {
    public static void main(String args[]){
        Arbol arbol = new Arbol();
        
        arbol.insertar(18);
        arbol.insertar(32);
        arbol.insertar(26);
        arbol.insertar(17);
        arbol.insertar(86);
        arbol.insertar(50);
        arbol.insertar(27);
        arbol.insertar(33);
        arbol.insertar(21);
        arbol.insertar(100);
        
        JOptionPane.showMessageDialog(null, arbol.verTamano());
        JOptionPane.showMessageDialog(null, "PRE: " + arbol.imprimirPre(arbol.raiz));
        JOptionPane.showMessageDialog(null, "POST: " + arbol.imprimirPost(arbol.raiz));
        JOptionPane.showMessageDialog(null, "IN: " + arbol.imprimirIn(arbol.raiz));
    }
}
