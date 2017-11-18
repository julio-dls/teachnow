package data;

import android.provider.BaseColumns;

/**
 * Created by JULIO on 18/11/2017.
 */

public class QuotesContract {

    public static abstract class QuoteTable implements BaseColumns {
        public static final String TABLE_NAME = "Avisos";

        public static final String ID = "Id";
        public static final String NOMBRE = "Nombre";
        public static final String DESCRIPCION = "descripcion";
    }
}