/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectofiguras.modelo;

/**
 *
 * @author Ivan
 */
public class TrianguloEscaleno extends Figura{
    float base;
    float altura;
    float ladoIzquierdo;
    float ladoDerecho;
    
    public TrianguloEscaleno(){}
    
    public TrianguloEscaleno(float base, float altura, float ladoIzquierdo, float ladoDerecho){
        this.base = base;
        this.altura = altura;
        this.ladoIzquierdo = ladoIzquierdo;
        this.ladoDerecho = ladoDerecho;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLadoIzquierdo() {
        return ladoIzquierdo;
    }

    public void setLadoIzquierdo(float ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }

    public float getLadoDerecho() {
        return ladoDerecho;
    }

    public void setLadoDerecho(float ladoDerecho) {
        this.ladoDerecho = ladoDerecho;
    }
    
    @Override
    public String toString(){
        return "Triangulo Isoceles: {altura: " + this.altura + ", base: " + this.base + ", lado Izquierdo: " + this.ladoIzquierdo + ", lado Derecho: " + this.ladoDerecho + "}";
    }
    
    public float getArea(){
        return this.base * this.altura;
    }
    
    public float getPerimetro(){
        return this.base + this.ladoDerecho + this.ladoIzquierdo;
    }
    
}