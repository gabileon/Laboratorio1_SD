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
        
        this.consulta = conn.prepareStatement("Select * From Sucursal");
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