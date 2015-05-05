package com.cipolat.slidenavigation;

/**
 * Created by erika_000 on 03/04/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by erika_000 on 23/03/2015.
 * Se va a encargar de la gestión de la BD y las operaciones CRUD
 * Create
 * Read
 * Update
 * Delete
 */
public class DataBaseManager {

    //1º Necesitamos el nombre de la tabla
    public static final String TABLE_NAME = "cursos";//Aunque se llame = q la bd no interfiere
    //Nombres de los Campos de la tabla, CN de columnName
    public static final String CN_ID = "_id";//Es un campo que se genera solo, autoincremental
    public static final String CN_TITLE = "titulo";//titulo del curso
    public static final String CN_LINK = "link";//link del curso

    //Sentencia SQL para crear la tabla, android provee de métodos que ayudan a realizar operaciones
    //contra la BD, pero es necesario saber de SQL.

    /* A CONTINUACIÓN LA SENTENCIA EN SQL:
    create table contactos(
                         _id integer primary key autoincrement,
                          nombre text not null,
                          telefono text);*/

    //Así se crea la sentencia mediante código Java
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_TITLE + " text not null,"
            + CN_LINK + " text);";

    //Hacemos los objetos privados para manejarlos con nuestros métodos
    private DbHelper helper;
    private SQLiteDatabase db;

    //Constructor
    // le pasamos el contexto como en la clase  y en el constructor de DbHelper
    //se pueden crear métodos para modos lectura o escritura, pero no lo voy a
    // hacer, lo hago en el constructor  por que siempre va a estar en modo escritura

    public DataBaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();//Inicio la bd en modo escritura

     /*
        db.insert();
        //comando SQL es como 1 string con la función que queremos utilizar,
        //Devuelve si la oper se ha realizado ok, -1 si error valor random si ok
        db.execSQL();
        db.rawQuery();//es como realizar una consulta, devuelve un cursor*/
    }//fin constructor

    //Método, genera un contenedor de valores que va a devolver el contenedor de valores,
    //para no tener que escribirlo cada vez
    private ContentValues generarContentValues(String titulo, String link) {
        ContentValues valores = new ContentValues();//Contenedor  de valores
        valores.put(CN_TITLE, titulo);//Añado - Hay que indicarle el nombre del campo y el valor
        valores.put(CN_LINK, link);//Añado - Hay que indicarle el nombre del campo y el valor
        return valores;//devuelve el contenedor
    }

    //Método INSERT, debemos pasar los datos a insertar (o creando una clase)
    public void insertar(String titulo, String link) {
        //bd.insert(TABLA, NullColumnHack, ContentValues);
        //El NullColumnHack es 1 especie de añadido para hacer compatibles con otras
        //bd a SQLite, en SQLite le tenemos que indicar como mínimo un campo que pueda ser nulo
        //le pasamos la función de generar Valores con sus parámetros, por buenas prácticas, se ve
        //mas legible.
        db.insert(TABLE_NAME, null, generarContentValues(titulo, link));
    }

    //Método INSERT con execSQL, si devuelve -1 error, si devuelve otro valor random ok
    //con este comando, no necesitamos un contenedor de valores, es preferible utilizar los métodos de Android como el 1º
    public void insertar2(String titulo, String link) {
        //Debemos escribir la sentencia SQL que queremos ejecutar, "" x que es un texto
        //Nombre table controlar espacios y comillas , null para un valor nulo obligado, cuando llega a la ' le estamos pasando los parametros
        //usamos la , para añadir el otro param
        // INSERT INTO contactos   VALUES (null,'título',link)
        db.execSQL("insert into " + TABLE_NAME + " values (null,'" + titulo + "','" + link + "')");

    }

    //Método DELETE, solo borrará por 1 campo titulo
    public void eliminar(String titulo) {
        //bd.delete (Tabla, Claúsula Where, Argumentos Where),
        //la sentencia "=?" significa que ?se sustituye por lo que pongamos a continuación
        //un array de String, po ruqe podemos pasar varios titulos y que los borre a la vez
        db.delete(TABLE_NAME, CN_TITLE + "=?", new String[]{titulo});
    }

    //Método MULTIPLE DELETE, mismo método que anterior pero cambia, en lugar de =(no podemos igualar a 2 nombres)
    //en lugar de = utilizamos "IN (?,?)", para pasarle 2 titulos y cada 'param sustituye a la ?
    public void eliminarMultiple(String titulo1, String titulo2) {
        db.delete(TABLE_NAME, CN_TITLE + "IN (?,?)", new String[]{titulo1, titulo2});
    }

    public void modificarLink(String titulo, String nuevoLink) {
        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, generarContentValues(titulo, nuevoLink), CN_TITLE + "=?", new String[]{titulo});
    }

    /*
    * Un cursor almacena el resultado de una consulta en la base de datos, podrías verlo como una colección de
     * registros o filas como si de una tabla se tratase. Además, la clase Cursor nos proporciona métodos,
     * para poder movernos por los resultados.
     *
     * Para hacer una consulta a la base de datos y que nos devuelva valores, tenemos dos opciones,
     * una utilizar el método rawQuery("Select...").
     * Y la segunda forma y es la que veremos aquí es con el método query que nos proporciona android.
     *
     * Nota Mental: si usas SimpleCursoAdapter para mostrar datos, este adaptador requiere la columna _id.
     *
     * Esto puede suponer una operación muy costosa tanto en memoria como en la operación de lectura si
     * tratásemos con una gran cantidad de datos, y además puede darnos en ese caso un ANR o Application
     * Not Responding, donde al usuario le mostrará un mensaje con la opción de Esperar ( a que termine
     * de realizar la consulta) o Forzar Cierre ( y esto no lo queremos).
     * Para evitar un ANR, basta con trabajar en segundo plano BACKGROUND
     * */


    //Creamos una clase Cursor
    //Método que nos devuelve todos los cursos que tengamos en la base de datos en un listView, podemos recorrer
    //el cursor de abajo arriba o ir a una pos exacta, hay métodos para mostrar de 10 en 10 y no saturar de memoria
    public Cursor cargarCursorCursos() {
        String[] columnas = new String[]{CN_ID, CN_TITLE, CN_LINK};//Le paso todos los campos
        //El método query tiene la siguiente estructura:
        //query (String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }

    //Método para buscar un curso por el nombre, utilizaremos el siguiente método:
    public Cursor buscarCurso(String titulo) {
        String[] columnas = new String[]{CN_ID, CN_TITLE, CN_LINK};
        //Colocamos el return y le pasamos el nombre de la Tabla, columnas, vamos a buscar por titulo, clasusula where =?
        // hacemos un new String[]{titulo}que es lo que queremos obtener, el resto null, son order by, short etc...
        return db.query(TABLE_NAME, columnas, CN_TITLE + "=?", new String[]{titulo}, null, null, null);
        //Probado:
    //(TABLE_NAME,columnas,CN_TITLE + "LIKE '%"+"=?"+"%'",new String[]{titulo},null,null,null);
    //(TABLE_NAME,columnas,CN_TITLE + "'%=?%'",new String[]{titulo},null,null,null);
    //(TABLE_NAME,columnas,CN_TITLE + "LIKE ?",new String[]{titulo},null,null,null);
}

    //Prueba2
//    public Cursor buscarCursoT(String titulo) {
//        String[] columnas = new String[]{CN_ID, CN_TITLE, CN_LINK};
//        Cursor c = db.rawQuery("SELECT * " +
//                TABLE_NAME + " where " + titulo + " like '%", null);
//        return c;
//    }
}
