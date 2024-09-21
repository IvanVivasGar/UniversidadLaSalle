package edu.udls.arboles.modelo;

/**
 *
 * @author Ivan
 */

public class Nodo {
    private int valor;
    private Nodo izquierda;
    private Nodo derecha;
    
    public Nodo(){}
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public void setIzquerda(Nodo izquierda){
        this.izquierda = izquierda;
    }
    
    public void setDerecha(Nodo derecha){
        this.derecha = derecha;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public Nodo getIzquierda(){
        return this.izquierda;
    }
    
    public Nodo getDerecha(){
        return this.derecha;
    }
}