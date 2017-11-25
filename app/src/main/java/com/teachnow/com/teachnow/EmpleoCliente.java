package com.teachnow.com.teachnow;


import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.google.gson.Gson;
import com.teachnow.com.teachnow.dominio.Empleo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JULIO on 25/11/2017.
 */

public class EmpleoCliente {

    private static Context context;
    private static EmpleoApi client;

    public static void init(Context con) {
        context = con;
    }

    private static EmpleoApi getClient() {

        if (client == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/julio-dls/teachnow/db")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            client = retrofit.create(EmpleoApi.class);
        }
        return client;
    }

    public static void getPizzas(final OnSuccessCallback callback) {
        getClient().getEmpleo().enqueue(new Callback<List<Empleo>>() {

            @Override
            public void onResponse(Call<List<Empleo>> call, Response<List<Empleo>> response) {
                callback.execute(response.body());
            }

            @Override
            public void onFailure(Call<List<Empleo>> call, Throwable throwable) {

                Toast.makeText(context, "Fallo al querer conectarse con el servidor", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                }, 2000);
            }
        });
    }
}

