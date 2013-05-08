package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class SQLQuery {
    //heheh
    protected Connection conn;
    protected PreparedStatement consulta;
    protected ResultSet datos;
    
    public static String url= "jdbc:mysql://localhost/bd_bb";
    public static String user = "root";
    public static String pass ="";
    
    
    public static String getDriver(){
        String driver = "com.mysql.jdbc.Driver";
        return driver;
    
    }
    
    public static String getUrl(){
    
        return url;
    }
    
    public static String getUser(){
    
        return user;
    }
    
    public static String getPass(){
    
        return pass;
    }

    
}



    /*
    protected Connection conn;
    protected PreparedStatement consulta;
    protected ResultSet datos;
    
    public void conectar(String servidor, String bd, String usuario, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+bd,usuario,password);
    }
    
    public void desconectar() throws SQLException {
        this.conn.close();
        this.consulta.close();
    }
    
    public void desconectar(ResultSet rs) throws SQLException {
        this.desconectar();
        rs.close();
    }
}
*/
