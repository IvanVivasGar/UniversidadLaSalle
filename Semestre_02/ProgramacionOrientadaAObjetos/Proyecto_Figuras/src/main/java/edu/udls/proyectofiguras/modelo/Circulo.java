/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectofiguras.modelo;

/**
 *
 * @author Ivan
 */
public class Circulo extends Figura{
    float radio;
    
    public Circulo(){}
    
    public Circulo(float radio){
        this.radio = radio;
    }
    
    public void setRadio(float radio){
        this.radio = radio;
    }
    
    public float getRadio(){
        return this.radio;
    }
    
    @Override
    public String toString(){
        return "Circulo: {radio: " + this.radio + "}";
    }
    
    public float getArea (){
        return (float)Math.pow(this.radio,2)*(float)Math.PI; 
    }
    
    public float getPerimetro(){
        return ((float)Math.PI*(this.radio) * 2);
    }
    
}
