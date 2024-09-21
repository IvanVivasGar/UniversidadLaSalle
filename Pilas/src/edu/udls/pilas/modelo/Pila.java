/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.pilas.modelo;

/**
 *
 * @author Ivan
 */
public class Pila {
    private Nodo cima;
    private int tam;
    
    public Pila(){
        this.cima = null;
        this.tam = 0;
    }
    
    public void push(String valor){
        Nodo n = new Nodo();
        n.setValor(valor);
        
        if(tam == 0){
            cima = n;
            tam = 1;
        }else{
            n.setAnterior(this.cima);
            cima = n;
            tam++;
        }
    }
    
    public String pop(){
        String msj;
        
        if(this.tam >= 1){
            msj = "Eliminaste " + this.cima.getValor();
            this.cima = this.cima.getAnterior();
            this.tam--;
        }else{
            msj = "No hay elementos por eliminar";
        }
        
        return msj;
    }
    
    public int verTam(){
        return this.tam;
    }
    
    public String verCima(){
        return this.cima.getValor();
    }
    
    public void limpiarPila(){
        this.cima = null;
        this.tam = 0;
    }
}
