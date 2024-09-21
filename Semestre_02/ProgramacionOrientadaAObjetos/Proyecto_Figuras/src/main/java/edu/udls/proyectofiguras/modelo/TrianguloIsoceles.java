/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectofiguras.modelo;

/**
 *
 * @author Ivan
 */
public class TrianguloIsoceles extends Figura{
    float base;
    float lados;
    float altura;
    
    public TrianguloIsoceles(){}
    
    public TrianguloIsoceles(float base, float lados, float altura){
        this.base = base;
        this.lados = lados;
        this.altura = altura;
    }
    
    public void setBase(float base){
        this.base = base;
    }
    
    public void setLados(float lados){
        this.lados = lados;
    }
    
    public void setAltura(float altura){
        this.altura = altura;
    }
    
    public float getBase(){
        return this.base;
    }
    
    public float getLados(){
        return this.lados;
    }
    
    public float getAltura(){
        return this.altura;
    }
    
    @Override
    public String toString(){
        return "Triangulo Isoceles: {altura: " + this.altura + ", base: " + this.base + ", lados: " + this.lados + "}";
    }
    
    public float getArea(){
        return (this.base * this.altura)/2;
    }
    
    public float getPerimetro(){
        return this.base + (2 * this.lados);
    }
    
}
