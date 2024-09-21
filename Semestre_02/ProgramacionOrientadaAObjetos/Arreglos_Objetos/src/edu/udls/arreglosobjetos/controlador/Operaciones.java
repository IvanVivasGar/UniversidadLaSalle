/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.arreglosobjetos.controlador;
import edu.udls.arreglosobjetos.modelo.Alumno;

/**
 *
 * @author Ivan
 */
public class Operaciones {
    public static float[] calcularPromedioGrupal(Alumno[][] arregloGrupo){
        float [] arregloPromedios = new float [arregloGrupo[0].length];
        float sumatoria = 0;
        
        for(int i = 0; i < arregloGrupo[0].length; i++){
            for(int z = 0; z < arregloGrupo.length; z++){
                sumatoria += arregloGrupo[z][i].getPromedio();
            }
            arregloPromedios[i] = sumatoria / arregloGrupo.length;
            sumatoria = 0;
        }
        
        return arregloPromedios;
    }
    
    public static float calcularPromedioGeneral(float[] arregloPromedios){
        float sumatoria = 0, promedioGeneral;
        
        for(int i = 0; i < arregloPromedios.length; i++){
            sumatoria += arregloPromedios[i];
        }
        
        promedioGeneral = sumatoria / arregloPromedios.length;
        return promedioGeneral;
    }
    
    public static void ordenamientoIntercambio(Alumno[][] arregloGrupo, String campo, String decisionAsDes){
        Alumno[] temporal = new Alumno[1];

        switch(decisionAsDes){
            case "ascendente":
                for(int z = 0; z < arregloGrupo[0].length; z++){
                    for(int i = 0; i < (arregloGrupo.length - 1); i++){
                        if(comparador(arregloGrupo[i][z], arregloGrupo[i+1][z], campo) > 0){
                            temporal[0] = arregloGrupo[i][z];
                            arregloGrupo[i][z] = arregloGrupo[i+1][z];
                            arregloGrupo[i+1][z] = temporal[0];
                        }
                    }
                }
            break;
                
            case "descendente":
                for(int z = 0; z < arregloGrupo[0].length; z++){
                    for(int i = 0; i < (arregloGrupo.length - 1); i++){
                        if(comparador(arregloGrupo[i][z], arregloGrupo[i+1][z], campo) < 0){
                            temporal[0] = arregloGrupo[i][z];
                            arregloGrupo[i][z] = arregloGrupo[i+1][z];
                            arregloGrupo[i+1][z] = temporal[0];
                        }
                    }
                }
            break;
        }
    }
    
    public static void ordenamientoSeleccion(Alumno[][] arregloGrupo, String campo, String decisionAsDes){
        int posicion;
        Alumno[] temporal = new Alumno[1];
        Alumno[] menor = new Alumno[1];
        
        switch(decisionAsDes){
            case "ascendente":
                for(int z = 0; z < arregloGrupo[0].length; z++){
                    for(int i = 0; i < (arregloGrupo.length - 1); i++){
                        menor[0] = arregloGrupo[i][z];
                        posicion = i;
                        for(int j = i + 1; j < arregloGrupo.length; j++){
                            if (comparador(arregloGrupo[j][z], menor[0], campo) < 0){
                                menor[0] = arregloGrupo[j][z];
                                posicion = j;
                            }
                        }

                        if (posicion != i){                      
                            temporal[0] = arregloGrupo[i][z];
                            arregloGrupo[i][z] = arregloGrupo[posicion][z];
                            arregloGrupo[posicion][z] = temporal[0];
                        }
                    }
                }
            break;
            
            case "descendente":
                for(int z = 0; z < arregloGrupo[0].length; z++){
                    for(int i = 0; i < (arregloGrupo.length - 1); i++){
                        menor[0] = arregloGrupo[i][z];
                        posicion = i;
                        for(int j = i + 1; j < arregloGrupo.length; j++){
                            if (comparador(arregloGrupo[j][z], menor[0], campo) > 0){
                                menor[0] = arregloGrupo[j][z];
                                posicion = j;
                            }
                        }

                        if (posicion != i){                      
                            temporal[0] = arregloGrupo[i][z];
                            arregloGrupo[i][z] = arregloGrupo[posicion][z];
                            arregloGrupo[posicion][z] = temporal[0];
                        }
                    }
                }
            break;
        }
        
    }
    
    public static void ordenamientoInsercion(Alumno[][] arregloGrupo, String campo, String decisionAsDes){
        Alumno[] temporal = new Alumno[1];
        
        switch(decisionAsDes){
            case "ascendente":
                for(int y = 0; y < arregloGrupo[0].length; y++){
                    for(int i = 1; i < arregloGrupo.length; i++){
                        temporal[0] = arregloGrupo[i][y];
                        int z = i - 1;

                        while(z >= 0 && comparador(arregloGrupo[z][y], temporal[0], campo) > 0){
                            arregloGrupo[z + 1][y] = arregloGrupo[z][y];
                            z = z - 1;
                        }
                        arregloGrupo[z + 1][y] = temporal[0];
                    }
                }
            break;
            
            case "descendente":
                for(int y = 0; y < arregloGrupo[y].length; y++){
                    for(int i = 1; i < arregloGrupo.length; i++){
                        temporal[0] = arregloGrupo[i][y];
                        int z = i - 1;

                        while(z >= 0 && comparador(arregloGrupo[z][y], temporal[0], campo) < 0){
                            arregloGrupo[z + 1][y] = arregloGrupo[z][y];
                            z = z - 1;
                        }
                        arregloGrupo[z + 1][y] = temporal[0];
                    }
                }
            break;
        }
    }
    
    private static int comparador(Alumno a, Alumno b, String campo){
        switch(campo){
            case "nombre":
                return a.nombre.compareTo(b.nombre);
            case "carrera":
                return a.carrera.compareTo(b.carrera);
            case "semestre":
                return Integer.compare(a.semestre, b.semestre);
            case "matricula":
                return Integer.compare(a.matricula, b.matricula);
            case "promedio":
                return Float.compare(a.promedio, b.promedio);
            default:
                throw new IllegalArgumentException("Campo inválido: " + campo);
        }
    }
}
