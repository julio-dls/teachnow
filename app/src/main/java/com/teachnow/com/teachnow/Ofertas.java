package com.teachnow.com.teachnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ofertas extends AppCompatActivity {
    ListView listView;
    String[] trabajos = new String[]{"oferta1", "oferta2", "oferta3", "oferta4", "oferta5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);

        listView = (ListView) findViewById(R.id.listaOfertas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, trabajos);
        listView.setAdapter(adapter);
    }
}
