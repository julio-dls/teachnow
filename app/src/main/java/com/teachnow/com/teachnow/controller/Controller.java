package com.teachnow.com.teachnow.controller;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.teachnow.com.teachnow.R;
import com.teachnow.com.teachnow.dominio.Empleo;
import com.teachnow.com.teachnow.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.proyectosimio.com/es/programacion-android-base-de-datos-i-modelo-vista-controlador/
 * https://androidexample.com/Use_MVC_Pattern_To_Create_Very_Basic_Shopping_Cart__-_Android_Example/index.php?view=article_discription&aid=116
 * Created by JULIO on 15/11/2017.
 */

public class Controller {

    private Model mdb;
    private ArrayAdapter<String> adapter;
    private Context context;

    public Controller(Context context) {
        mdb = new Model(context);
        this.context = context;
    }

    public void insertNotice(List<Empleo> empleos) {
        mdb = new Model(context);

        if (empleos.isEmpty() == false) {
            for (int i = 0; i < empleos.size(); i++) {
                mdb.insertarAviso(empleos.get(i).getName(), empleos.get(i).getDescription(), empleos.get(i).getPhotoId());
            }
        }
    }

    public List<Empleo> showAll() {
        mdb = new Model(context);
        return mdb.recuperarAvisos();
    }

    public List<Empleo> showEverything(String palabraClave) {
        mdb = new Model(context);
        return palabraClave.isEmpty() ? showAll() : mdb.recuperarAviso(palabraClave);
    }

    public String obtenerEmpleoSelecionado(Empleo empleo) {
        mdb = new Model(context);
        String nombre = mdb.recuperarAvisoPorId(empleo.getId()).getName().toString();
        String descripcion = mdb.recuperarAvisoPorId(empleo.getId()).getDescription().toString();
        return "Titulo: " + nombre + "\n" + " Descripcion: " + descripcion;
    }

    public void modifyAv() {
    }

    public void removeAv() {
    }
}
