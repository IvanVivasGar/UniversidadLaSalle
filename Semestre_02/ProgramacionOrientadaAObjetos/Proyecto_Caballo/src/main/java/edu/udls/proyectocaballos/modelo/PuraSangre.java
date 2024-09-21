/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectocaballos.modelo;

/**
 *
 * @author Ivan
 */
public class PuraSangre {
    //1. ATRIBUTOS
    private PuraSangre madre;
    private PuraSangre padre;
    private int anioNacimiento;
    private Caballo caballo;
    
    //2. CONSTRUCTORES
    
    //2.1 CONSTRUCTOR VACIO
    public PuraSangre(){};
    
    //2.2 CONSTRUCTOR CARGADO
    public PuraSangre(PuraSangre madre, PuraSangre padre, int anioNacimiento, Caballo caballo)
    {
        this.madre = madre;
        this.padre = padre;
        this.anioNacimiento = anioNacimiento;
        this.caballo = caballo;
    }
    
    //3. GETTERS AND SETTERS
    public void setMadre(PuraSangre madre)
    {
        this.madre = madre;
    }
    
    public PuraSangre getMadre()
    {
        return madre;
    }

    public PuraSangre getPadre() {
        return padre;
    }

    public void setPadre(PuraSangre padre) {
        this.padre = padre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }
    
    //4. ToString
    @Override
    public String toString()
    {
        String mensaje = "";
        if (madre != null && padre != null){
            mensaje = "Caballo: [padre: " + padre + "]" + "[madre: " + madre + "]" + "[anio nacimiento: " + anioNacimiento + "]" + "[caballo: " + caballo + "]";
        } else {
            mensaje = "PuraSangre {" + "anioNacimiento= " + anioNacimiento + ", \n caballo= " + caballo.toString() + "}";
        }
        return mensaje;
    }
    
}
