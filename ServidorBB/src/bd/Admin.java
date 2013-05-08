/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Gabriela
 */

import java.sql.*;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Admin extends SQLQuery {
    
    
   public Vector<String> obtenerSucursalAdmin(int idAdmin){
   
      Vector<String> resultado = new Vector();
        try {
                Class.forName(SQLQuery.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
        
        this.consulta = conn.prepareStatement("Select * From Sucursal WHERE id_admin ='"+idAdmin+"'");
        this.datos = this.consulta.executeQuery();    
        while (this.datos.next()) {
                resultado.add(datos.getString("comuna"));
                resultado.add(datos.getString("direccion"));
                resultado.add(datos.getString("numero_direccion"));
                resultado.add(datos.getString("telefono"));
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
    
  /* public Vector<String> obtenerArriendoAdmin(int idAdmin) {
       
        Vector<String> resultado = new Vector();
        try {
                Class.forName(SQLQuery.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
        
        this.consulta = conn.prepareStatement("select cliente.nombre, cliente.apellido,  pelicula.nombre, arriendo.fecha_arriendo, arriendo.fecha_entrega, arriendo.valor from admin, inner join sucursal on empleado.id_sucursal = sucursal.id_sucursal inner join cliente on sucursal.id_sucursal = cliente.id_sucursal inner join arriendo on cliente.id_cliente = arriendo.id_cliente inner join pelicula on arriendo.id_pelicula = pelicula.id_pelicula where empleado.id_empleado ='"+idEmpleado+"'");
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
    */

    public Vector<String> AdminEmpleado(int idAdmin) {
        
         Vector<String> resultado = new Vector();
        try {
                Class.forName(SQLQuery.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
        
        this.consulta = conn.prepareStatement("Select sucursal.comuna, empleado.nombre, empleado.apellido, empleado.mail, empelado.telefono From Sucursal, Empleado WHERE sucursal.id_admin='"+idAdmin+"' and empleado.id_sucursal = sucursal.id" );
        this.datos = this.consulta.executeQuery();    
        while (this.datos.next()) {
                resultado.add(datos.getString("comuna"));
                resultado.add(datos.getString("direccion"));
                resultado.add(datos.getString("numero_direccion"));
                resultado.add(datos.getString("telefono"));
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
