package com.teachnow.com.teachnow.data;

import android.provider.BaseColumns;

/**
 * Created by JULIO on 18/11/2017.
 */

public class QuotesContract {

    public static abstract class QuoteTable implements BaseColumns {
        public static final String TABLE_NAME = "Avisos";

        public static final String ID = "id";
        public static final String NOMBRE = "name";
        public static final String DESCRIPTION = "description";
    }
}