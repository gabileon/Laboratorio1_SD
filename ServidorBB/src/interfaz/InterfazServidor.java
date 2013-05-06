package interfaz;

import java.rmi.*;
import java.util.*;

public interface InterfazServidor extends Remote{
    public int inicioSesion(String nombre, String pass) throws RemoteException;
    public int obtenerId(String nombre, String pass) throws RemoteException;
    public Vector<String> ClientePerfil(int id) throws RemoteException;
    public Vector<String> EmpleadoPerfil(int id) throws RemoteException;
    public Vector<String> ClienteUser(int id) throws RemoteException;
    public Vector<String> EmpleadoUser(int id) throws RemoteException;
    public Vector<String> ClienteArriendo(int id) throws RemoteException;
    public void cambioPass(int idUsuario, String pass) throws RemoteException;
    public void nuevoUser(String user, String pass, String rol) throws RemoteException;
    public Vector<String> EmpleadoCliente (int idEmpleado) throws RemoteException;
    public void registrarCliente(InterfazCliente cliente, String Nombre) throws RemoteException;
    public void desregistrarCliente(InterfazCliente cliente, String Nombre) throws RemoteException;
    public Vector<String> mostrarSucursales (int id) throws RemoteException;
}
