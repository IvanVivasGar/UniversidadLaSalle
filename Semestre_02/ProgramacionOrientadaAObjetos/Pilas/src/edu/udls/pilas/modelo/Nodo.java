/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.pilas.modelo;

/**
 *
 * @author Ivan
 */
public class Nodo {
    private String valor;
    private Nodo anterior;
    
    public Nodo(){}
    
    public Nodo(String valor, Nodo anterior){
        this.valor = valor;
        this.anterior = anterior;
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }
    
    public String getValor(){
        return this.valor;
    }
    
    public Nodo getAnterior(){
        return this.anterior;
    }
}