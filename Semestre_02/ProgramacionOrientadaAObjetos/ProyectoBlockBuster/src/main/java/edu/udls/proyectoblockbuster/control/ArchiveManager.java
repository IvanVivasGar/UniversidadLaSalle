package edu.udls.proyectoblockbuster.control;
import edu.udls.proyectoblockbuster.modelo.MovieList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */

public class ArchiveManager{
    public static String leerArchivo(String ruta, MovieList movies){
        //COMO PARAMETROS TRAIGO LA RUTA DEL ARCHIVO A LEER Y LA LISTA DE PELICULAS
        String content = "";
        try{
            File archivo = new File(ruta); //SE ABRE EL ARCHIVO
            FileReader lector = new FileReader(archivo); //SE LEE EL ARCHIVO
            BufferedReader br = new BufferedReader(lector); //SE COLOCA DE MANERA TEMPORAL TODO EL CONTENIDO DEL ARCHIVO
            
            //LEER CADA LINEA Y HAY QUE UNIRLO
            String line = "";
            while((line = br.readLine()) != null){
                content += line + "\n";
                //UTILIZAMOS EL INFEX OF PARA OBTENER LA POSICION DE LAS COMAS Y DESPUES DIVIDIR LA LINEA PARA AGREGAR CADA DIVISION A CADA CAMPO
                int positionComaId = line.indexOf(",");
                int positionComaName = line.indexOf(",", positionComaId + 1);
                int positionComaGenre = line.indexOf(",", positionComaName + 1);
                int positionComaYear = line.indexOf(",", positionComaGenre + 1);
                movies.add(
                        line.substring(0, positionComaId), 
                        line.substring(positionComaId, positionComaName),
                        line.substring(positionComaName, positionComaGenre),
                        line.substring(positionComaGenre, positionComaYear),
                        line.substring(positionComaYear)
                );
            }
            //SE CIERRAN LOS ELEMENTOS
            br.close();
            lector.close();
        }
        catch(Exception e){
            e.printStackTrace();
            content = "Error en la lectura del archivo" + e.toString();
        }
        return content;
    }
    
    public static void reescribirArchivo(String route, MovieList movies){
        try{
            //SE CREA UN BUFFERED WRITER PARA ESCRIBIR LAS LINEAS, COMO PARAMETRO SE CREA UN FILEWRITER CON LA RUTA Y EL FALSE QUE SIGNIFICA QUE
            //REESCRIBIRA EL ARCHIVO, NO AGREGARA LOS ELEMENTOS DE LA LISTA AL FINAL DEL CONTENIDO DE ESTE, EL FILEWRITER ESCRIBIRA CARACTER POR
            //CARACTER
            BufferedWriter bw = new BufferedWriter(new FileWriter(route, false));
            
            //SE EMPIEZA DECLARANDO EL ACTUAL COMO EL PRIMERO
            movies.current = movies.first;
            
            //SE INDICA QUE ESCRIBIRA EL ARCHIVO MIENTRAS EL NODO ACTUAL NO SEA NULO
            while(movies.current != null){
                //SE GUARDA EN UNA LINEA TEMPORAL EL CONTENIDO DEL NODO, ORDENADO
                String line = movies.current.getMovieId() + movies.current.getMovieName() + movies.current.getMovieGenre() + movies.current.getMovieYear() + movies.current.getMovieLength();
                //EL BUFFERED WRITER ESCRIBE LA LINEA EN EL ARCHIVO
                bw.write(line);
                //EL BUFFERED WRITER CREA UNA NUEVA LINEA PARA AGREGAR EL CONTENIDO DEL SIGUIENTE NODO EN ELLA
                bw.newLine();
                //SE ACTUALIZA EL NODO ACTUAL AL SIGUIENTE
                movies.current = movies.current.getNext();
            }
            //SE CIERRA EL BUFFERED WRITER
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la reescritura del archivo");
        }
    }
}