package com.teachnow.com.teachnow.dominio;

/**
 * Created by JULIO on 17/11/2017.
 */

public class Empleo {
    private int id;
    private String name;
    private String description;

    public Empleo(int id, String nombre, String descripcion) {
        this.id = id;
        this.name = nombre;
        this.description = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }
}
