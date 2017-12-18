package com.teachnow.com.teachnow.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.teachnow.com.teachnow.data.QuotesContract;
import com.teachnow.com.teachnow.dominio.Empleo;

/**
 * Created by JULIO on 15/11/2017.
 */
//http://www.tutorialesprogramacionya.com/javaya/androidya/androidstudioya/detalleconcepto.php?codigo=16&inicio=
//https://www.youtube.com/watch?v=hF_m7B6RyhU
//http://elbauldeandroid.blogspot.com.ar/2013/02/base-de-datos-sqlite.html

public class Model extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "ProfesoresAvisos.db";
    private static final String TABLA_AVISOS = "CREATE TABLE " + QuotesContract.QuoteTable.TABLE_NAME + " ( " + QuotesContract.QuoteTable.ID + " integer primary key autoincrement, " +
            QuotesContract.QuoteTable.NOMBRE + " TEXT, " + QuotesContract.QuoteTable.DESCRIPTION + " TEXT, " + QuotesContract.QuoteTable.PHOTOID + " integer)";

    public Model(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_AVISOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Avisos");
        onCreate(db);
    }

    public void insertarAviso(String name, String description, int photoId) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valor = new ContentValues();
            valor.put("name", name);
            valor.put("description", description);
            valor.put("photoid", photoId);
            db.insert("Avisos", null, valor);
        }
        db.close();
    }

    public void modificarAviso(int id, String name, String description) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valor = new ContentValues();
        valor.put("id", id);
        valor.put("name", name);
        valor.put("description", description);
        db.update("Avisos", valor, "id=" + id, null);
        db.close();
    }

    public void borrarAviso(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Avisos", "id=" + id, null);
        db.close();
    }

    public List<Empleo> recuperarAviso(String description) {
        SQLiteDatabase db = getReadableDatabase();

        List<Empleo> empleos = new ArrayList<Empleo>();
        String[] valores_recuperar = {"id", "name", "description", "photoid"};

        Cursor c = db.query(false, "Avisos", valores_recuperar, "description LIKE '%" + description + "%'", null, null, null, null, null);
        if (c.moveToFirst() == true) {
            c.moveToFirst();
            do {
                Empleo empleo = new Empleo(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3));
                empleos.add(empleo);
            } while (c.moveToNext());
        }
        return empleos;
    }

    public List<Empleo> recuperarAvisos() {
        SQLiteDatabase db = getReadableDatabase();

        List<Empleo> lista_empleo = new ArrayList<Empleo>();
        String[] valores_recuperar = {"id", "name", "description", "photoid"};

        Cursor c = db.query("Avisos", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        if (c.moveToFirst() == true) {
            do {
                Empleo empleo = new Empleo(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3));
                lista_empleo.add(empleo);
            } while (c.moveToNext());
        }
        db.close();
        c.close();
        return lista_empleo;
    }

    public Empleo recuperarAvisoPorId(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String[] valores_recuperar = {"id", "name", "description", "photoid"};

        Cursor c = db.query(false, "Avisos", valores_recuperar, "id = '" + id + "'", null, null, null, null, null);

        if (c != null) {
            c.moveToFirst();
        }
        Empleo empleo = new Empleo(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3));
        return empleo;
    }
}