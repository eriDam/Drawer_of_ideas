package com.example.erika_000.devmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by erika_000 on 03/05/2015.
 */
public class DataBaseMan extends SQLiteOpenHelper {
    //Datos de la tabla
    final private static String NAME = "cursos_db";
    final static String TABLE_NAME = "cursos";

    final static String ID = "_id";
    final static String LESSON_NAME = "titulo";

    //Comandos
    final static String[] columns = { ID, LESSON_NAME };
    final private static String CREATE_CMD =

            "CREATE TABLE "+ TABLE_NAME +" (" + ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + LESSON_NAME + " TEXT NOT NULL)";


    final private static Integer VERSION = 1;
    final private Context mContext;


    //Modos edicion
    public static final String C_MODO  = "modo" ;
    public static final int C_VISUALIZAR = 551 ;
    public static final int C_CREAR = 552 ;
    public static final int C_EDITAR = 553 ;

    //Constructor
    public DataBaseMan(Context context) {
        super(context, NAME, null, VERSION);
        this.mContext = context;
    }

    //Creación de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la base de datos
        Log.i(this.getClass().toString(), "Tabla CURSOS creada");
        db.execSQL(CREATE_CMD);
        //La rellenamos
        ContentValues values = new ContentValues();

        values.put(DataBaseMan.LESSON_NAME, "C++");
        db.insert(DataBaseMan.TABLE_NAME, null, values);
        values.clear();

        values.put(DataBaseMan.LESSON_NAME, "Qt");
        db.insert(DataBaseMan.TABLE_NAME, null, values);
        values.clear();

        values.put(DataBaseMan.LESSON_NAME, "Android-Java");
        db.insert(DataBaseMan.TABLE_NAME, null, values);
        Log.i(this.getClass().toString(), "Datos insertados");
    }

    //Actualización de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // N/A
    }

    //Borrando de la base de datos
//    void deleteDatabase() {
//        mContext.deleteDatabase(NAME);
//    }

    //Lectura de la base de datos
    public Cursor readArtistas(SQLiteDatabase db) {
        return db.query(TABLE_NAME,
                columns, null, new String[] {}, null, null,
                null);
    }

    /**
     * Devuelve cursor con todos las columnas del registro
     */
    public Cursor getRegistro(long id) throws SQLException
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c = db.query( true, TABLE_NAME, columns, ID + "=" + id, null, null, null, null, null);

        //Nos movemos al primer registro de la consulta
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    /**
     * Inserta los valores en un registro de la tabla
     */
    public long insert(ContentValues reg)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.insert(TABLE_NAME, null, reg);
    }
    /**
     * Inserta los valores en un registro de la tabla
     */
    public long update(ContentValues reg)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        if (reg.containsKey(ID))
        {
            //
            // Obtenemos el id y lo borramos de los valores
            //
            long id = reg.getAsLong(ID);

            reg.remove(ID);

            //
            // Actualizamos el registro con el identificador que hemos extraido
            //
            return db.update(TABLE_NAME, reg, "_id=" + id, null);
        }
        return db.insert(TABLE_NAME, null, reg);
    }
}


