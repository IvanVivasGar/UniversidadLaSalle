/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectocaballos.modelo;

/**
 *
 * @author Ivan
 */
public class Caballo {
    //1. ATRIBUTOS DE LA CLASE
    private String nombre;
    
    //2.1 CONSTRUCTOR VACIO
    public Caballo(){}
    
    //2.2 CONSTRUCTOR CARGADO
    public Caballo (String nombre)
    {
        this.nombre = nombre;
    }
    
    //3. GETTERS AND SETTERS
    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre ()
    {
        return nombre;
    }
    
    //4. METODO TOSTRING
    @Override
    public String toString()
    {
        String mensaje = "Caballo: [nombre: " + nombre + "]";
        return mensaje;
    }
    
}
