package sql_connection;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;

/**
 *
 * @author Eduardo Ruiz Rios
 */
public class BD_Connection extends UserKey {
    
    private Connection con;
    private ResultSet rs;
    private Statement stmt;
    
    
    public ResultSet getRS() {
        return rs;
    }
    
    public Statement getStmt() {
        return stmt;
    }
    
    @Override
    public void setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(super.getURL(), super.getUser(), super.getPassword());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "ERROR: something went wrong while trying to establish connection to DB.", "Cannot establish connection to DB", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void createStmt() {
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public boolean runQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "ERROR: cannot execute query.", "Connection Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    @Override
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong while disconnecting from DB", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void closeRS() {
        try {
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void closeStmt() {
        try {
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String getString(int column) {
        String data = "";
        try {
            data = rs.getString(column);
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
    public int getInt(int column) {
        int data = 0;
        try {
            data = rs.getInt(column);
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
    public double getFloat(int column) {
        double data = 0.0;
        try {
            data = rs.getFloat(column);
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
    public Date getDate(int column) {
        Date data = null;
        try {
            data = rs.getDate(column);
        } catch (SQLException e) {
            Logger.getLogger(BD_Connection.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
}
