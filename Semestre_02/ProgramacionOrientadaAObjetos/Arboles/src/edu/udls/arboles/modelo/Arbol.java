/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.arboles.modelo;

/**
 *
 * @author Ivan
 */
public class Arbol {
    public Nodo raiz;
    public int tamano;
    
    public Arbol(){}
    
    public int verTamano(){
        return this.tamano;
    }
    
    public void limpiar(){
        raiz = null;
        tamano = 0;
    }
    
    public void insertar(int valor){
        Nodo nuevoDato = new Nodo();
        nuevoDato.setValor(valor);
        if(this.raiz == null){
            this.raiz = nuevoDato;
            this.tamano = 1;
        }
        else insertar(nuevoDato, this.raiz);
    }
    
    public void insertar(Nodo nuevoDato, Nodo padre){
        if(nuevoDato.getValor() < padre.getValor()){
            if(padre.getIzquierda() == null){
                padre.setIzquerda(nuevoDato);
                this.tamano++;
            }else insertar(nuevoDato, padre.getIzquierda());
        }else{
            if(padre.getDerecha() == null){
                padre.setDerecha(nuevoDato);
                this.tamano++;
            }else insertar(nuevoDato, padre.getDerecha());
        }
    }
    
    // R I D
    public String imprimirPre(Nodo n){
        String msj = "";
        if(n != null) msj = " " + n.getValor() + imprimirPre(n.getIzquierda()) + imprimirPre(n.getDerecha());
        return msj;
    }
    
    // I D R
    public String imprimirPost(Nodo n){
        String msj = "";
        if(n != null) msj = imprimirPost(n.getIzquierda()) + imprimirPost(n.getDerecha()) + " " + n.getValor();
        return msj;
    }
    
    // I R D
    public String imprimirIn(Nodo n){
        String msj = "";
        if(n != null) msj = imprimirIn(n.getIzquierda()) + " " + n.getValor() + imprimirIn(n.getDerecha());
        return msj;
    }
}
