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

    private static final int VERSION_DB = 1;
    private static final String NOMBRE_DB = "db_Empleos_Profesores";
    private static final String SQL_TABLA = "create table Empleo(codigo int primary key autoincrement,mensaje text,autor text)";

    public Model(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS avisos");
        insertRegistrosEmpleo("Bueco docente para materia Taller V en Escuela Da Vinci", "Miguel Terre");
        onCreate(db);
        db.close();
    }

    public void insertRegistrosEmpleo(String mensaje, String nombre) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("mensaje", mensaje);
            valores.put("autor", nombre);
            db.insert("Avisos", null, valores);
            db.close();
        }
    }

    public List<Empleo> obtenerRegistrosEmpleo() {
        SQLiteDatabase db = getReadableDatabase();

        String[] valores_recuperar = {"id", "nombre", "descripcion"};
        List<Empleo> lista_empleo = new ArrayList<Empleo>();

        Cursor c = db.query("Empleo", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();

        do {
            Empleo empleo = new Empleo(c.getInt(1), c.getString(1), c.getString(2));
            lista_empleo.add(empleo);
        } while (c.moveToNext());

        db.close();
        c.close();
        return lista_empleo;
    }
}
