package bd;

import java.sql.*;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleado extends SQLQuery{
    
    public Vector<String> obtenerPerfil(int idEmpleado) {
        Vector<String> resultado = new Vector();
        
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            this.consulta = conn.prepareStatement("SELECT * FROM Empleado WHERE ID_EMPLEADO = '"+idEmpleado+"'");
            this.datos = this.consulta.executeQuery();
            if (this.datos.next()) {
                resultado.add(datos.getString(3));
                resultado.add(datos.getString(4));
                resultado.add(datos.getString(5));
                resultado.add(datos.getString(6));
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
    
    public Vector<String> obtenerCliente(int idEmpleado) {
        Vector<String> resultado = new Vector();
        
        try {
            Class.forName(SQLQuery.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
            
            this.consulta = this.conn.prepareStatement("select cliente.nombre, cliente.apellido, cliente.telefono, cliente.email, cliente.direccion, cliente.numero_direccion from empleado inner join sucursal on empleado.id_sucursal = sucursal.id_sucursal inner join cliente on sucursal.id_sucursal = cliente.id_sucursal where empleado.id_empleado ='"+idEmpleado+"'");
            this.datos = this.consulta.executeQuery();
            while (this.datos.next()) {
                resultado.add(datos.getString("nombre"));
                resultado.add(datos.getString("apellido"));
                resultado.add(datos.getString("telefono"));
                resultado.add(datos.getString("email"));
                resultado.add(datos.getString("direccion"));
                resultado.add(datos.getString("numero_direccion"));
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
    
    public Vector<String> obtenerArriendo(int idEmpleado) {
        Vector<String> resultado = new Vector();
        try {
                Class.forName(SQLQuery.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
        
        this.consulta = conn.prepareStatement("select cliente.nombre, cliente.apellido, cliente.email, pelicula.nombre, arriendo.fecha_arriendo, arriendo.fecha_entrega, arriendo.valor from empleado inner join sucursal on empleado.id_sucursal = sucursal.id_sucursal inner join cliente on sucursal.id_sucursal = cliente.id_sucursal inner join arriendo on cliente.id_cliente = arriendo.id_cliente inner join pelicula on arriendo.id_pelicula = pelicula.id_pelicula where empleado.id_empleado ='"+idEmpleado+"'");
        this.datos = this.consulta.executeQuery();    
        while (this.datos.next()) {
                resultado.add(datos.getString(1));
                resultado.add(datos.getString(2));
                resultado.add(datos.getString(3));
                resultado.add(datos.getString(4));
                resultado.add(datos.getString(5));
                resultado.add(datos.getString(6));
                resultado.add(datos.getString(7));
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
    
}
