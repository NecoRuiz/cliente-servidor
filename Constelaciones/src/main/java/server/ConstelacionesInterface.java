package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Aquí solo declaro las funciones que vaya a poder ejecutar el cliente---->NO APLICO LA LÓGICA AQUÍ

//Remote-->Indica que los métodos pueden ser llamados remotamente

public interface ConstelacionesInterface extends Remote {

    String obtenerInfo(String nombre) throws RemoteException;
}
