package client;

import server.ConstelacionesInterface;
import server.Planeta;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConstelacionesInterface servicio = null;

        try {
            // Para conectar con el servidor RMI
            servicio = (ConstelacionesInterface) Naming.lookup("rmi://localhost:50555/Constelaciones");
            System.out.println("Conectado al servidor RMI...");
        } catch (Exception e) {
            System.out.println("Error al conectar con el servidor RMI: " + e.getMessage());
            return;
        }

        String tipoObjeto;
        boolean salir = false;

        while (!salir) {
            // Se muestra el menú para las consultas a realizar.
            System.out.println("¿Qué deseas consultar?");
            System.out.println("1. Constelaciones");
            System.out.println("2. Planetas");
            System.out.println("3. Salir");

            tipoObjeto = scanner.nextLine();

            switch (tipoObjeto) {
                case "1":
                    consultarConstelaciones(servicio, scanner);
                    break;

                case "2":
                    consultarPlanetas(servicio, scanner); // Llamar al nuevo método para consultar planetas
                    break;

                case "3":
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static void consultarConstelaciones(ConstelacionesInterface servicio, Scanner scanner) {
        System.out.println("Introduce el nombre de la constelación (o 'FIN' para salir): ");
        String nombreConstelacion = scanner.nextLine();

        if (nombreConstelacion.equalsIgnoreCase("FIN")) {
            System.out.println("Cerrando la conexión.");
            return;
        }

        try {
            // Obtener la información de la constelación desde el servidor
            String informacion = servicio.obtenerInfoConstelacion(nombreConstelacion);
            System.out.println(informacion);
        } catch (RemoteException e) {
            System.out.println("Error al obtener la información: " + e.getMessage());
        }
    }

    private static void consultarPlanetas(ConstelacionesInterface servicio, Scanner scanner) {
        System.out.println("Introduce el nombre del planeta (o 'FIN' para salir): ");
        String nombrePlaneta = scanner.nextLine();

        if (nombrePlaneta.equalsIgnoreCase("FIN")) {
            System.out.println("Cerrando la conexión.");
            return;
        }

        try {
            // Obtener la información del planeta desde el servidor
            String informacion = servicio.obtenerInfoPlaneta(nombrePlaneta);
            System.out.println(informacion);
        } catch (RemoteException e) {
            System.out.println("Error al obtener la información: " + e.getMessage());
        }
    }
}

