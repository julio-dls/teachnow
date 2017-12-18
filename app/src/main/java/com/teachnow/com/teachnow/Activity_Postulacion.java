package com.teachnow.com.teachnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.teachnow.com.teachnow.correo.SendMail;

public class Activity_Postulacion extends AppCompatActivity {

    private Button button_adjuntar;
    private Button button_enviar;
    private String path_archivo;
    private EditText nombre;
    private EditText edad;
    private EditText profesion;
    private EditText localidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__postulacion);

        nombre = (EditText) findViewById(R.id.nombre);
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
                                String subject = "Envio de Postulacion para esta Vacante";
                                String message = "Nombre: " + nombre.getText().toString() + "\n" +
                                        "Edad: " + edad.getText().toString() + "\n" +
                                        "Profesion: " + profesion.getText().toString() + "\n" +
                                        "Localidad: " + localidad.getText().toString();

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