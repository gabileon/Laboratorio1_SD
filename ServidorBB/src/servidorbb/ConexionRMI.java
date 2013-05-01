package servidorbb;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionRMI {
    private static Registry registry;
    
    public Registry getRegistry() throws RemoteException{
        //Se inicia RMIREGISTRY para el registro de objetos
        //startRegistry(puerto de comunicación), no es necesario especificar la direccion
        startRegistry(1099);
        return registry;
    }
    
     private static void startRegistry(int Puerto) throws RemoteException{
        try{
            registry = LocateRegistry.getRegistry(Puerto);
            registry.list();
        }
        catch(RemoteException e){
            registry = LocateRegistry.createRegistry(Puerto);
            registry.list();
        }
    }
}
