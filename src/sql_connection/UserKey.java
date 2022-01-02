/*
 * Clase sencilla para aplicar la herencia. Solo contiene las credenciales
 * necesarias para establecer conexion con la BD
 */

package sql_connection;

/**
 * 
 * @author Eduardo Ruiz Rios
 */
public abstract class UserKey {
    
    private static final String USER = "root";
    private static final String PASSWORD = "lalo123";
    private static final String URL = "jdbc:mysql://localhost:3306/restaurante?serverTimezone=UTC";
    
    
    public String getUser() {
        return USER;
    }
    
    public String getPassword() {
        return PASSWORD;
    }
    
    public String getURL() {
        return URL;
    }
    
    //Metodos vacios que serán anulados/redefinidos en la clase hija
    
    abstract void setConnection(); //metodo para establecer conexion con la BD
    
    abstract void disconnect(); //metodo para desconectarse de la BD
}
