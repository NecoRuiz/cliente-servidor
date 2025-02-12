package server;

//AQUÍ SOLO PONGO EN MARCHA AL SERVIDOR OFRECIENDO EL SERVICIO

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {

    public static void main(String[] args) {
        String host;
        int puerto = 50555;

        try {
            //obtener la IP de la máquina donde se ejecuta el servidor
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("Ha ocurrido un error al encontrar la dirección");
            System.out.println(e.getMessage());
        }
        try {
            //creo un registro donde almacenaré los servicios
            //es necesario pasarle el puerto
            Registry registro = LocateRegistry.createRegistry(puerto);
            //creamos el SERVICIO con la lógica de la funcion y las constelaciones(ArrayList)
            ImplementacionRMI servicio = new ImplementacionRMI();
            //al registro le paso el SERVICIO con el alias "Constelaciones"
            //"Constelaciones"--->Alias que tendrá que cononocer el cliente para poder usar el servicio
            registro.rebind("Constelaciones", servicio);

            






        } catch (RemoteException e) {
            System.out.println("Error al registrar el servicio.");
            System.out.println(e.getMessage());
        }
    }

}
