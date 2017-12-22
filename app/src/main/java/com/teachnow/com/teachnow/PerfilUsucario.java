package com.teachnow.com.teachnow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PerfilUsucario extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView nombreUser;
    private TextView ApellidoUser;
    private TextView documento;
    private TextView edad;
    private TextView telefono;
    private TextView email;
    private TextView fechanacimiento;
    private TextView residenciaactual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usucario);

        nombreUser = (TextView) findViewById(R.id.nombreUser);
        ApellidoUser = (TextView) findViewById(R.id.apellidosUser);
        documento = (TextView) findViewById(R.id.tipo_documentoUser);
        edad = (TextView) findViewById(R.id.edadUser);
        telefono = (TextView) findViewById(R.id.telefonoUser);
        email = (TextView) findViewById(R.id.emailUser);
        fechanacimiento = (TextView) findViewById(R.id.fechaNacimientoUser);
        residenciaactual = (TextView) findViewById(R.id.recidencia_actualUser);

        sharedPreferences = this.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);

        nombreUser.setText(sharedPreferences.getString("nombre", ""));
        nombreUser.setEnabled(false);
        ApellidoUser.setText(sharedPreferences.getString("apellido", ""));
        ApellidoUser.setEnabled(false);
        documento.setText(sharedPreferences.getString("tipoDocumento", ""));
        documento.setEnabled(false);
        edad.setText(sharedPreferences.getString("edad", ""));
        edad.setEnabled(false);
        telefono.setText(sharedPreferences.getString("telefono", ""));
        telefono.setEnabled(false);
        email.setText(sharedPreferences.getString("email", ""));
        email.setEnabled(false);
        fechanacimiento.setText(sharedPreferences.getString("fechaNacimiento", ""));
        fechanacimiento.setEnabled(false);
        residenciaactual.setText(sharedPreferences.getString("residenciaActual", ""));
        residenciaactual.setEnabled(false);

        Button ir_buscar = (Button) findViewById(R.id.ir_buscar);
        ir_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), Buscar.class));
            }
        });
    }
}
