package com.cipolat.slidenavigation;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erika_000 on 03/04/2015.
 *  Extiende de la clase SQLiteOpenHelper que nos proporciona si será en modo lectura o modo escritura
 * (tiene que implementar/override sobreescribir otros dos metodos).
 */

public class DbHelper extends SQLiteOpenHelper {

    //Declaramos 2 constantes. Esta clase necesita dos parametros,
    // el nombre del archivo de la bd y el nombre del archivo de la version , la version del esquema
    private static final String DB_NAME = "cursos_db";
    private static final int DB_SCHEME_VERSION = 1;//Version de tablas de la BD

    //Constructor al que le pasamos el contexto
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);

    }

    //Uno de los metodos es ejecutar SQL y hay que pasarle un String como param cogemos
    // la clase manager y usamos el crear tabla, aun no está creada la BD
    // hasta que no hacemos la llamada en el mainActivity
    //Aqui crearemos las tablas mediante sentencias sql, se le pasa una base de datos de tipo sqlite
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE);

    }




    //Aquí realizaremos las modificaciones de la version de la BD, en muchos ejemplos
    //de prueba, se borra la bd cada vez y se vuelve a crear, pero en una app real no
    //debemos borrarla
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

