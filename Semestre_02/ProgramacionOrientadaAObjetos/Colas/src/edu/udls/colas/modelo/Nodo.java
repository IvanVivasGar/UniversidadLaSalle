package edu.udls.colas.modelo;

/**
 *
 * @author Ivan
 */

public class Nodo {
    private String valor;
    private Nodo siguiente;
    private int prioridad;
    
    public Nodo(){}
    
    public Nodo(String valor, int prioridad){
        this.valor = valor;
        this.prioridad = prioridad;
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    public String getValor(){
        return this.valor;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
    public Nodo getSiguiente(){
        return this.siguiente;
    }

    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }
    
    public int getPrioridad(){
        return this.prioridad;
    }
}
