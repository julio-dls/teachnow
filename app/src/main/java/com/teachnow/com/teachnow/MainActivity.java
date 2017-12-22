package com.teachnow.com.teachnow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
// paginas obtener mapo xml icon https://materialdesignicons.com/
//https://expocodetech.com/como-crear-una-lista-con-recyclerview/

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences sharedPreferences;
    private boolean registradoFlag = false;
    private EditText nombre;
    private EditText apellido;
    private EditText tipoDocumento;
    private EditText edad;
    private EditText email;
    private EditText fechaNacimiento;
    private EditText residenciaActual;
    private EditText telefono;
    private EditText password;
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView imgPerfil = (ImageView) findViewById(R.id.imagePerfil);
        Drawable originalDrawable = this.getResources().getDrawable(R.drawable.avatar);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(this.getResources(), originalBitmap);
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());
        imgPerfil.setImageDrawable(roundedDrawable);

        nombre = (EditText) findViewById(R.id.nombrePerfil);
        apellido = (EditText) findViewById(R.id.apellidosperfil);
        tipoDocumento = (EditText) findViewById(R.id.tipo_documento);
        edad = (EditText) findViewById(R.id.edad);
        email = (EditText) findViewById(R.id.email);
        fechaNacimiento = (EditText) findViewById(R.id.fechaNacimiento);
        residenciaActual = (EditText) findViewById(R.id.recidencia_actual);
        telefono = (EditText) findViewById(R.id.telefono);
        password = (EditText) findViewById(R.id.password);
        username = (EditText) findViewById(R.id.user);

        Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registradoFlag = true;
                sharedPreferences = getApplication().getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
                sharedPreferences.edit()
                        .putString("nombre", nombre.getText().toString())
                        .putString("apellido", apellido.getText().toString())
                        .putString("tipoDocumento", tipoDocumento.getText().toString())
                        .putString("edad", edad.getText().toString())
                        .putString("email", email.getText().toString())
                        .putString("fechaNacimiento", fechaNacimiento.getText().toString())
                        .putString("telefono", telefono.getText().toString())
                        .putString("password", password.getText().toString())
                        .putString("username", username.getText().toString())
                        .putString("residenciaActual", residenciaActual.getText().toString())
                        .putBoolean(" registradoFlag", registradoFlag)
                        .commit();
                Toast.makeText(getBaseContext(), "Los Datos se Guardaron Correctamente", Toast.LENGTH_SHORT).show();
                nombre.setText("");
                apellido.setText("");
                tipoDocumento.setText("");
                edad.setText("");
                fechaNacimiento.setText("");
                telefono.setText("");
                email.setText("");
                password.setText("");
                username.setText("");
                residenciaActual.setText("");
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_buscar) {
            finish();
            startActivity(new Intent(this, Buscar.class));
        } else if (id == R.id.nav_perfil) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
