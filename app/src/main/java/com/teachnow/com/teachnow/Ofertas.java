package com.teachnow.com.teachnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import com.teachnow.com.teachnow.controller.Controller;

public class Ofertas extends AppCompatActivity {
    private EditText editText;
    private Controller controller;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);

        String palabraClave = getIntent().getExtras().getString("palabra_clave");
        controller = new Controller(getApplicationContext());
        //controller.insertNotice();

        listView = (ListView) findViewById(R.id.listaOfertas);
        listView.setAdapter(controller.showEverything(palabraClave));
    }
}
