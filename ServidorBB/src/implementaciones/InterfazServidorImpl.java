package implementaciones;

import interfaz.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import bd.*;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfazServidorImpl extends UnicastRemoteObject implements InterfazServidor {
    private ArrayList clientes = new ArrayList();
    Usuario user = new Usuario();
    Cliente cli = new Cliente();
    Empleado emp = new Empleado();
    Admin adm = new Admin();

    public InterfazServidorImpl() throws RemoteException{
        super();
    }
    
    //Este método implementa el servicio de iniciar sesión que se definio en la interfaz 
    @Override
    public int inicioSesion (String nombre, String pass) throws RemoteException {
        int hayDatos;
        hayDatos = user.iniciarSesion(nombre, pass);
        return hayDatos;
    }
    
    @Override
    public int obtenerId (String nombre, String pass) throws RemoteException {
        int hayDatos;
        hayDatos = user.obtenerId(nombre, pass);
        return hayDatos;
    }
    
    @Override
    public Vector<String> ClienteUser(int id) throws RemoteException {
        Vector<String> hayDatos;
        hayDatos = user.obtenerUser(id);
        return hayDatos;
    }
    
    public void cambioPass(int idUsuario, String pass) throws RemoteException {
        user.cambiarPass(idUsuario, pass);
    }
    
    public Vector<String> EmpleadoUser(int id) throws RemoteException {
        Vector<String> hayDatos;
        hayDatos = user.obtenerUser(id);
        return hayDatos;
    }
    
    @Override
    public Vector<String> EmpleadoPerfil(int id) throws RemoteException {
        Vector<String> hayDatos;
        hayDatos = emp.obtenerPerfil(id);
        return hayDatos;
    }
    
    @Override //Le entrega al empleado los clientes de la sucursal
    public Vector<String> EmpleadoCliente (int idEmpleado) throws RemoteException {
        Vector<String> hayDatos;
        hayDatos = emp.obtenerCliente(idEmpleado);
        return hayDatos;
    }
    
    @Override
    public void nuevoUser(String usuario, String pass, String rol) throws RemoteException {
        user.crearUser(usuario, pass, rol);
    }
    
    @Override
    public synchronized void registrarCliente(InterfazCliente cliente, String Nombre) throws RemoteException{
        if (!(clientes.contains(cliente))) {
            clientes.add(cliente);
            //clientesNombre.addElement(Nombre);
            for (int i=0;i<clientes.size();i++){
                InterfazCliente nextClient = (InterfazCliente)clientes.get(i);
                if (!cliente.toString().equals(nextClient.toString())){
                    //Mando la notificacion de que se conecto otro usuario
                    nextClient.notificar("Se CONECTO "+Nombre);
                }
            }
        }
    }
    
    @Override
    public synchronized void desregistrarCliente(InterfazCliente cliente, String Nombre) throws RemoteException{
        if (clientes.remove(cliente)) {
            //clientesNombre.removeElement(Nombre);
            for (int i=0;i<clientes.size();i++){
                InterfazCliente nextClient = (InterfazCliente)clientes.get(i);
                //Mando la notificacion de que se conecto otro usuario
                nextClient.notificar("Se DESCONECTO "+Nombre);
            }
        }
        else{
            System.out.print("Cliente no estaba registrado");
        }
    }

    @Override
    public Vector<String> ClientePerfil(int id) throws RemoteException {
        
        Vector<String> hayDatos;
        hayDatos = cli.obtenerPerfil(id);
        return hayDatos;
    }
    
    public void crearCliente(int id, int idEmpleado, String nombre, String apellido, String fono, String mail, String direc, String num) throws RemoteException {
        cli.nuevoCliente(id, idEmpleado, nombre, apellido, fono, mail, direc, num);
    }
    
    @Override
     public Vector<String> ClienteArriendo (int id) throws RemoteException {
        Vector<String> hayDatos;
        hayDatos = cli.obtenerArriendo(id);
        return hayDatos;
    }


     public Vector<String> mostrarSucursales (int id) throws RemoteException {

        Vector<String> hayDatos;
        hayDatos = adm.obtenerSucursalAdmin(id);
     return hayDatos;
    }
     
    public Vector<String> EmpleadoArriendo (int idEmpleado) throws RemoteException {
        Vector<String> hayDatos;
        hayDatos = emp.obtenerArriendo(idEmpleado);
        return hayDatos;
    }

    @Override
    public Vector<String> obtenerEmpleadosAdmin(int id) throws RemoteException {
      
        Vector<String> hayDatos;
        hayDatos = adm.obtenerEmpleadosAdmin(id);
     return hayDatos;
    }
    
    
    
}
    
