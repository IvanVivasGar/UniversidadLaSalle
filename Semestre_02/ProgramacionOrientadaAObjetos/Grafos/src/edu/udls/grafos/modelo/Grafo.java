package edu.udls.grafos.modelo;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class Grafo {
    public List<Ciudad> listaCiudades;
    protected List<Camino> listaCaminos;

    public void Grafo(){}
    
    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public List<Camino> getListaCaminos() {
        return listaCaminos;
    }

    public void setListaCaminos(List<Camino> listaCaminos) {
        this.listaCaminos = listaCaminos;
    }
    
    public void addCiudad(String nombre, int lat, int lng, int poblacion){
        Ciudad c = new Ciudad();
        c.setNombre(nombre);
        c.setLat(lat);
        c.setLng(lng);
        c.setPoblacion(poblacion);
        this.listaCiudades.add(c);
    }
    
    public void addCamino(Ciudad origen, Ciudad destino, int distancia){
        Camino c = new Camino();
        c.setOrigen(origen);
        c.setDestino(destino);
        c.setDistancia(distancia);
        this.listaCaminos.add(c);
    }
    
    public int sizeCiudades(){
        return this.listaCiudades.size();
    }
    
    public int sizeCaminos(){
        return this.listaCaminos.size();
    }
    
    public int[][] crearMatriz()
    {
        int[][] matriz = new int[this.listaCiudades.size()][this.listaCiudades.size()];
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz.length; j++)
            {
                matriz[i][j] = buscarCamino(listaCiudades.get(i), listaCiudades.get(j));
            }
        }
        return matriz;
    }
    
    public int buscarCamino(Ciudad origen, Ciudad destino)
    {
        int r = 0;
        for (int i = 0; i < listaCaminos.size(); i++)
        {
            if (this.listaCaminos.get(i).getOrigen().getNombre().equalsIgnoreCase(origen.getNombre()) && this.listaCaminos.get(i).getDestino().getNombre().equalsIgnoreCase(destino.getNombre()))
            {
                r = listaCaminos.get(i).getDistancia();
            }
        }
        return r;
    }
    
    public String imprimirMatriz(int [][] matriz){
        String msj = "\t\t";
        
        for(int x = 0; x < matriz.length; x++){
            msj += listaCiudades.get(x).getNombre() + "\t";
        }
        
        msj += "\n";
        
        for(int i = 0; i < matriz[0].length; i++){
            msj += listaCiudades.get(i).getNombre() + "\t\t";
            for(int z = 0; z < matriz.length; z++){
                msj += matriz[z][i] + "\t";
            }
            msj += "\n";
        }
        return msj;
    }
}
