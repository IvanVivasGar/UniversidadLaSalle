package edu.udls.grafos.modelo;

/**
 *
 * @author Ivan
 */
public class Ciudad {
    String nombre;
    int lat;
    int lng;
    int poblacion;
    
    public Ciudad(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "nombre=" + nombre + "; lat=" + lat + "; lng=" + lng + "; poblacion=" + poblacion + '}';
    }
}
