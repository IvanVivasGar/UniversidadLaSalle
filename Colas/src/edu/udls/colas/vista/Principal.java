package edu.udls.colas.vista;
import edu.udls.colas.modelo.Cola;
import edu.udls.colas.modelo.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */

public class Principal {
    public static void main(String args[]){
        Cola uyuyuy = new Cola();
        boolean salir = false;
        int decision = 0;
        
        do{
            decision = Integer.parseInt(JOptionPane.showInputDialog( "Ingresa 1 para agregar\nIngresa 2 para eliminar\nIngresa 3 para ver tamaño\nIngresa 4 para ver frente\nIngresa 5 para ver final\nIngresa 6 para limpiar\nIngresa 7 para ver si es vacio\nIngresa 8 para salir\n"));
            
            switch(decision){
                case 1:
                    String valor = JOptionPane.showInputDialog("Ingresa un valor");
                    int prioridad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa su prioridad\n3. Mas importante\n2. Medio Importante\n1. Nada importante"));
                    uyuyuy.encolar(valor, prioridad);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Eliminado: " + uyuyuy.desencolar());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Tamaño: " + uyuyuy.getTam());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Frente: " + uyuyuy.getFrente().getValor());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Final: " + uyuyuy.getFin().getValor());
                    break;
                case 6:
                    uyuyuy.limpiar();
                    JOptionPane.showMessageDialog(null, "Uyuyuy vacio");
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Es vacio? " + uyuyuy.vacio());
                    break;
                case 8:
                    salir = true;
                    break;
            }
        }while(salir == false);
    }
}