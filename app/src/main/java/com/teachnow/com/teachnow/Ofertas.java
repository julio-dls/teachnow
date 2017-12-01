package com.teachnow.com.teachnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.teachnow.com.teachnow.controller.Controller;

public class Ofertas extends AppCompatActivity {
    private EditText editText;
    private ListView listView;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);
        controller = new Controller(getApplicationContext());

        String palabraClave = getIntent().getExtras().getString("palabra_clave");
        listView = (ListView) findViewById(R.id.listaOfertas);
        listView.setAdapter(new EmpleoAdapter(getBaseContext(), controller.showEverything(palabraClave)));
    }
}
