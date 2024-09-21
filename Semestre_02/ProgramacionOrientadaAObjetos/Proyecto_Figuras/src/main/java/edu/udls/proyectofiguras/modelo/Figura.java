/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectofiguras.modelo;

/**
 *
 * @author Ivan
 */
public class Figura {
    private String nombre;
    
    public Figura(){
        
    }
    
    public Figura(String nombre){
        this.nombre = nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre (){
        return this.nombre;
    }
    
    @Override
    public String toString(){
        return "Figura: {nombre: " + this.nombre + "}";
    }
    
}
