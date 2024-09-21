/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectofiguras.vista;

import edu.udls.proyectofiguras.modelo.Rectangulo;
import edu.udls.proyectofiguras.modelo.Circulo;
import edu.udls.proyectofiguras.modelo.Poligono;
import edu.udls.proyectofiguras.modelo.TrianguloEquilatero;
import edu.udls.proyectofiguras.modelo.TrianguloEscaleno;
import edu.udls.proyectofiguras.modelo.TrianguloIsoceles;

import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */

public class Principal {
    public static void main(String args []){
        
        String decision = JOptionPane.showInputDialog("1. Rectangulo\n2. Circulo\n3. Poligono\n4. Triangulo Equilatero\n5. Triangulo Isosceles\n6. Triangulo Escaleno");
        
        switch(decision){
            case "1":
                manipularRectangulo();
                break;
            case "2":
                manipularCirculo();
                break;
            case "3":
                manipularPoligono();
                break;
            case "4":
                manipularTrianguloEquilatero();
                break;
            case "5":
                manipularTrianguloIsoceles();
                break;
            case "6":
                manipularTrianguloEscaleno();
                break;
            default:
                JOptionPane.showMessageDialog(null, "La opcion introducida no es valida.");
        }
        
        //manipularRectangulo();
    }
    
    public static void manipularRectangulo(){
        float base = Float.parseFloat(JOptionPane.showInputDialog("Ingresa la base"));
        float altura = Float.parseFloat(JOptionPane.showInputDialog("Ingresa la altura"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
        
        Rectangulo objRectangulo = new Rectangulo();
        objRectangulo.setAltura(altura);
        objRectangulo.setBase(base);
        objRectangulo.setNombre(nombre);
        
        JOptionPane.showMessageDialog(null, objRectangulo.toString());
        JOptionPane.showMessageDialog(null, "El perimetro es de: " + objRectangulo.getPerimetro());
        JOptionPane.showMessageDialog(null, "El area es de: " + objRectangulo.getArea());
    }
    
    public static void manipularCirculo(){
        float radio = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el radio"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
        
        Circulo objCirculo = new Circulo();
        objCirculo.setRadio(radio);
        objCirculo.setNombre(nombre);
        
        JOptionPane.showMessageDialog(null, objCirculo.toString());
        JOptionPane.showMessageDialog(null, "El perimetro es de: " + objCirculo.getPerimetro());
        JOptionPane.showMessageDialog(null, "El area es de: " + objCirculo.getArea());
    }
    
    public static void manipularPoligono(){
        float cantidadLados = Float.parseFloat(JOptionPane.showInputDialog("Ingresa la cantidad de lados del poligono"));
        float medidaLado = Float.parseFloat(JOptionPane.showInputDialog("Ingresa la medida de los lados"));
        float medidaApotema = Float.parseFloat(JOptionPane.showInputDialog("Ingresa la medida del apotema"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
        
        Poligono objPoligono = new Poligono();
        objPoligono.setCantidadLados(cantidadLados);
        objPoligono.setMedidaLado(medidaLado);
        objPoligono.setMedidaApotema(medidaApotema);
        objPoligono.setNombre(nombre);
        
        JOptionPane.showMessageDialog(null, objPoligono.toString());
        JOptionPane.showMessageDialog(null, "El perimetro es de: " + objPoligono.getPerimetro());
        JOptionPane.showMessageDialog(null, "El area es de: " + objPoligono.getArea());
    }
    
    public static void manipularTrianguloEquilatero(){
        float base = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la base del triangulo"));
        float altura = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la altura"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
        
        TrianguloEquilatero objTrianguloEquilatero = new TrianguloEquilatero();
        objTrianguloEquilatero.setBase(base);
        objTrianguloEquilatero.setAltura(altura);
        objTrianguloEquilatero.setNombre(nombre);
        
        JOptionPane.showMessageDialog(null, objTrianguloEquilatero.toString());
        JOptionPane.showMessageDialog(null, "El perimetro es de: " + objTrianguloEquilatero.getPerimetro());
        JOptionPane.showMessageDialog(null, "El area es de: " + objTrianguloEquilatero.getArea());
    }
    
    public static void manipularTrianguloIsoceles(){
        float base = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la base del triangulo"));
        float lados = Float.parseFloat(JOptionPane.showInputDialog("Ingrese los lados"));
        float altura = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la altura"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
        
        TrianguloIsoceles objTrianguloIsoceles = new TrianguloIsoceles();
        objTrianguloIsoceles.setBase(base);
        objTrianguloIsoceles.setLados(lados);
        objTrianguloIsoceles.setAltura(altura);
        objTrianguloIsoceles.setNombre(nombre);
        
        JOptionPane.showMessageDialog(null, objTrianguloIsoceles.toString());
        JOptionPane.showMessageDialog(null, "El perimetro es de: " + objTrianguloIsoceles.getPerimetro());
        JOptionPane.showMessageDialog(null, "El area es de: " + objTrianguloIsoceles.getArea());
    }
        
    public static void manipularTrianguloEscaleno(){
        float base = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la base del triangulo"));
        float ladoIzquierdo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado izquierdo"));
        float ladoDerecho = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado derecho"));
        float altura = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la altura"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
        
        TrianguloEscaleno objTrianguloEscaleno = new TrianguloEscaleno();
        objTrianguloEscaleno.setBase(base);
        objTrianguloEscaleno.setLadoIzquierdo(ladoIzquierdo);
        objTrianguloEscaleno.setLadoDerecho(ladoDerecho);
        objTrianguloEscaleno.setAltura(altura);
        objTrianguloEscaleno.setNombre(nombre);
        
        JOptionPane.showMessageDialog(null, objTrianguloEscaleno.toString());
        JOptionPane.showMessageDialog(null, "El perimetro es de: " + objTrianguloEscaleno.getPerimetro());
        JOptionPane.showMessageDialog(null, "El area es de: " + objTrianguloEscaleno.getArea());
    }
    
}
