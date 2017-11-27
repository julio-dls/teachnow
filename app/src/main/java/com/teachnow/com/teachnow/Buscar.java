package com.teachnow.com.teachnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.teachnow.com.teachnow.controller.Controller;
import com.teachnow.com.teachnow.dominio.Empleo;

public class Buscar extends AppCompatActivity {

    private Button buscar;
    private EditText palabraClaveEt;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        final String json = "{\"id\":46,\"name\":\"UADE\",\"descripcion\":\"INSTRUCTOR CARRERA SEGURIDAD INFORMATICA\"}";

       // Bundle extras = getIntent().getExtras();
        //String SerializadoE = extras.getString("Empleo");
        Empleo empleo = new Gson().fromJson(json, Empleo.class);
        controller = new Controller(getApplicationContext());
        controller.insertNotice(empleo.getName(), empleo.getDescription());

        buscar = (Button) findViewById(R.id.button_send);
        palabraClaveEt = (EditText) findViewById(R.id.PalabraClave);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Ofertas", Toast.LENGTH_SHORT).show();
                Intent ofts = new Intent(getBaseContext(), Ofertas.class);
                ofts.putExtra("palabra_clave", palabraClaveEt.getText().toString());
                startActivity(ofts);
            }
        });
    }
}

