// Ejemplo de programa que se conecta a una BD de MySQL Workbench

package sql_connection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class SQL_Connection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String user = "root";
        String password = "lalo123";
        String url = "jdbc:mysql://localhost:3306/restaurante?serverTimezone=UTC";
        
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQL_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            //stmt.execute("INSERT INTO meseros VALUES ('MRR', 'Mimi', 'Ruiz', 'Rios', 'V')");
            
            rs = stmt.executeQuery("SELECT * FROM meseros");
            rs.next();
            
            System.out.println("ID_Mesero | Nombre_Mesero | ApellidoP | ApellidoM | Turno");
            
            do {
                System.out.println(rs.getString("ID_Mesero") + " | " + rs.getString("Nombre_Mesero") + " | "
                + rs.getString("ApellidoP") + " | " + rs.getString("ApellidoM") + " | " + rs.getString("Turno"));
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
    
}
