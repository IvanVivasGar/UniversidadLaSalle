/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.listasd.modelo;

/**
 *
 * @author Ivan
 */
public class Nodo {
    private String valor;
    private Nodo anterior;
    private Nodo siguiente;
    
    public Nodo(){}
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    public String getValor(){
        return this.valor;
    }
    
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }
    
    public Nodo getAnterior(){
        return this.anterior;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
    public Nodo getSiguiente(){
        return this.siguiente;
    }
    
    public String toString(){
        return "Nodo:{valor: " + this.valor + ",anterior: " + this.anterior.getValor() + ",siguiente: " + this.siguiente.getValor() + "}";
    }
}
