/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectofiguras.modelo;

/**
 *
 * @author Ivan
 */
public class Poligono extends Figura{
    float cantidadLados;
    float medidaLado;
    float medidaApotema;
    
    public Poligono(){}
    
    public Poligono(float cantidadLados, float medidaLado, float medidaApotema){
        this.cantidadLados = cantidadLados;
        this.medidaLado = medidaLado;
        this.medidaApotema = medidaApotema;
    }
    
    public void setCantidadLados(float cantidadLados){
        this.cantidadLados = cantidadLados;
    }
    
    public void setMedidaLado(float medidaLado){
        this.medidaLado = medidaLado;
    }
    
    public void setMedidaApotema(float medidaApotema){
        this.medidaApotema = medidaApotema;
    }
    
    public float getCantidadLados(){
        return this.cantidadLados;
    }
    
    public float getMedidaLado(){
        return this.medidaLado;
    }
    
    public float getMedidaApotema(){
        return this.medidaApotema;
    }
    
    @Override
    public String toString(){
        return "Poligono: {Cantidad de Lados: " + this.cantidadLados + ", Apotema: " + this.medidaApotema + ", Lado: " + this.medidaLado +  "}";
    }
    
    public float getPerimetro(){
        return this.cantidadLados * this.medidaLado;
    }
    
    public float getArea(){
        return ((this.cantidadLados * this.medidaLado) * this.medidaApotema)/2;
    }
    
}