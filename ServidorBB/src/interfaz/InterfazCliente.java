package interfaz;

import java.rmi.*;

public interface InterfazCliente extends Remote{
    public void notificar(String mensaje) throws RemoteException;
}
