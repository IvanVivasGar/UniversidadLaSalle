package edu.udls.proyectoblockbuster.modelo;

/**
 *
 * @author Ivan
 */

public class Node {
    private String movieId;
    private String movieName;
    private String movieGenre;
    private String movieYear;
    private String movieLength;
    private Node previous;
    private Node next;
    
    public Node(){}
    
    public void setPrevious(Node previous){
        this.previous = previous;
    }
    
    public Node getPrevious(){
        return this.previous;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    public Node getNext(){
        return this.next;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }
    
    public String getMovieName(){
        return this.movieName;
    }
    
    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }
}
