package com.teachnow.com.teachnow.dominio;

/**
 * Created by JULIO on 17/11/2017.
 * http://www.jsonschema2pojo.org/ (crear automaticamente el codigo java)
 */

public class Empleo {
    private int id;
    private String name;
    private String description;
    private int photoId;

    public Empleo(int id, String nombre, String description, int photoId) {
        this.id = id;
        this.name = nombre;
        this.description = description;
        this.photoId=photoId;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
