package com.teachnow.com.teachnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.teachnow.com.teachnow.model.Model;

import java.util.ArrayList;
import java.util.List;

public class Ofertas extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);

        listView = (ListView) findViewById(R.id.listaOfertas);
        showAvisos();
    }

    public void showAvisos() {
        Model MDB = new Model(getApplicationContext());
        List<String> list = new ArrayList<String>();

        MDB.insertarAviso("Escuela Da Vinci", "Instructor Carrera ANDROID ");
        MDB.insertarAviso("U. de Palermo",  "Docente de Testing");
        MDB.insertarAviso("U. Salta", "Profesor de la Carrera UX");
        MDB.insertarAviso("UADE", "Instructor de Wordpress ");
        MDB.insertarAviso("UTN", "INSTRUCTOR CARRERA SEGURIDAD INFORMATICA ");
        MDB.insertarAviso("ITBA", "Docente para programación/diseño web");

        for (int i = 0; i < MDB.recuperarAvisos().size(); i++) {
            list.add(MDB.recuperarAvisos().get(i).getDescripcion());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        listView.setAdapter(adapter);
    }
}
