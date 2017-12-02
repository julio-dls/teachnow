package com.teachnow.com.teachnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
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

        listView.setOnItemClickListener(new ListClickHandler());
    }
        public class ListClickHandler implements OnItemClickListener{

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Ofertas.this, Activity_Postulacion.class);
                //intent.putExtra("selected-item", text);
                startActivity(intent);

            }

        }

}
