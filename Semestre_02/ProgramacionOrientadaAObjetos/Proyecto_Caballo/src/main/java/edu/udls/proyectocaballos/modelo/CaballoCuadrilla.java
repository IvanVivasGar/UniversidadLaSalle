/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectocaballos.modelo;

/**
 *
 * @author Ivan
 */
public class CaballoCuadrilla {
    //1. ATRIBUTOS
    float altura;
    float peso;
    Caballo caballo;
    
    //2.CONSTRUCTORES
    
    //2.1 CONSTRUCTOR VACIO
    public CaballoCuadrilla (){}
    
    //2.2 CONSTRUCTOR CARGADO
    public CaballoCuadrilla(float altura, float peso, Caballo caballo)
    {
        this.altura = altura;
        this.peso = peso;
        this.caballo = caballo;
    }
    
    //3. GETTERS AND SETTERS
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }
    
    //4. TOSTRING
    @Override
    public String toString()
    {
        String mensaje = "Caballo: [altura: " + altura + "]" + "[peso: " + peso + "]" + "[caballo: " + caballo + "]";
        return mensaje;
    }
}
