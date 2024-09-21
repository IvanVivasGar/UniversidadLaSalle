/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_1;

/**
 *
 * @author Ivan
 */
public class Mochila{
    private String color;
    private int capacidad;
    private float ancho;
    private float alto;
    
    //CONSTRUCTOR VACIO
    public Mochila (){}
    
    //CONSTRUCTOR CARGADO
    public Mochila(String color, int capacidad, float ancho, float alto){
        this.color = color;
        this.capacidad = capacidad;
        this.ancho = ancho;
        this.alto = alto;
    }

    //METODO GET - DEVUELVEN LOS VALORES QUE SE TIENEN EN EL OBJETO
    public String getColor() {
        return color;
    }

    //METODO SET - COLOCAR EL VALOR QUE LLEGA EN EL ATRIBUTO.
    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }
    
    @Override
    public String toString()
    {
        return "Mochila = {color = " + color + ", capacidad = " + capacidad + ", ancho = " + ancho + ", alto = " + alto + "}";
    }
}