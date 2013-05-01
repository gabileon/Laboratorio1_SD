package implementaciones;
import java.rmi.*;
import java.rmi.server.*;
import interfaz.*;
import vistas.*;

public class InterfazClienteImpl extends UnicastRemoteObject implements InterfazCliente {
    
    public InterfazClienteImpl() throws RemoteException{
        super();
    }
    public void notificar(String mensaje) throws RemoteException{
        //vistaSecundaria.getInstanciaVista().aviso(mensaje);
    }
}
