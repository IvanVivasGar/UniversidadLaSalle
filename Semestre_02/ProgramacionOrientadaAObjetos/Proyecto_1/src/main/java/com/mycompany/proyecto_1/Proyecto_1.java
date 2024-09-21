/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyecto_1;

import java.util.Scanner;

/**
 *
 * @author Ivan
 */
public class Proyecto_1 {

    public static void main(String[] args) {
        //Clase nombre = new Constructor ();
        Mochila objMochila = new Mochila();

        Scanner lector = new Scanner(System.in);

        System.out.print("Ingresa el color de la mochila: ");
        objMochila.setColor(lector.next());

        System.out.print("Ingresa la capacidad de la mochila: ");
        objMochila.setCapacidad(lector.nextInt());

        System.out.print("Ingresa el ancho de la mochila: ");
        objMochila.setAncho(lector.nextInt());

        System.out.print("Ingresa el alto de la mochila: ");
        objMochila.setAlto(lector.nextInt());

        System.out.println();

        System.out.println("La mochila es: " + objMochila.getColor());
        System.out.println("Tiene una capacidad de: " + objMochila.getCapacidad());
        System.out.println("Mide " + objMochila.getAncho() + " cm de ancho");
        System.out.println("Mide " + objMochila.getAlto() + " cm de alto");
        
        System.out.println("-----------------------------------------------");
        
        System.out.print("Color: ");
        String c = lector.next();
        
        System.out.print("Capacidad: ");
        int cap = lector.nextInt();
        
        System.out.print("Ancho: ");
        int an = lector.nextInt();
        
        System.out.print("Alto: ");
        int al = lector.nextInt();
        
        Mochila objMochila2 = new Mochila (c, cap, an, al);
        System.out.println(objMochila2.toString());
    }
}
