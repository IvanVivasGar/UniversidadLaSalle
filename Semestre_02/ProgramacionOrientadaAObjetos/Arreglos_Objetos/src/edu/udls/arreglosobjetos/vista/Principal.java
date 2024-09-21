/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.arreglosobjetos.vista;
import edu.udls.arreglosobjetos.controlador.Operaciones;
import static edu.udls.arreglosobjetos.controlador.Operaciones.calcularPromedioGeneral;
import edu.udls.arreglosobjetos.modelo.Alumno;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class Principal {
    public static void main(String args[]){
        Alumno[][] arregloGrupo = pedirDatos();
        float[] arregloPromedios = Operaciones.calcularPromedioGrupal(arregloGrupo);
        imprimirDatos(arregloGrupo);
        JOptionPane.showMessageDialog(null, imprimirPromedios(arregloPromedios));
        JOptionPane.showMessageDialog(null, "El promedio general de todos los grupos es de: " + calcularPromedioGeneral(arregloPromedios));  
        menuOrdenamientos(arregloGrupo);
    }
    
    public static Alumno[][] pedirDatos(){
        int tam, cantGrupos;
        
        cantGrupos = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de grupos"));
        tam = Integer.parseInt(JOptionPane.showInputDialog("Tamaño de grupos"));
        
        Alumno[][] arregloGrupo = new Alumno[tam][cantGrupos];
        
        for (int i = 0; i < arregloGrupo[0].length; i++){
            for (int z = 0; z < arregloGrupo.length; z++){
                String nombre = JOptionPane.showInputDialog("Ingresa el nombre del alumno " + (z+1) + " del grupo " + (i+1));
                int matricula = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la matricula del alumno " + (z+1) + " del grupo " + (i+1)));
                String carrera = JOptionPane.showInputDialog("Ingresa la carrera del alumno " + (z+1) + " del grupo " + (i+1));
                int semestre = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el semestre en el que se encuentra el alumno " + (z+1) + " del grupo " + (i+1)));
                float promedio = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el promedio del alumno " + (z+1) + " del grupo " + (i+1)));
                Alumno objAlumno = new Alumno(nombre, matricula, carrera, semestre, promedio);
                arregloGrupo[z][i] = objAlumno;
            }
        }
        return arregloGrupo;
    }
    
    public static String imprimirDatos(Alumno[][] arregloGrupo){
        String mensaje = "Los datos de los alumnos del grupo son: \n";
        
        for (int i = 0; i < arregloGrupo[0].length; i++){
            for(int z = 0; z < arregloGrupo.length; z++){    
                mensaje+=arregloGrupo[z][i].toString()+"\n";
            }
            mensaje+="\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
        
        return mensaje;
    }
    
    public static String imprimirPromedios(float[] arregloPromedios){
        String mensajePromedios = "El promedio de los grupos son de: ";
        
        for(int i = 0; i < arregloPromedios.length; i++){
            mensajePromedios += "\nGrupo " + (i + 1) + ": " + arregloPromedios[i];
        }
        return mensajePromedios;
    }
    
    public static void menuOrdenamientos(Alumno[][] arregloGrupo){
        //La variable decision guarda el metodo de ordenamiento que el usuario eligio
        String decision = JOptionPane.showInputDialog("Ingrese el metodo de ordenamiento que desea");
        decision = decision.toLowerCase();
        
        //La variale decisionAsDes guarda la decision del usuario en cuanto a si quiere que el ordenamiento sea ascendente o descendente
        String decisionAsDes = JOptionPane.showInputDialog("Deseas que el orden sea ¿Ascendente o Descendente?");
        decisionAsDes = decisionAsDes.toLowerCase();
        
        //La variable campo guarda el campo por el que el usuario desea ordenar los datos
        String campo = JOptionPane.showInputDialog("Ingrese el campo por el que desea ordenar el arreglo:");
        campo = campo.toLowerCase();
        
        switch(decision){
            case "intercambio":
                Operaciones.ordenamientoIntercambio(arregloGrupo, campo, decisionAsDes);
                imprimirDatos(arregloGrupo);
            break;
            
            case "seleccion":
                Operaciones.ordenamientoSeleccion(arregloGrupo, campo, decisionAsDes);
                imprimirDatos(arregloGrupo);
            break;
            
            case "insercion":
                Operaciones.ordenamientoInsercion(arregloGrupo, campo, decisionAsDes);
                imprimirDatos(arregloGrupo);
            break;
            
            default:
                throw new IllegalArgumentException("Metodo de ordenamieno invalido: " + decision);
        }
    }
}