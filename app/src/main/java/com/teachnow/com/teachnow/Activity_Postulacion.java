package com.teachnow.com.teachnow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.teachnow.com.teachnow.controller.Controller;
import com.teachnow.com.teachnow.correo.SendMail;

//https://androidstudiofaqs.com/tutoriales/personalizar-textview-en-android
public class Activity_Postulacion extends AppCompatActivity {

    private Button button_adjuntar;
    private Button button_enviar;
    private String path_archivo;
    private EditText nombre;
    private EditText edad;
    private EditText profesion;
    private EditText localidad;
    private TextView descripsion_empleo;
    private SharedPreferences sharedPreferences;
    String empleo_seleccionardo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__postulacion);

        descripsion_empleo = (TextView) findViewById(R.id.title_job);

        sharedPreferences = this.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        empleo_seleccionardo = sharedPreferences.getString("seleccion_empleos", "");

        descripsion_empleo.setText("Postulacion: " + "\n" + empleo_seleccionardo);

        nombre = (EditText) findViewById(R.id.nombre);
        nombre.setText(sharedPreferences.getString("username", ""));
        nombre.setEnabled(false);
        edad = (EditText) findViewById(R.id.edad);
        profesion = (EditText) findViewById(R.id.profesion);
        localidad = (EditText) findViewById(R.id.localidad);

        button_adjuntar = (Button) findViewById(R.id.adjuntar_btn);
        button_enviar = (Button) findViewById(R.id.send_mail_btn);

        button_adjuntar.setOnClickListener(onClickListener);
        button_enviar.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.adjuntar_btn:
                    Toast.makeText(getBaseContext(), "explorador de archivos", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(), explorador_archivos.class));
                    break;

                case R.id.send_mail_btn:
                    path_archivo = getIntent().getExtras().getString("ruta_archivo");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String email = "quirogajulio27@gmail.com";
                                String subject = "Postulacion para esta Vacante";
                                String message = "Nombre: " + nombre.getText().toString() + "\n" +
                                        "Edad: " + edad.getText().toString() + "\n" +
                                        "Profesion: " + profesion.getText().toString() + "\n" +
                                        "Localidad: " + localidad.getText().toString() + "\n" +
                                        "Datos de la Vacante: " + "\n" +
                                        empleo_seleccionardo + "\n" +
                                        "Datos Adicionales del Postulante: " + "\n" +
                                        "Disponibilidad para viajar: " + sharedPreferences.getString("Disponibilidad_Viajar", "") + "\n" +
                                        "Vehiculo Porpio: " + sharedPreferences.getString("Vehiculo_propio", "") + "\n" +
                                        "Contrato Temporal: " + sharedPreferences.getString("Contrato_Temporal", "") + "\n" +
                                        "Contrato Permanente: " + sharedPreferences.getString("Contrato_Permanente", "") + "\n" +
                                        "Tipo Jornada Completa: " + sharedPreferences.getString("Tipo_Jornada_Completa", "") + "\n" +
                                        "Tipo Jornada Parcial: " + sharedPreferences.getString("Tipo_Jornada_Parcial", "") + "\n" +
                                        "Oferta para discapacitado: " + sharedPreferences.getString("Oferta_Discapacitado", "");

                                SendMail sm = new SendMail(getApplicationContext(), email, subject, message, path_archivo);
                                sm.execute();
                            } catch (Exception e) {
                                Log.e("SendMail", e.getMessage(), e);
                            }
                        }
                    }).start();
                    Toast.makeText(getBaseContext(), "Correo Enviado Correctamente", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}