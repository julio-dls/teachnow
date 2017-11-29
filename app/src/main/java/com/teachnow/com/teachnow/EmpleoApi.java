package com.teachnow.com.teachnow;

import com.teachnow.com.teachnow.dominio.Empleo;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * https://code.tutsplus.com/es/tutorials/sending-data-with-retrofit-2-http-client-for-android--cms-27845
 * https://programacionymas.com/blog/consumir-una-api-usando-retrofit
 * Created by JULIO on 25/11/2017.
 */

public interface EmpleoApi {

    @GET("empleo")
    public Call<List<Empleo>> getEmpleo();
}
