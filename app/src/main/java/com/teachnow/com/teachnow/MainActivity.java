package com.teachnow.com.teachnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

//https://expocodetech.com/como-crear-una-lista-con-recyclerview/

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                Toast.makeText(getBaseContext(), "Ofertas", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }
}
