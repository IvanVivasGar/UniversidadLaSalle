package edu.udls.grafos.control;
import edu.udls.grafos.modelo.Ciudad;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class Busqueda {
    public static int buscarIndiceCiudad(String nombre, List<Ciudad> listaCiudades){
        //CICLO QUE RECORRE LA LISTA DESDE EL PRIMER INDICE HASTA EL FINAL
        for(int i = 0; i < listaCiudades.size(); i++){
            //CONDICION QUE COMPARA EL NOMBRE DEL INDICE ACTUAL CON EL NOMBRE QUE SE DESEA ENCONTRAR
            if(listaCiudades.get(i).getNombre().equalsIgnoreCase(nombre)){
                //SI LO ENCUENTRA, REGRESA EL INDICE ACTUAL
                return i;
            }
        }
        //SI TERMINA EL CICLO SIN ENCONTRAR UNO, SE RETORNA UN -1 PARA MOSTRAR QUE NO EXISTE TAL ELEMENTO
        return -1;
    }
}