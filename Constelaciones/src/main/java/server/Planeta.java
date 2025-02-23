package server;

import java.io.Serializable;

public class Planeta implements Serializable {
    private String nombre;
    private String observaciones;

    public Planeta(String nombre, String observaciones) {
        this.nombre = nombre;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}