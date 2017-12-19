package com.teachnow.com.teachnow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;
import com.teachnow.com.teachnow.controller.Controller;
import com.teachnow.com.teachnow.dominio.Empleo;

import java.util.List;

//https://developer.android.com/guide/topics/ui/controls/togglebutton.html
//https://developer.android.com/guide/topics/ui/controls/radiobutton.html
//https://developer.android.com/guide/topics/ui/controls/checkbox.html
// checkbox tutorial https://androiddlaprogramistow.wordpress.com/tag/oncheckboxclicked/
public class Buscar extends AppCompatActivity {

    private Button buscar;
    private Switch simpleSwitch;
    private EditText palabraClaveEt;
    private Controller controller;
    private SharedPreferences sharedPreferences;

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

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);

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

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.Temporal:
                if (checked) {
                    sharedPreferences.edit().putString("Contrato_Temporal", "Si").commit();
                } else {
                    sharedPreferences.edit().putString("Contrato_Temporal", "No").commit();
                }
                break;
            case R.id.Permanente:
                if (checked) {
                    sharedPreferences.edit().putString("Contrato_Permanente", "Si").commit();
                } else {
                    sharedPreferences.edit().putString("Contrato_Permanente", "No").commit();
                }
                break;
            case R.id.vehiculo:
                if (checked) {
                    sharedPreferences.edit().putString("Vehiculo_propio", "Si").commit();
                } else {
                    sharedPreferences.edit().putString("Vehiculo_propio", "No").commit();
                }
                break;
            case R.id.viajar:
                if (checked) {
                    sharedPreferences.edit().putString("Disponibilidad_Viajar", "Si").commit();
                } else {
                    sharedPreferences.edit().putString("Disponibilidad_Viajar", "No").commit();
                }
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.fulltime:
                if (checked)
                    sharedPreferences.edit().putString("Tipo_Jornada_Completa", "Si").commit();
                else
                    sharedPreferences.edit().putString("Tipo_Jornada_Completa", "No").commit();
                break;
            case R.id.parttime:
                if (checked)
                    sharedPreferences.edit().putString("Tipo_Jornada_Parcial", "Si").commit();
                else
                    sharedPreferences.edit().putString("Tipo_Jornada_Parcial", "No").commit();

                break;
        }
    }

    public void onSwitchChecked(View view) {
        simpleSwitch = (Switch) findViewById(R.id.discapacidad);

        if (simpleSwitch.isChecked())
            sharedPreferences.edit().putString("Oferta_Discapacitado", "True").commit();
        else
            sharedPreferences.edit().putString("Oferta_Discapacitado", "False").commit();
    }
}