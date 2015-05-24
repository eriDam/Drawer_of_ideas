package com.example.erika_000.devmanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AdminLessons extends ActionBarActivity {

    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lessons);

        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /** Cuando se presiona el botón "ALTA" se ejecuta el método "alta" recordemos inicializar la
     * propiedad "onClick" del botón desde la ventana de visualización del archivo XML.
     Crear un objeto de la clase que planteamos anteriormente y le pasamos al constructor this
     (referencia del Activity actual),
     "administracion" (es el nombre de la base de datos que crearemos en el caso que no exista)
     luego pasamos null y un uno indicando que es la primer versión de la base de datos
     (en caso que cambiemos la estructura o agreguemos tablas por ejemplo podemos pasar un
     dos en lugar de un uno para que se ejecute el método onUpgrade donde indicamos la nuestra
     estructura de la base de datos)*/
    public void alta(View v) {
        /**Crear un objeto de la clase AdminSqLiteOpenHelper*/
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        /**Crear un objeto de la clase  SQLiteDataBase llamando al método getWritableDatabase
                (la base de datos se abre en modo lectura y escritura).*/
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();

       //Creamos un objeto de la clase ContentValues
        ContentValues registro = new ContentValues();
       // y mediante el método put, inicializamos todos los campos a cargar.
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        /** llamamos al método insert de la clase SQLiteDatabase pasando en el primer parámetro
         * el nombre de la tabla, como segundo parámetro un null y por último el objeto de
         * la clase ContentValues ya inicializado (este método es el que provoca que se inserte
         * una nueva fila en la tabla cursos en la base de datos llamada administracion)*/
        bd.insert("articulos", null, registro);
        bd.close();

        /**Borramos seguidamente los EditText y mostramos un mensaje para que conozca el
         * usuario que el alta de datos se ha hecho de  forma correcta:*/
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this, "Se han cargado los datos del curso",
                Toast.LENGTH_SHORT).show();
    }
//Cuando se presiona el botón "CONSULTA POR CODIGO" se ejecuta el método consultaporcodigo,
    //Le hemos pasado en el xml el método onclick
    public void consultaporcodigo(View v) {
       /** En el método consultaporcodigo lo primero que hacemos es crear un objeto de la clase
        AdminSQLiteOpenHelper y obtener una referencia de la base de datos
        llamando al método getWritableDatabase*/
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();


        String cod = et1.getText().toString();
        //definimos una variable de la clase Cursor y la inicializamos con el valor devuelto
        // por el método llamado rawQuery.
        /**La clase Cursos almacena en este caso una fila o cero filas (una en caso que hayamos
         * ingresado un codigo existente en la tabla articulos), llamamos al método moveToFirst()
         * de la clase Cursor y retorna true en caso de existir un articulo con el codigo
         * ingresado, en caso contrario retorna cero.*/
        Cursor fila = bd.rawQuery(
                "select descripcion,precio from articulos where codigo=" + cod, null);
        if (fila.moveToFirst()) {
           /*Para recuperar los datos propiamente dichos que queremos consultar llamamos al
           método getString y le pasamos la posición del campo a recuperar (comienza a numerarse
           en cero, en este ejemplo la columna cero representa el campo descripcion y la columna
           1 representa el campo precio)*/
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un curso con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();//cerramos bd
    }
//Cuando se presiona el botón "CONSULTA POR DESCRIPCION" se ejecuta
// el método consultapordescripcion:
    public void consultapordescripcion(View v) {
       //crear un objeto de la clase AdminSQLiteOpenHelper y obtener una
       // referencia de la base de datos llamando al método getWritableDatabase.
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String descri = et2.getText().toString();
        /** Definimos una variable de la clase Cursor y la inicializamos con el valor devuelto
         * por el método llamado rawQuery.
         * Es importante notar en el where de la clausula SQL hemos dispuesto
         * comillas simples entre el contenido de la variable descri:*/
        Cursor fila = bd.rawQuery(
                //Esto es obligatorio para los campos de tipo text (en este caso descripcion es de tipo text)
                "select codigo,precio from articulos where descripcion='" + descri +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un curso con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    //Ver todos
    //Lectura de la base de datos
//    public Cursor readAll(View v) {
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
//                "administracion", null, 1);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//
////        return db.query(TABLE_NAME,
////                columns, null, new String[] {}, null, null,
////                null);
//    }
//
//    /**
//     * Devuelve cursor con todos las columnas del registro
//     */
//    public Cursor getRegistro(long id) throws SQLException
//    {
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor c = db.query(true, TABLE_NAME, columns, ID + "=" + id, null, null, null, null, null);
//
//        //Nos movemos al primer registro de la consulta
//        if (c != null) {
//            c.moveToFirst();
//        }
//        return c;
//    }

    public void bajaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et1.getText().toString();
        int cant = bd.delete("articulos", "codigo=" + cod, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró el curso con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un curso con dicho código",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        int cant = bd.update("articulos", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se han modificado los datos del curso", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe un curso con el código introducido",
                    Toast.LENGTH_SHORT).show();
    }

}
