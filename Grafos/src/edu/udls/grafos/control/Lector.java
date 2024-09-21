package edu.udls.grafos.control;

import edu.udls.grafos.modelo.Camino;
import edu.udls.grafos.modelo.Ciudad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class Lector {
    public static List<Ciudad> leerCiudades(String ruta){
        List<Ciudad> listaCiudades = new ArrayList<>();
        
        try{
            File archivo = new File(ruta); //SE ABRE EL ARCHIVO
            FileReader lector = new FileReader(archivo); //SE LEE EL ARCHIVO
            BufferedReader br = new BufferedReader(lector); //SE COLOCA DE MANERA TEMPORAL TODO EL CONTENIDO DEL ARCHIVO
            
            //LEER CADA LINEA Y HAY QUE UNIRLO
            String line = "";
            while((line = br.readLine()) != null){
                //UTILIZAMOS EL INFEX OF PARA OBTENER LA POSICION DE LAS COMAS Y DESPUES DIVIDIR LA LINEA PARA AGREGAR CADA DIVISION A CADA CAMPO
                int positionComaName = line.indexOf(",");
                int positionComaLat = line.indexOf(",", positionComaName + 1);
                int positionComaLng = line.indexOf(",", positionComaLat + 1);
                
                Ciudad temp = new Ciudad();
                temp.setNombre(line.substring(0, positionComaName));
                
                positionComaName++;
                String lat = line.substring(positionComaName, positionComaLat);
                int latInt = Integer.parseInt(lat);
                temp.setLat(latInt);
                
                positionComaLat++;
                String lng = line.substring(positionComaLat, positionComaLng);
                int lngInt = Integer.parseInt(lng);
                temp.setLng(lngInt);
                
                positionComaLng++;
                String poblacion = line.substring(positionComaLng);
                int lngPoblacion = Integer.parseInt(poblacion);
                temp.setPoblacion(lngPoblacion);
                
                listaCiudades.add(temp);
            }
            //SE CIERRAN LOS ELEMENTOS
            br.close();
            lector.close();
            
            return listaCiudades;
        }
        catch(Exception e){
            e.printStackTrace();
            return listaCiudades;
        }
    }
    
    public static List<Camino> leerCaminos(String ruta, List<Ciudad> listaCiudades){
        List<Camino> listaCaminos = new ArrayList<>();
        
        try{
            File archivo = new File(ruta); //SE ABRE EL ARCHIVO
            FileReader lector = new FileReader(archivo); //SE LEE EL ARCHIVO
            BufferedReader br = new BufferedReader(lector); //SE COLOCA DE MANERA TEMPORAL TODO EL CONTENIDO DEL ARCHIVO
            
            //LEER CADA LINEA Y HAY QUE UNIRLO
            String line = "";
            while((line = br.readLine()) != null){
                //UTILIZAMOS EL INFEX OF PARA OBTENER LA POSICION DE LAS COMAS Y DESPUES DIVIDIR LA LINEA PARA AGREGAR CADA DIVISION A CADA CAMPO
                int positionComaNameOrigen = line.indexOf(",");
                int positionComaNameDestino = line.indexOf(",", positionComaNameOrigen + 1);
                
                String tempNameOrigen = line.substring(0, positionComaNameOrigen);
                positionComaNameOrigen++;
                String tempNameDestino = line.substring(positionComaNameOrigen, positionComaNameDestino);
                positionComaNameDestino++;
                int tempDistancia = Integer.parseInt(line.substring(positionComaNameDestino));
                
                Camino temp = new Camino();
                
                if(Busqueda.buscarIndiceCiudad(tempNameOrigen, listaCiudades) != -1 && Busqueda.buscarIndiceCiudad(tempNameDestino, listaCiudades) != -1){
                    temp.setOrigen(listaCiudades.get(Busqueda.buscarIndiceCiudad(tempNameOrigen, listaCiudades)));
                    temp.setDestino(listaCiudades.get(Busqueda.buscarIndiceCiudad(tempNameDestino, listaCiudades)));
                    temp.setDistancia(tempDistancia);

                    listaCaminos.add(temp);
                }
            }
            //SE CIERRAN LOS ELEMENTOS
            br.close();
            lector.close();
            
            return listaCaminos;
        }
        catch(Exception e){
            e.printStackTrace();
            return listaCaminos;
        }
    }
}