package com.teachnow.com.teachnow;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*http://programandoointentandolo.com/2014/06/como-hacer-un-explorador-de-archivos-en-android.html*/
public class explorador_archivos extends AppCompatActivity {
    private ListView listview_archivos;
    private List<String> listaNombresArchivos;
    private ArrayAdapter adaptador;
    private String ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorador_archivos);
        openFolder();
        //Para obtener la posición se puede realizar mediante el listener setOnItemClickListener y mediante su método onItemClick(), puedes determinar la posición de la vista dentro de tu ListView, mediante el tercer parámetro que es position
        listview_archivos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File nombra_archivo = new File(listaNombresArchivos.get(position));
                ruta = ruta + "/" + nombra_archivo;
                Toast.makeText(getBaseContext(), "Postulacion", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(explorador_archivos.this, Activity_Postulacion.class);
                intent.putExtra("ruta_archivo", ruta);
                startActivity(intent);

            }
        });
    }

    public void openFolder() {
        ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        listaNombresArchivos = new ArrayList();

        File directorioActual = new File(ruta);
        File[] listaArchivos = directorioActual.listFiles();

        try {
            for (File archivos : listaArchivos) {
                if (archivos.isFile()) {
                    listaNombresArchivos.add(archivos.getName());
                } else {
                    listaNombresArchivos.add("/" + archivos.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(listaNombresArchivos, String.CASE_INSENSITIVE_ORDER);

        listview_archivos = (ListView) findViewById(R.id.lista_archivos);
        adaptador = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listaNombresArchivos);
        listview_archivos.setAdapter(adaptador);
    }

}