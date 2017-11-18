package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import dominio.Empleo;

/**
 * Created by JULIO on 15/11/2017.
 */
//http://www.tutorialesprogramacionya.com/javaya/androidya/androidstudioya/detalleconcepto.php?codigo=16&inicio=
//https://www.youtube.com/watch?v=hF_m7B6RyhU
//http://elbauldeandroid.blogspot.com.ar/2013/02/base-de-datos-sqlite.html

public class Model extends SQLiteOpenHelper {


    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "Profesores_Avisos.db";
    private static final String TABLA_CONTACTOS = "CREATE TABLE Aviso (_id INT PRIMARY KEY, nombre TEXT, descripcion TEXT)";

    public Model(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Aviso");
        onCreate(db);
    }

    public void insertarAviso(int id, String nom, String descripcion) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("nombre", nom);
            valores.put("descripcion", descripcion);
            db.insert("Aviso", null, valores);
        }
        db.close();
    }

    public void modificarAviso(int id, String nom, String descripcion) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("_id", id);
        valores.put("nombre", nom);
        valores.put("descripcion", descripcion);
        db.update("Aviso", valores, "_id=" + id, null);
        db.close();
    }

    public void borrarAviso(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Aviso", "_id=" + id, null);
        db.close();
    }

    public Empleo recuperarAviso(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"_id", "nombre", "descripcion"};
        Cursor c = db.query("Aviso", valores_recuperar, "_id=" + id, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        Empleo empleo = new Empleo(c.getInt(0), c.getString(1), c.getString(2));
        db.close();
        c.close();
        return empleo;
    }


    public List<Empleo> recuperarAviso() {
        SQLiteDatabase db = getReadableDatabase();
        List<Empleo> lista_empleo = new ArrayList<Empleo>();
        String[] valores_recuperar = {"_id", "nombre", "telefono", "email"};
        Cursor c = db.query("Aviso", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Empleo empleo = new Empleo(c.getInt(0), c.getString(1), c.getString(2));
            lista_empleo.add(empleo);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_empleo;
    }
}