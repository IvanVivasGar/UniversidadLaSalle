package edu.udls.proyectoblockbuster.modelo;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class MovieList {
    public Node first;
    public Node current;
    public Node last;
    int size;
    
    public MovieList(){}
    
    public int size(){
        return this.size;
    }
    
    public String first(){
        return this.first.getMovieId() + this.first.getMovieName() + this.first.getMovieGenre() + this.first.getMovieYear() + this.first.getMovieLength();
    }
    
    public String current(){
        return this.current.getMovieId() + this.current.getMovieName() + this.current.getMovieGenre() + this.current.getMovieYear() + this.current.getMovieLength();
    }
    
    public String last(){
        return this.last.getMovieId() + this.last.getMovieName() + this.last.getMovieGenre() + this.last.getMovieYear() + this.last.getMovieLength();
    }
    
    public void clean(){
        this.first = null;
        this.current = null;
        this.last = null;
        this.size = 0;
    }
    
    public void add(String movieId, String movieName, String movieGenre, String movieYear, String movieLength){
        //LLAMAMOS A LOS VALORES DE TODOS LOS CAMPOS QUE TIENE EL NODO
        //CREAMOS UN NUEVO NODO Y LE AGREGAMOS LOS VALORES UTILIZANDO LOS SETTERS
        Node toAdd = new Node();
        toAdd.setMovieId(movieId);
        toAdd.setMovieName(movieName);
        toAdd.setMovieGenre(movieGenre);
        toAdd.setMovieYear(movieYear);
        toAdd.setMovieLength(movieLength);
        //DECLARAMOS EL NUEVO NODO COMO EL ACTUAL
        this.current = toAdd;
        
        //EN CASO DE QUE NO HAYA NODOS EN LA LISTA
        if (this.size == 0){
            //DECLARAMOS EL NODO NUEVO COMO EL PRIMERO Y EL ULTIMO, TAMBIEN ESTABLECEMOS QUE SU ANTERIOR Y SU SIGUIENTE SON NULOS
            this.first = toAdd;
            this.last = toAdd;
            toAdd.setPrevious(null);
            toAdd.setNext(null);
            //DECLARAMOS EL NODO ACTUAL COMO EL PRIMER NODO, DE MANERA QUE AL ACTUALIZAR EL CAMPO DE TEXTO DEL ACTUAL DE LA LISTA
            //LO MUESTRE CORRECTAMENTE Y NO MARQUE ERROR PORQUE NO HAY UN NODO ACTUAL
            this.current = this.first;
        }else {
            //DECLARAMOS EL NODO SIGUIENTE COMO NULO Y SU NODO ANTERIOR COMO EL ULTIMO NODO EN LA LISTA
            toAdd.setNext(null);
            toAdd.setPrevious(last);
            //DECLARAMOS EL SIGUIENTE NODO DEL ULTIMO NODO COMO EL NODO QUE AGREGAREMOS A LA LISTA
            last.setNext(toAdd);
            //DECLARAMOS AL NODO AGREGADO COMO EL ULTIMO
            last = toAdd;
            //EL ULTIMO NODO, ES DECIR EL QUE ACABAMOS DE AGREGAR SERA EL NODO ACTUAL
            this.current = this.last;
        }
        //SE AUMENTA EL TAMAÑO DE LA LISTA EN 1
        size++;
    }
    
    public void move(MovieList destinationList){
        //EL PARAMETRO TRAE LA LISTA DE DESTINACION, A LA QUE SE MOVERA EL NODO ACTUAL        
        //REVISA QUE HAYA NODOS EN LA LISTA
        if(this.size == 0){
            JOptionPane.showMessageDialog(null, "No hay peliculas para mover");
        }
        //REVISA SI HAY UNICAMENTE UN NODO EN LA LISTA
        else if(this.size == 1){
            //UTILIZA EL METODO ADD Y TRAIGO CADA CAMPO QUE DEBO AGREGAR AL NODO DE LA LISTA DE DESTINACION
            destinationList.add(this.current.getMovieId(), this.current.getMovieName(), this.current.getMovieGenre(), this.current.getMovieYear(), this.current.getMovieLength());
            //UTILIZO EL METODO CLEAN PARA LIMPIAR LA LISTA
            this.clean();
        }
        //REVISA SI EL NODO ACTUAL ES EL PRIMERO
        else if(this.current == this.first){
            //UTILIZA EL METODO ADD Y TRAIGO CADA CAMPO QUE DEBO AGREGAR AL NODO DE LA LISTA DE DESTINACION
            destinationList.add(this.current.getMovieId(), this.current.getMovieName(), this.current.getMovieGenre(), this.current.getMovieYear(), this.current.getMovieLength());
            //SE DECLARA EL SIGUIENTE AL PRIMERO COMO EL PRIMER NODO
            this.first = this.first.getNext();
            //SE DECLARA EL NODO SIGUIENTE DEL NODO ANTERIOR AL PRIMERO COMO NULO
            this.first.getPrevious().setNext(null);
            //SE DECLARA EL NODO ANTERIOR AL PRIMERO COMO NULO
            this.first.setPrevious(null);
            //SE DECLARA EL NODO ACTUAL COMO EL PRIMERO
            this.current = this.first;
            //SE DISMINUYE EN 1 EL TAMAÑO DE LA LISTA
            this.size--;
        }
        //REVISA SI EL NODO ACTUAL ES EL ULTIMO
        else if(this.current == this.last){
            //UTILIZA EL METODO ADD Y TRAIGO CADA CAMPO QUE DEBO AGREGAR AL NODO DE LA LISTA DE DESTINACION
            destinationList.add(this.current.getMovieId(), this.current.getMovieName(), this.current.getMovieGenre(), this.current.getMovieYear(), this.current.getMovieLength());
            //SE DECLARA COMO EL ULTIMO NODO AL ANTERIOR DEL ULTIMO NODO
            this.last = this.last.getPrevious();
            //SE DECLARA AL ANTERIOR DEL SIGUIENTE DEL NUEVO ULTIMO NODO COMO NULO
            this.last.getNext().setPrevious(null);
            //SE DECLARA AL SIGUIENTE DEL NUEVO ULTIMO COMO NULO
            this.last.setNext(null);
            //SE DECLARA AL NODO ACTUAL COMO EL ULTIMO NODO
            this.current = this.last;
            //SE DISMINUYE EN 1 EL TAMAÑO DE LA LISTA
            this.size--;
        }
        //SI EL NODO ACTUAL ESTA ENTRE LOS NODOS PRIMERO Y ULTIMO DE LA LISTA
        else{
            //UTILIZA EL METODO ADD Y TRAIGO CADA CAMPO QUE DEBO AGREGAR AL NODO DE LA LISTA DE DESTINACION
            destinationList.add(this.current.getMovieId(), this.current.getMovieName(), this.current.getMovieGenre(), this.current.getMovieYear(), this.current.getMovieLength());
            //SE DECLARA EL NUEVO NODO ACTUAL COMO EL ANTERIOR AL NODO ACTUAL
            this.current = this.current.getPrevious();
            //SE DECLARA AL SIGUIENTE DEL NODO ACTUAL COMO EL SIGUIENTE DEL SIGUIENTE DEL NODO ACTUAL
            this.current.setNext(this.current.getNext().getNext());
            //SE DECLARA AL ANTERIOR DEL SIGUIENTE DEL SIGUIENTE DEL NODO ACTUAL COMO EL NODO ACTUAL
            this.current.getNext().getNext().setPrevious(this.current);
            //SE DISMINUYE EN 1 EL TAMAÑO DE LA LISTA
            this.size--;
        }
    }
    
    public void moveAll(MovieList destinationList){
        //EL PARAMETRO TRAE LA LISTA DE DESTINACION, A LA QUE SE MOVERAN TODOS LOS NODOS DE LA LISTA
        //SE DECLARA EL NODO ACTUAL COMO EL PRIMERO
        this.current = this.first;
        
        //EL CICLO SE ASEGURA DE QUE EL NODO ACTUAL NO SEA NULO, DE MANERA QUE LOS GETTERS NO DEVUELVAN ERROR
        do{
            //UTILIZAMOS EL METODO ADD PARA AGREGAR TODOS LOS CAMPOS DEL NODO ACTUAL
            destinationList.add(this.current.getMovieId(), this.current.getMovieName(), this.current.getMovieGenre(), this.current.getMovieYear(), this.current.getMovieLength());
            //CAMBIAMOS AL NODO ACTUAL AL NODO SIGUIENTE AL ACTUAL
            this.current = this.current.getNext();
        }while(this.current != null);
        //LIMPIAMOS LA LISTA
        this.clean();
    }
    
    public void search(String value){
        //EL PARAMETRO TRAE EL CONTENIDO DEL CAMPO DE TEXTO DEL BUSCADOR
        if(this.size > 0){
            //EL PARAMETRO TRAE EL CONTENIDO DEL CAMPO DE TEXTO DEL BUSCADOR
            //DECLARAMOS UN BOOLEANO PARA LA BUSQUEDA DEL CONTENIDO DEL NODO
            boolean found = false;
            //DECLARAMOS UN CONTADOR PARA QUE NO SOBREPASE EL TAMAÑO DE LA LISTA
            int i = 0;
            //QUITAMOS LOS ESPACIOS Y LLEVAMOS EL CONTENIDO A MINUSCULAS
            value = value.replaceAll(" ", "").toLowerCase();

            //DECLARAMOS EL PRIMER NODO COMO EL ACTUAL PARA BUSCAR EN TODA LA LISTA
            this.current = this.first;
            //EL CICLO SE ASEGURA DE SEGUIR SI NO SE HA ENCONTRADO LA PELICULA Y SI EL CONTADOR ES MENOR AL TAMAÑO DE LA LISTA
            do{
                //SE GUARDAN EL CONTENIDO SIN ESPACIOS Y SIN COMAS DEL ID Y EL NOMBRE DEL NODO ACTUAL EN UNA VARIABLE TEMPORAL
                String temporalMovieName = this.current.getMovieName().toLowerCase().replaceAll(",", "").replaceAll(" ", "");
                String temporalMovieId = this.current.getMovieId().toLowerCase().replaceAll(",", "").replaceAll(" ", "");
                //SE UTILIZA LA FUNCION EQUALS PARA QUE COMPARE LOS VALORES DE LOS STRING Y NO LOS OBJETOS COMO TAL
                if(temporalMovieName.equals(value) || temporalMovieId.equals(value)){
                    found = true;
                    JOptionPane.showMessageDialog(null, "Pelicula encontrada " + this.current.getMovieName());
                }
                //SE REVISA QUE EL BOLEANO NO HAYA CAMBIADO A TRUE Y QUE EL SIGUIENTE NODO AL ACTUAL NO SEA NULO
                else if(this.current.getNext() != null && found != true){
                    //CAMBIA EL NODO ACTUAL AL SIGUIENTE
                    this.current = this.current.getNext();
                }
                i++;
            }while(found == false && i < this.size());
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay peliculas para buscar");
        }
    }
    
    public String enlist(MovieList list){
        String relist = "";
        
        //CONDICION QUE DETERMINA SI EN REALIDAD HAY ALGO EN LA LISTA
        if(list.current != null){
            int i = 1;
            //UN NODO QUE GUARDA TODA LA INFORMACION DEL NODO ACTUAL PARA QUE DESPUES DE ENLISTAR TODO DE NUEVO EL NODO ACTUAL SIGA SIENDO EL MISMO
            Node temporalValue = list.current;
            boolean reunitedValues = false;

            //CICLO QUE RECORRERA DE PELICULA EN PELICULA Y LA AGREGARA AL STRING PARA MOSTRARLO EN PANTALLA
            list.current = list.first;
            do{
                relist += list.current.getMovieId() + list.current.getMovieName() + list.current.getMovieGenre() + list.current.getMovieYear() + list.current.getMovieLength() + "\n";
                i++;
                list.current = list.current.getNext();
            }while(list.current != null);
        
            //CICLO QUE ESTABLECERA EL ACTUAL COMO EL ACTUAL CON EL QUE ENTRO AL METODO, BUSCANDO UNA IGUALDAD ENTRE EL TEMPORALVALUE Y EL GETMOVIE() DEL NODO ACTUAL
            list.current = list.first;
            do{
                //SE COMPARA EL NODO TEMPORAL CON EL ACTUAL
                if(list.current == temporalValue){
                    reunitedValues = true;
                }
                //DE OTRA MANERA SE SIGUE AL SIGUIENTE NODO
                else{
                    list.current = list.current.getNext();
                }
            }while(reunitedValues == false);
        }else{
            relist = "";
        }
        //SE RETORNA EL STRING CON LA LISTA DE PELICULAS COMPLETAS
        return relist;
    }
}
