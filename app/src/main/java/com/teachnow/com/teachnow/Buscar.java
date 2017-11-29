package com.teachnow.com.teachnow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.teachnow.com.teachnow.controller.Controller;
import com.teachnow.com.teachnow.dominio.Empleo;

import java.util.List;

public class Buscar extends AppCompatActivity {

    private Button buscar;
    private EditText palabraClaveEt;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        EmpleoCliente.init(getApplicationContext());
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Avisos", "Obteniendo Actualizacion de ultimos avisos", true, false);
        EmpleoCliente.getEmpleo(new OnSuccessCallback() {
            @Override
            public void execute(Object body) {
                controller = new Controller(getApplicationContext());
                controller.insertNotice((List<Empleo>) body);
                progressDialog.dismiss();
            }
        });

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