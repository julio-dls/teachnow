package com.teachnow.com.teachnow;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.AdapterView;
import android.content.Intent;
import android.view.View;

import com.teachnow.com.teachnow.controller.Controller;
import com.teachnow.com.teachnow.dominio.Empleo;

public class Ofertas extends AppCompatActivity {
    private ListView listView;
    private Controller controller;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);
        controller = new Controller(getApplicationContext());

        String palabraClave = getIntent().getExtras().getString("palabra_clave");
        listView = (ListView) findViewById(R.id.listaOfertas);

        listView.setAdapter(new EmpleoAdapter(getBaseContext(), controller.showEverything(palabraClave)));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
                sharedPreferences.edit()
                        .putString("seleccion_empleos", controller.obtenerEmpleoSelecionado((Empleo) listView.getItemAtPosition(position)))
                        .commit();
                finish();
                startActivity(new Intent(getApplicationContext(), Activity_Postulacion.class));
            }
        });
    }

}
