/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.archivos.modelo;
import edu.udls.archivos.control.GestorArchivos;

/**
 *
 * @author Ivan
 */
public class ListaPeliculas{
    Nodo inicio;
    Nodo fin;
    Nodo actual;
    Nodo indicador;
    int size;
    
    public ListaPeliculas(){}
    
    public void clean(){
        this.inicio = null;
        this.fin = null;
        this.actual = null;
        size = 0;
    }
    
    public int size(){
        return this.size;
    }
    
    public String first(){
        return this.inicio.getLinea();
    }
    
    public String actual(){
        return this.actual.getLinea();
    }
    
    public String last(){
        return this.fin.getLinea();
    }
    
    public String get(int i){
        if(i <= this.size()){
            actual = inicio;
            for(int z = 0; z < i; z++){
                actual = actual.getSiguiente();
            }
            return actual.getLinea();
        }
        else{
            return "No existe la posicion solicitada";
        }
    }
    
    public void add(String v, int i){
        Nodo n = new Nodo();
        n.setLinea(v);
        this.actual = n;
        
        if(size == 0){
            this.inicio = n;
            this.fin = n;
            n.setAnterior(null);
            n.setSiguiente(null);
        }
        else{
            if(i == 0){
                n.setAnterior(null);
                n.setSiguiente(inicio);
                inicio.setAnterior(n);
                inicio = n;
            }else if(i == size){
                n.setSiguiente(null);
                n.setAnterior(fin);
                fin.setSiguiente(n);
                fin = n;
            }else if(i > 0 && i < size){
                actual = inicio;
                
                for(int z = 0; z < i; z++){
                    actual = actual.getSiguiente();
                }
                
                
                actual.getSiguiente().setAnterior(n);
                n.setSiguiente(actual.getSiguiente());
                n.setAnterior(actual);
                actual.setSiguiente(n);
                
                this.actual = n;
                
            }else if(i > size){
                
                for(int z = size; z < (i - 1); z++){
                    Nodo nulo = new Nodo();
                    nulo.setLinea(null);
                    
                    nulo.setSiguiente(null);
                    nulo.setAnterior(fin);
                    fin.setSiguiente(nulo);
                    fin = nulo;
                    size++;
                }
                
                n.setSiguiente(null);
                n.setAnterior(fin);
                fin.setSiguiente(n);
                fin = n;
            }
        }
        size++;
    }
    
    public String remove(int i){
        String msj = "";
        
        if(i == 0){
            msj = "El valor eliminado es: " + inicio.getLinea();
            inicio.getSiguiente().setAnterior(null);
            inicio = inicio.getSiguiente();
            size--;
        }else if(i == (size - 1)){
            msj = "El valor eliminado es: " + fin.getLinea();
            fin.getAnterior().setSiguiente(null);
            fin = fin.getAnterior();
            size--;
        }else if(i > 0 && i < (size - 1)){
            actual = inicio;
            
            for(int z = 0; z < i; z++){
                actual = actual.getSiguiente();
            }
            
            msj = "El valor eliminado es: " + actual.getLinea();
            
            actual.getSiguiente().setAnterior(actual.getAnterior());
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            size--;
        }else{
            msj = "No existe la posicion que deseas eliminar";
        }
        
        return msj;
    }
}
