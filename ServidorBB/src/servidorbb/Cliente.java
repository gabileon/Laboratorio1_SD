package servidorbb;

import interfaz.InterfazCliente;

public class Cliente implements Runnable {
    private String NombreCliente;
    private InterfazCliente cliente;

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public InterfazCliente getCliente() {
        return cliente;
    }

    public void setCliente(InterfazCliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
