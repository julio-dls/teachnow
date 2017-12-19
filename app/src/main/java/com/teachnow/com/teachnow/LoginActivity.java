package com.teachnow.com.teachnow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userEt;
    private EditText passwordEt;
    private Button enterBtn;
    private Context context;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        userEt = (EditText) findViewById(R.id.usuario_et);
        passwordEt = (EditText) findViewById(R.id.password_et);
        enterBtn = (Button) findViewById(R.id.enter_btn);

        sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        if (!username.isEmpty() && !password.isEmpty()) {
            goToFindJobs();
        } else {
            enterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                if (isLoginSuccessful(userEt.getText().toString(), passwordEt.getText().toString())) {
                    sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
                    sharedPreferences.edit()
                            .putString("username", userEt.getText().toString())
                            .putString("password", passwordEt.getText().toString())
                            .apply();
                    goToFindJobs();
                } else {
                    Toast.makeText(getApplicationContext(), "Datos Incorrecto", Toast.LENGTH_SHORT).show();
                }
                }
            });
        }
    }

    private void goToFindJobs() {
        finish();
        startActivity(new Intent(context, Buscar.class));
    }

    private boolean isLoginSuccessful(String username, String password) {
        return username.equals("Miguel") && password.equals("123");
    }
}