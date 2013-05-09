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
        
        this.consulta = conn.prepareStatement("Select * From Sucursal WHERE ID_ADMIN = '"+idAdmin+"'");
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
    
    public Vector<String> obtenerEmpleadosAdmin(int idAdmin){
   
      Vector<String> resultado = new Vector();
        try {
                Class.forName(SQLQuery.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
         
        this.consulta = conn.prepareStatement("SELECT sucursal.comuna, empleado.nombre , empleado.apellido, empleado.email, empleado.telefono from Empleado, Sucursal where empleado.id_sucursal=sucursal.id_sucursal and sucursal.id_admin='"+idAdmin+"'");
        this.datos = this.consulta.executeQuery();    
        while (this.datos.next()) {
                resultado.add(datos.getString("comuna"));
                resultado.add(datos.getString("nombre"));
                resultado.add(datos.getString("apellido"));
                resultado.add(datos.getString("email"));
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

    public Vector<String> obtenerClientesAdmin(int idAdmin) {
        System.out.println("dsdsds");
          Vector<String> resultado = new Vector();
        try {
                Class.forName(SQLQuery.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
        conn = DriverManager.getConnection(SQLQuery.getUrl(), SQLQuery.getUser(), SQLQuery.getPass());
         
        this.consulta = conn.prepareStatement("SELECT sucursal.comuna, cliente.nombre , cliente.apellido, cliente.telefono, cliente.email, from Cliente, Sucursal where cliente.id_sucursal=sucursal.id_sucursal and sucursal.id_admin='"+idAdmin+"'");
        this.datos = this.consulta.executeQuery();    
        while (this.datos.next()) {
                resultado.add(datos.getString("comuna"));
                resultado.add(datos.getString("nombre"));
                resultado.add(datos.getString("apellido"));
                resultado.add(datos.getString("telefono"));
                resultado.add(datos.getString("email"));
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
