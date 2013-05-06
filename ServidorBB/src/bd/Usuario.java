package bd;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import bd.SQLQuery;
import java.sql.*;

public class Usuario extends SQLQuery{

    
//Ejemplo a seguir:
public void conec (){
    ResultSet rs = null;
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            PreparedStatement sql1 = conn.prepareStatement("select * from usuario");
            rs = sql1.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
                
                String user= rs.getString(2);
                System.out.println(user);
                
                String pass = rs.getString(3);
                System.out.println(pass);
                int rol = rs.getInt(4);
                System.out.println(rol);
            }
            
        } catch (SQLException ex) {
            try {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        
        
}
     
    public int iniciarSesion(String nombre, String pass) {
        ResultSet rs = null;
        int resultado;
        
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            this.consulta = conn.prepareStatement("SELECT ROL FROM USUARIO WHERE USERNAME = '"+nombre+"' AND PASSWORD = '"+pass+"'");
            this.datos = this.consulta.executeQuery();
            if (this.datos.next()) {
                resultado = this.datos.getInt("ROL");
                return resultado;
            }
            
        } catch (SQLException ex) {
            try {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return -1;
    }

    public int obtenerId(String nombre, String pass) {
        ResultSet rs = null;
        int resultado;
        
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            this.consulta = conn.prepareStatement("SELECT ID_USUARIO FROM USUARIO WHERE USERNAME = '"+nombre+"' AND PASSWORD = '"+pass+"'");
            this.datos = this.consulta.executeQuery();
            if (this.datos.next()) {
                resultado = this.datos.getInt("ID_USUARIO");
                return resultado;
            }
            
        } catch (SQLException ex) {
            try {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return -1;
    }

    public Vector<String> obtenerUser(int id_usuario) {
        ResultSet rs = null;
        Vector<String> resultado = new Vector();;
        
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            this.consulta = conn.prepareStatement("SELECT * FROM USUARIO WHERE ID_USUARIO = '"+id_usuario+"'");
            this.datos = this.consulta.executeQuery();
            if (this.datos.next()) {
                resultado.add(datos.getString(2));
                resultado.add(datos.getString(3));
            }
            return resultado;
        } catch (SQLException ex) {
            try {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resultado;
    }
    
    public void cambiarPass(int idUsuario, String pass) {
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE USUARIO SET PASSWORD='"+pass +"' WHERE ID_USUARIO='"+ idUsuario+"'");
        } catch (SQLException ex) {
            try {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public void crearUser(String user, String pass, String rol) {
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO USUARIO (username, password, rol) VALUES ('"+user+"','"+pass+"','"+rol+"')");
        } catch (SQLException ex) {
            try {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
}