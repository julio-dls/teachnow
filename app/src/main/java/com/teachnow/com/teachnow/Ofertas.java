package com.teachnow.com.teachnow;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import model.Model;

public class Ofertas extends AppCompatActivity {

    private String autor;
    private String descripcion;
    ListView listView;
    String[] trabajos = new String[]{"Instructor Carrera ANDROID ",
            "Profesor de la Carrera UX", "INSTRUCTOR CARRERA SEGURIDAD INFORMATICA ",
            "Docente para programación/diseño web",
            "Docente de Testing", "Instructor de Wordpress "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);

        listView = (ListView) findViewById(R.id.listaOfertas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, trabajos);
        listView.setAdapter(adapter);
        
    }

    public void showAvisos() {
        Model MDB = new Model(getApplicationContext());

        // Escribimos 4 registros en nuestra tabla
        MDB.insertarAviso(1, "Pedro",  "pedro@DB.es");
        MDB.insertarAviso(2, "Sandra",  "sandra@DB.es");
        MDB.insertarAviso(3, "Maria",  "maria@DB.es");
        MDB.insertarAviso(4, "Daniel",  "daniel@DB.es");

        // Recuperamos los 4 registros y los mostramos en el log
        Log.d("TOTAL", Integer.toString(MDB.recuperarAviso().size()));

        int[] ids = new int[MDB.recuperarAviso().size()];
        String[] noms = new String[MDB.recuperarAviso().size()];
        String[] descr = new String[MDB.recuperarAviso().size()];

        for (int i = 0; i < MDB.recuperarAviso().size(); i++) {
            ids[i] = MDB.recuperarAviso().get(i).getId();
            noms[i] = MDB.recuperarAviso().get(i).getNombre();
            descr[i] = MDB.recuperarAviso().get(i).getDescripcion();
            Log.d(""+ids[i], noms[i] + ", " + descr[i]);
        }
    }
}
