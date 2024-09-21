package edu.udls.basededatostienda.control;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ivan
 */
public class Connector {
    public static final String URL = "jdbc:mysql://localhost:3306/tienda";
    public static final String USER = "root";
    public static final String CLAVE = "root";
    
    public Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return con;
    }
}
