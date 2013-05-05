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
}
