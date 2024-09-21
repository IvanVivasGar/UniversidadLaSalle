/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.archivos.control;
import edu.udls.archivos.modelo.ListaPeliculas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Ivan
 */

public class GestorArchivos {
    public static String leerArchivo(ListaPeliculas listado, String ruta){
        int i = 0;
        String contenido = "";
        try{
            File archivo = new File(ruta); //SE ABRE EL ARCHIVO
            FileReader lector = new FileReader(archivo); //SE LEE EL ARCHIVO
            BufferedReader br = new BufferedReader(lector); //SE COLOCA DE MANERA TEMPORAL TODO EL CONTENIDO DEL ARCHIVO
            
            //LEER CADA LINEA Y HAY QUE UNIRLO
            String linea = "";
            while((linea = br.readLine()) != null){
                contenido += i + ". " + linea + "\n";
                listado.add(linea, i);
                i++;
            }
            //SE CIERRAN LOS ELEMENTOS
            br.close();
            lector.close();
        }
        catch(Exception e){
            e.printStackTrace();
            contenido = "Error en la lectura del archivo" + e.toString();
        }
        return contenido;
    }
}
