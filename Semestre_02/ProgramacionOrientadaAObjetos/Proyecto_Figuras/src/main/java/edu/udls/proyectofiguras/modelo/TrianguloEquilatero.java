/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectofiguras.modelo;

/**
 *
 * @author Ivan
 */
public class TrianguloEquilatero extends Figura {
    float base;
    float altura;
    
    public TrianguloEquilatero(){}
    
    public TrianguloEquilatero(float base, float altura){
        this.base = base;
        this.altura = altura;
    }
    
    public void setBase(float base){
        this.base = base;
    }
    
    public void setAltura(float altura){
        this.altura = altura;
    }
    
    public float getBase(){
        return this.base;
    }
    
    public float getAltura(){
        return this.altura;
    }
    
    @Override
    public String toString(){
        return "Triangulo Equilatero: {altura: " + this.altura + ", base: " + this.base + "}";
    }
    
    public float getPerimetro(){
        return this.base * 3;
    }
    
    public float getArea(){
        return (this.base * this.altura)/2;
    }
    
}
