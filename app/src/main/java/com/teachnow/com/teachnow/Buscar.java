package com.teachnow.com.teachnow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.teachnow.com.teachnow.controller.Controller;
import com.teachnow.com.teachnow.dominio.Empleo;

import java.util.List;
//https://developer.android.com/guide/topics/ui/controls/togglebutton.html
//https://developer.android.com/guide/topics/ui/controls/radiobutton.html
//https://developer.android.com/guide/topics/ui/controls/checkbox.html
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

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_meat:
                if (checked) {
                    // Put some meat on the sandwich
                } else {
                    // Remove the meat
                }
                break;
            case R.id.checkbox_cheese:
                if (checked) {
                    // Cheese me
                } else {
                    // I'm lactose intolerant
                }
                break;
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}