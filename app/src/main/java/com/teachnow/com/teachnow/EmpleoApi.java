package com.teachnow.com.teachnow;

import com.teachnow.com.teachnow.dominio.Empleo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JULIO on 25/11/2017.
 */
//https://code.tutsplus.com/es/tutorials/sending-data-with-retrofit-2-http-client-for-android--cms-27845
public interface EmpleoApi {

    @GET
    public Call<List<Empleo>> getEmpleo();
}
