/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.arreglosobjetos.modelo;

/**
 *
 * @author Ivan
 */
public class Alumno {
    public String nombre;
    public int matricula;
    public String carrera;
    public int semestre;
    public float promedio;
    
    public Alumno(){}
    
    public Alumno(String nombre, int matricula, String carrera, int semestre, float promedio){
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.semestre = semestre;
        this.promedio = promedio;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
    
    public void setPromedio(float promedio){
        this.promedio = promedio;
    }
    
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getMatricula(){
        return this.matricula;
    }
    
    public String getCarrera(){
        return this.carrera;
    }
    
    public float getPromedio(){
        return this.promedio;
    }
    
    public int getSemestre(){
        return this.semestre;
    }
    
    @Override
    public String toString(){
        return "Alumno {nombre: " + this.nombre + " , matricula: " + this.matricula + " , carrera: " + this.carrera + ", semestre: " + this.semestre + " , promedio: " + this.promedio + "}"; 
    }
}
