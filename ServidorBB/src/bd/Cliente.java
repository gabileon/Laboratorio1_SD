package bd;

import java.sql.*;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente extends SQLQuery {
    
    
    
    public Vector<String> obtenerPerfil(int idCliente) {
    
          Vector<String> resultado = new Vector();
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            this.consulta = conn.prepareStatement("SELECT * FROM CLIENTE WHERE ID_CLIENTE = '"+idCliente+"'");
            this.datos = this.consulta.executeQuery();
            if (this.datos.next()) {
                resultado.add(datos.getString(2));
                resultado.add(datos.getString(3));
                resultado.add(datos.getString(4));
                resultado.add(datos.getString(5));
                resultado.add(datos.getString(6));
                resultado.add(datos.getString(7));
                resultado.add(datos.getString(8));
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
       
    return resultado;
    }
    
    
    public Vector<String> obtenerArriendo(int idCliente) {
        Vector<String> resultado = new Vector();
        try {
                Class.forName(SQLQuery.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
        
        this.consulta = conn.prepareStatement("select pelicula.nombre, arriendo.fecha_arriendo, arriendo.fecha_entrega, arriendo.valor from cliente inner join arriendo on cliente.id_cliente = arriendo.id_cliente inner join pelicula on arriendo.id_pelicula = pelicula.id_pelicula where cliente.id_cliente ='"+idCliente+"'");
        this.datos = this.consulta.executeQuery();    
        while (this.datos.next()) {
                resultado.add(datos.getString("nombre"));
                resultado.add(datos.getString("fecha_arriendo"));
                resultado.add(datos.getString("fecha_entrega"));
                resultado.add(datos.getString("valor"));
            }
            return resultado;
        
         } catch (SQLException ex) {
            try {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
       
    return resultado;
    }
    
    public void crearCliente(int id, int idEmpleado, String nombre, String apellido, String fono, String mail, String direc, String num) {
        Vector<String> resultado = new Vector();
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            Statement st = conn.createStatement();
            this.consulta = conn.prepareStatement("select id_sucursal from empleado where id_empleado ='"+idEmpleado+"'");
            this.datos = this.consulta.executeQuery();
            int idSucursal = 0;
            while (this.datos.next()) {
                    idSucursal = datos.getInt("id_sucursal");
                }
            System.out.println();
            st.executeUpdate("INSERT INTO CLIENTE (id_cliente, id_sucursal, nombre, apellido, telefono, email, direccion, numero_direccion) VALUES ('"+id+"','"+idSucursal+"','"+ nombre+"','"+apellido+"','"+fono+"','"+mail+"','"+direc+"','"+num+"')");
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
