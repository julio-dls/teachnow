package com.teachnow.com.teachnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = LayoutInflater.from(getBaseContext());
        View viewOferta = layoutInflater.inflate(R.layout.activity_oferta, null, false);


        LinearLayout pantallaOfrta = findViewById(R.id.jobs_container);
        pantallaOfrta.addView(viewOferta);

        viewOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Oferta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
