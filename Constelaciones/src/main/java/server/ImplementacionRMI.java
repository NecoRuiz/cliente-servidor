package server;


//AQUÍ IMPLEMENTO LA LÓGICA DE LOS MÉTODOS

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

//UnicastRemoteObject-->Hace que el servidor pueda ser invocado remotamente
//



public class ImplementacionRMI extends UnicastRemoteObject implements ConstelacionesInterface {

    private ArrayList<Constelacion> almacenConstelaciones;

    public ImplementacionRMI() throws RemoteException {

        //llama al constructor de la clase UnicastRemoteObject, sin ello no funcionaría
        super();

        almacenConstelaciones = new ArrayList<>();

        almacenConstelaciones.add(new Constelacion("Osa Mayor", "Se desplaza en círculos alrededor del polo norte."));

        almacenConstelaciones.add(new Constelacion("Osa Menor", "Su estrella más conocida es la polar que se encuentra en la prolongación del eje de la tierra."));

        almacenConstelaciones.add(new Constelacion("Tauro", "Una de las constelaciones más conocidas desde tiempos remotos."));

        almacenConstelaciones.add(new Constelacion("Leo", "De las más brillantes del Zodíaco."));

        almacenConstelaciones.add(new Constelacion("Escorpio", "Sus estrellas forman un escorpión."));

        almacenConstelaciones.add(new Constelacion("Can Mayor", "Contiene la estrella Sirio, la más brillante en el cielo nocturno."));

        almacenConstelaciones.add(new Constelacion("Casiopea", "Tiene forma de M o W. Es conocida desde mucha antigüedad."));

        almacenConstelaciones.add(new Constelacion("El Boyero", "Contiene la estrella Arturo, uno de las más luminosas del cielo."));

        almacenConstelaciones.add(new Constelacion("Cruz del sur", "Señala al polo sur. Constelación muy pequeña."));

        almacenConstelaciones.add(new Constelacion("Acuario", "Una de las más antiguas. Incluye 56 estrellas."));

        almacenConstelaciones.add(new Constelacion("Géminis", "Destaca por sus dos gemelos, las estrellas Cástor y Pólux."));

    }

    @Override
    public String obtenerInfo(String nombre) throws RemoteException {
//en el almacén va a encontrar un item Constelación
        for (Constelacion item : almacenConstelaciones){
//si el nombre que ingresa el cliente coicide con el del almacén
            if (item.getNombre().equalsIgnoreCase(nombre)){
//devuelve la descripción de la Constelación
                return item.getObservaciones();

            }

        }

        return "Constelación no encontrada";
    }
}
