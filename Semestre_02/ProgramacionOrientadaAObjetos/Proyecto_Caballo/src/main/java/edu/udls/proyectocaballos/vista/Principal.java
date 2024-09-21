/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udls.proyectocaballos.vista;
import edu.udls.proyectocaballos.modelo.PuraSangre;
import edu.udls.proyectocaballos.modelo.Caballo;

/**
 *
 * @author Ivan
 */
public class Principal {
    public static void main(String args[]){
        Caballo objCaballoP = new Caballo("Potro mayor");
        PuraSangre objPadre = new PuraSangre();
        objPadre.setCaballo(objCaballoP);
        objPadre.setAnioNacimiento(2011);

        Caballo objCaballoM = new Caballo("La Bonita");
        PuraSangre objMadre = new PuraSangre();
        objMadre.setCaballo(objCaballoM);
        objMadre.setAnioNacimiento(2010);

        Caballo objCaballo = new Caballo("Potrillo");
        PuraSangre objPS = new PuraSangre(objMadre, objPadre, 2015, objCaballo);

        System.out.println(objPS.toString());
    }
}
