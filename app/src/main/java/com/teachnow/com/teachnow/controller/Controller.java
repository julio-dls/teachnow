package com.teachnow.com.teachnow.controller;

import android.app.Application;
import android.content.Context;

import com.teachnow.com.teachnow.model.Model;
/**
 * Created by JULIO on 15/11/2017.
 */
//http://www.proyectosimio.com/es/programacion-android-base-de-datos-i-modelo-vista-controlador/
//https://androidexample.com/Use_MVC_Pattern_To_Create_Very_Basic_Shopping_Cart__-_Android_Example/index.php?view=article_discription&aid=116
public class Controller  {

    private Model mdb;

    public Controller(Context context) {
        mdb = new Model(context);
    }

}
