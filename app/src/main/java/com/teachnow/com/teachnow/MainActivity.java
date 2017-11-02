package com.teachnow.com.teachnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = LayoutInflater.from(getBaseContext());
        View viewBuscar = layoutInflater.inflate(R.layout.activity_buscar, null, false);
        View viewOferta = layoutInflater.inflate(R.layout.activity_ofertas, null, false);

        LinearLayout pantallas = findViewById(R.id.jobs_container);
        pantallas.addView(viewBuscar);

        viewBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Buscar", Toast.LENGTH_SHORT).show();
            }
        });
        viewOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Buscar", Toast.LENGTH_SHORT).show();
            }
        });

        buscar = (Button) findViewById(R.id.button_send);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Ofertas", Toast.LENGTH_SHORT).show();
                Intent buscar = new Intent(getBaseContext(), Ofertas.class);
                startActivity(buscar);
            }
        });
    }
}
