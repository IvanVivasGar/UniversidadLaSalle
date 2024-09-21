package edu.udls.grafos.modelo;

/**
 *
 * @author Ivan
 */
public class Camino {
    Ciudad origen;
    Ciudad destino;
    int distancia;

    public Camino(){}
    
    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Camino{" + "origen=" + origen + "; destino=" + destino + "; distancia=" + distancia + '}';
    }
}
