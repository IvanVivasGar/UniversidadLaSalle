package edu.udls.colas.modelo;

/**
 *
 * @author Ivan
 */

public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tam;
    
    public void encolar(String valor, int prioridad){
        Nodo n = new Nodo(valor, prioridad);

        if (this.tam == 0) {
            this.frente = n;
            this.fin = n;
        } else {
            Nodo temp = this.frente;
            Nodo anterior = null;

            while (temp != null && temp.getPrioridad() >= prioridad) {
                anterior = temp;
                temp = temp.getSiguiente();
            }

            if (anterior == null) {
                n.setSiguiente(this.frente);
                this.frente = n;
            } else if (temp == null) {
                this.fin.setSiguiente(n);
                this.fin = n;
            } else {
                anterior.setSiguiente(n);
                n.setSiguiente(temp);
            }
        }
        this.tam++;
    }
    
    public String desencolar(){
        String valor = "";
    
        if (this.tam == 0) {
            valor = "Cola vacía";
        } else {
            Nodo temp = this.frente;
            Nodo anterior = null;
            Nodo nodoPrioritario = this.frente;
            Nodo nodoPrevioPrioritario = null;
    
            while (temp != null) {
                if (temp.getPrioridad() > nodoPrioritario.getPrioridad()) {
                    nodoPrioritario = temp;
                    nodoPrevioPrioritario = anterior;
                }
                anterior = temp; 
                temp = temp.getSiguiente();
            }
    
            if (nodoPrioritario == this.frente) { 
                this.frente = this.frente.getSiguiente();
            } else if (nodoPrioritario == this.fin) {
                this.fin = nodoPrevioPrioritario;
                nodoPrevioPrioritario.setSiguiente(null);
            } else {
                nodoPrevioPrioritario.setSiguiente(nodoPrioritario.getSiguiente());
            }
    
            valor = nodoPrioritario.getValor();
            this.tam--;
        }
    
        return valor;
    }

    public Nodo getFrente() {
        return this.frente;
    }

    public Nodo getFin() {
        return this.fin;
    }

    public int getTam() {
        return this.tam;
    }
    
    public void limpiar(){
        this.frente = null;
        this.fin = null;
        this.tam = 0;
    }
    
    public boolean vacio(){
        if(this.tam == 0){
            return true;
        }else{
            return false;
        }
    }
}