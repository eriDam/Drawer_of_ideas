package com.example.erika_000.devmanager;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erika_000.devmanager.EstructuraDatos.Estructura;

//Ejemplo aplicación Android en el que utilizamos la API SQLite para realizar
//operaciones sobre una Base de Datos

public class AdminLessons extends ActionBarActivity {
    ProgressDialog dialog;
    //Declaramos los controles necesarios para la logica de la aplicación
    private EditText edProducto;
    private EditText edCantidad;
    private EditText edId;
    private Spinner spnSeccion;
    TextView textView_resultado;
    //Declaramos la clase encargada de crear y actualizar la Base de Datos
    MiBaseDatos basedatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lessons);

        //Enlazamos los controles definidos con sus recursos a nivel de layout
        edProducto = (EditText)findViewById(R.id.edProducto);
        edCantidad = (EditText)findViewById(R.id.edCantidad);
        spnSeccion = (Spinner)findViewById(R.id.spinnerSeccion);
        edId = (EditText)findViewById(R.id.edIdentificador);
        textView_resultado = (TextView) findViewById(R.id.textView_resultado);

        //Creamos un Array de String con las secciones de los cursos
        String[] secciones = {"Programacion","Bases de datos","Web","Disenyo","Entornos de desarrollo","Otros"};
        spnSeccion.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, secciones));
    }

    //Evento On Click para guardar un producto en la tabla cursos
    public void guardarProducto(View view)
    {
        //Se inicializa la clase.
        basedatos = new MiBaseDatos(this);
        //Clase que permite llamar a los métodos para crear, eliminar, leer y actualizar registros. Se establecen permisos de escritura.
        SQLiteDatabase sqlite = basedatos.getWritableDatabase();
        String producto = edProducto.getText().toString();
        String cantidad = edCantidad.getText().toString();
        String seccion = spnSeccion.getSelectedItem().toString();

        ContentValues content = new ContentValues();

        if(producto.equals("") || cantidad.equals(""))
        {
            Toast.makeText(this, "Revise los datos introducidos. Todos los campos son obligatorios.",Toast.LENGTH_SHORT).show();
        }else
        {
            //Se añaden los valores introducidos de cada campo mediante clave(columna)/valor(valor introducido en el campo de texto)
            content.put(Estructura.COLUMN_NAME_TITLE,producto);
            content.put(Estructura.COLUMN_NAME_CANTIDAD, cantidad);
            content.put(Estructura.COLUMN_NAME_SECCION, seccion);
            sqlite.insert(Estructura.TABLE_NAME, null, content);
            Toast.makeText(this, "Curso " + producto + " ha sido almacenado.",Toast.LENGTH_SHORT).show();
            edProducto.setText("");
            edCantidad.setText("");
            edId.setText("");
        }
        //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();
    }

    //Evento On Click para buscar un producto en la tabla  por nombre
    public void buscarProducto(View view)
    {
        //Se inicializa la clase.
        basedatos = new MiBaseDatos(this);
        //Se establecen permisos de lectura
        SQLiteDatabase sqlite = basedatos.getReadableDatabase();
        //Columnas que devolverá la consulta.
        String[] columnas = {
                Estructura._ID,
                Estructura.COLUMN_NAME_TITLE,
                Estructura.COLUMN_NAME_CANTIDAD,
                Estructura.COLUMN_NAME_SECCION
        };

        //Cláusula WHERE para buscar por producto
        String producto = Estructura.COLUMN_NAME_TITLE + " LIKE '" +  edProducto.getText().toString() + "'";
        //Orden de los resultados devueltos por Producto, de forma Descendente alfabéticamente
        String ordenSalida = Estructura.COLUMN_NAME_TITLE + " DESC";

        if(producto.equals(""))
        {
            Toast.makeText(this, "Debe indicar el curso a buscar en la base de datos.",Toast.LENGTH_SHORT).show();
        }else
        {
            //Ejecuta la sentencia devolviendo los resultados de los parámetros pasados de tabla, columnas, producto y orden de los resultados.
            Cursor cursor = sqlite.query(Estructura.TABLE_NAME, columnas, producto,null , null, null, ordenSalida);

            if(cursor.getCount() != 0)
            {
                cursor.moveToFirst();

                long identificador = cursor.getLong(cursor.getColumnIndex(Estructura._ID));
                Toast.makeText(this, "El curso " +  edProducto.getText().toString()
                        + " está almacenado con Identificador " + identificador, Toast.LENGTH_SHORT).show();

                textView_resultado.setText("El curso " +  edProducto.getText().toString()
                        + " está almacenado con Identificador " + identificador);
                edProducto.setText("");
                edCantidad.setText("");
                edId.setText("");

            }
            else
            {
                Toast.makeText(this, "El Curso '" + edProducto.getText().toString()  + "' no existe en la Base de Datos.", Toast.LENGTH_SHORT).show();
            }

        }
        //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();

    }
    //Evento On Click para buscar un producto en la tabla Cursos por nombre
    public void verProductos(View view)
    {
        //Se inicializa la clase.
        basedatos = new MiBaseDatos(this);
        //Se establecen permisos de lectura
        SQLiteDatabase sqlite = basedatos.getReadableDatabase();
        //Columnas que devolverá la consulta.
        String[] columnas = {
                Estructura._ID,
                Estructura.COLUMN_NAME_TITLE,
                Estructura.COLUMN_NAME_CANTIDAD,
                Estructura.COLUMN_NAME_SECCION
        };

        //Cláusula WHERE para buscar por curso
        String producto = Estructura.COLUMN_NAME_TITLE +  " = '" +  edProducto.getText().toString() + "'";
        //Orden de los resultados devueltos por Producto, de forma Descendente alfabéticamente
        String ordenSalida = Estructura.COLUMN_NAME_TITLE + " DESC";

        if(producto.equals(""))
        {
            Toast.makeText(this, "Debe indicar el curso a buscar en la base de datos.",Toast.LENGTH_SHORT).show();
        }else
        {
            //Ejecuta la sentencia devolviendo los resultados de los parámetros pasados de tabla, columnas, producto y orden de los resultados.
            Cursor cursor = sqlite.query(Estructura.TABLE_NAME, columnas, producto,null , null, null, ordenSalida);

            if(cursor.getCount() != 0)
            {
                cursor.moveToFirst();

                long identificador = cursor.getLong(cursor.getColumnIndex(Estructura._ID));
//				//Para mostrar
//				dialog = new ProgressDialog(MainActivity.this);
//				dialog.setTitle("Mostrar Registros");
//				dialog.setMessage("El curso " + edProducto.getText().toString()
//						+ " está almacenado con Identificador " + identificador);
//				dialog.show();

                //Creo un string para almacenar el resultado
                String resultado = ("El curso " + edProducto.getText().toString()
                        + " está almacenado con Identificador " + identificador +" en la sección "+ spnSeccion.getSelectedItem().toString());

                //Utilizo la función para mostrar resultados en base a la eleccion del user de si quiere continuar o no
                eleccionResultados(resultado);

                //Pongo el resultado tambien en un text
                textView_resultado.setText("El curso " + edProducto.getText().toString()
                        + " está almacenado con Identificador " + identificador);
//
//               Toast.makeText(this, "El curso " +  edProducto.getText().toString()
//						+ " está almacenado con Identificador " + identificador, Toast.LENGTH_SHORT).show();
//
                edProducto.setText("");
                edCantidad.setText("");
                edId.setText("");

            }
            else
            {
                Toast.makeText(this, "El Curso '" + edProducto.getText().toString()  + "' no existe en la Base de Datos.", Toast.LENGTH_SHORT).show();
            }

        }
        //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();

    }
    /**
    Devuelve cursor con todos las columnas del registro
      */
    public void verTodo(View v) {
        //Se inicializa la clase.
        basedatos = new MiBaseDatos(this);
        //Se establecen permisos de lectura
        SQLiteDatabase sqlite = basedatos.getReadableDatabase();
        //Columnas que devolverá la consulta.
        String[] columnas = {
                Estructura._ID,
                Estructura.COLUMN_NAME_TITLE,
                Estructura.COLUMN_NAME_CANTIDAD,
                Estructura.COLUMN_NAME_SECCION
        };

        //Cláusula WHERE para buscar por curso
        //String producto = Estructura.COLUMN_NAME_TITLE + Estructura.COLUMN_NAME_CANTIDAD + Estructura.COLUMN_NAME_SECCION;
        //Orden de los resultados devueltos por Producto, de forma Descendente alfabéticamente
        String ordenSalida = Estructura.COLUMN_NAME_TITLE + " DESC";
//       if(producto.equals(""))
//       {
////            Toast.makeText(this, "Debe indicar el curso a buscar en la base de datos.",Toast.LENGTH_SHORT).show();
//      }else
//      {
            //Ejecuta la sentencia devolviendo los resultados de los parámetros pasados de tabla, columnas, producto y orden de los resultados.
            Cursor cursor = sqlite.query(Estructura.TABLE_NAME, columnas, null,null , null, null, ordenSalida);

            if(cursor.getCount() != 0)
            {
                do {

                cursor.moveToFirst();

                long identificador = cursor.getLong(cursor.getColumnIndex(Estructura._ID));
                String titulo = cursor.getString(cursor.getColumnIndex(Estructura.COLUMN_NAME_TITLE));
                String cantidad = cursor.getString(cursor.getColumnIndex(Estructura.COLUMN_NAME_CANTIDAD));
                String seccion = cursor.getString(cursor.getColumnIndex(Estructura.COLUMN_NAME_SECCION));

                    String resultado = ("El curso " + titulo
                          + " está almacenado con Identificador " + identificador +" en la sección "+ seccion + " y tiene " +cantidad + " lecciones" );


                    // String resultado = ("El curso " + edProducto.getText().toString()
                   //     + " está almacenado con Identificador " + identificador +" en la sección "+ spnSeccion.getSelectedItem().toString());

                //Utilizo la función para mostrar resultados en base a la eleccion del user de si quiere continuar o no
                eleccionResultados(resultado);
               ///////////////////////
                }  while(cursor.moveToNext());
            }
      //  }//else
    }

    /**
     * Mensaje en pantalla que desaparece tras pulsar alguna de sus opciones
     *
     */
    public void eleccionResultados(String cadena){
        //se prepara la alerta creando nueva instancia
        final AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        //seleccionamos la cadena a mostrar
        alertbox.setTitle("Resultados");
        alertbox.setMessage(cadena);
        //elegimos un positivo SI y creamos un Listener
        alertbox.setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
            //Funcion llamada cuando se pulsa el boton Siguiente
            public void onClick(DialogInterface arg0, int arg1) {
                mensaje("Siguiente");
            }
        });

        //elegimos un positivo Salir y creamos un Listener
        alertbox.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            //Funcion llamada cuando se pulsa el boton Salir
            public void onClick(DialogInterface arg0, int arg1) {

                mensaje("Pulsado el botón Salir");
            }
        });

        //mostramos el alertbox
        alertbox.show();
    }
    public void mensaje(String cadena){
        Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show();
    }
    //Evento On Click para eliminar un producto de la tabla Ventas por el nombre
    public void borrarProducto(View view)
    {

        String producto_eliminar = edProducto.getText().toString();
        //Se inicializa la clase.
        basedatos = new MiBaseDatos(this);
        //Se establecen permisos de escritura
        SQLiteDatabase sqlite = basedatos.getWritableDatabase();
        if(producto_eliminar.equals(""))
        {
            Toast.makeText(this, "Debe indicar el curso a eliminar de la base de datos.",Toast.LENGTH_SHORT).show();
        }else
        {
            //Se especifica el campo Producto y el producto introducido en el campo de texto a eliminar
            String consulta = Estructura.COLUMN_NAME_TITLE + " LIKE '" + producto_eliminar + "'";
            //Se borra el producto indicado en el campo de texto
            sqlite.delete(Estructura.TABLE_NAME, consulta, null);
            Toast.makeText(this, "Se ha eliminado el curso: " + producto_eliminar, Toast.LENGTH_SHORT).show();
            edProducto.setText("");
            edCantidad.setText("");
            edId.setText("");

        }
        //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();
    }

    //Evento On Click para modificar un producto de la tabla Ventas. Todos los campos son modificables, excepto el campo _id
    public void modificarProducto(View view)
    {
        //Se inicializa la clase.
        basedatos = new MiBaseDatos(this);

        //Se establecen permisos de escritura
        SQLiteDatabase sqlite = basedatos.getWritableDatabase();

        Long identificador = Long.valueOf(edId.getText().toString());
        String producto_modificar = edProducto.getText().toString();
        String cantidad_modificar = edCantidad.getText().toString();
        String seccion_modificar = spnSeccion.getSelectedItem().toString();

        ContentValues content = new ContentValues();
        //Se añaden los valores introducidos de cada campo mediante clave(columna)/valor(valor introducido en el campo de texto)
        content.put(Estructura.COLUMN_NAME_TITLE, producto_modificar);
        content.put(Estructura.COLUMN_NAME_CANTIDAD, cantidad_modificar);
        content.put(Estructura.COLUMN_NAME_SECCION, seccion_modificar);
        if(producto_modificar.equals("") || cantidad_modificar.equals(""))
        {
            Toast.makeText(this, "Revise los datos introducidos. Todos los campos son obligatorios.", Toast.LENGTH_SHORT).show();
        }else
        {
            //Se establece la condición del _id del curso a modificar
            String selection = Estructura._ID + " LIKE " + identificador;

            //Se llama al método update pasándole los parámetros para modificar el curso con el identificado como condición de busqueda
            int count = sqlite.update(
                    Estructura.TABLE_NAME,
                    content,
                    selection,
                    null);
            Toast.makeText(this, "Se ha actualizado el curso: " + producto_modificar +
                    ". Registros modificados: " + count, Toast.LENGTH_SHORT).show();
            edProducto.setText("");
            edCantidad.setText("");
            edId.setText("");
        }
        //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

//    private EditText et1,et2,et3;
//    private TextView txt_result;
//    private ProgressDialog dialog;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_admin_lessons);
//
//        et1=(EditText)findViewById(R.id.editText);
//        et2=(EditText)findViewById(R.id.editText2);
//        et3=(EditText)findViewById(R.id.editText3);
//        txt_result = (TextView) findViewById(R.id.txt_result);
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_admin_lessons, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        {
//            switch (item.getItemId()) {
//                case R.id.menu_inicio:
//                    Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
//                    //arrancar la siguiente activity
//                    Intent abre;
//                    abre = new Intent(AdminLessons.this, MainActivity.class);
//                    startActivity(abre);
//                    finish();//finalizo activity para liberar memoria
//                    return true;
//                case R.id.menu_devtest:
//                    Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
//                    //arrancar la siguiente activity
//                    Intent abreDev;
//                    abreDev = new Intent(AdminLessons.this, DevTest.class);
//                    startActivity(abreDev);
//
//                    return true;
//                case R.id.menu_lessons:
//                    Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
//                    //arrancar la siguiente activity
//                    Intent abreLessons;
//                    abreLessons = new Intent(AdminLessons.this, Lessons2Activity.class);
//                    startActivity(abreLessons);
//
//                    return true;
//                case R.id.menu_profile:
//                    Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
//                    //arrancar la siguiente activity
//                    Intent abreProf;
//                    abreProf = new Intent(AdminLessons.this, Prof3Activity.class);
//                    startActivity(abreProf);
//
//                    return true;
//                case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
//                    Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
//                    //arrancar la siguiente activity
//                    Intent abreGit;
//                    abreGit = new Intent(AdminLessons.this, OnCode4Activity.class);
//                    startActivity(abreGit);
//
//                    return true;
//
//                case R.id.menu_blog:
//                    Toast.makeText(getApplicationContext(), "BLOG", Toast.LENGTH_SHORT).show();
//                    //arrancar la siguiente activity
//                    Intent abreBlog;
//                    abreBlog = new Intent(AdminLessons.this, Blog6Activity.class);
//                    startActivity(abreBlog);
//
//                    return true;
//                case R.id.action_settings:
//                    Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
//                    //TODO crear opciones de personalización
////                //arrancar la siguiente activity
//                    Intent abreGestionOld;
//                    abreGestionOld = new Intent(AdminLessons.this, Gestion5Lessons.class);
//                    startActivity(abreGestionOld);
//                    return true;
//                default:
//                    return super.onOptionsItemSelected(item);
//            }
//        }
//    }
//
//    public void alta(View v) {
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
//                "administracion", null, 1);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//        String cod = et1.getText().toString();
//        String descri = et2.getText().toString();
//        String pre = et3.getText().toString();
//        ContentValues registro = new ContentValues();
//        registro.put("codigo", cod);
//        registro.put("descripcion", descri);
//        registro.put("precio", pre);
//        bd.insert("articulos", null, registro);
//        bd.close();
//        et1.setText("");
//        et2.setText("");
//        et3.setText("");
//        Toast.makeText(this, "Se han guardado los datos del curso",
//                Toast.LENGTH_SHORT).show();
//    }
//
//    public void consultaporcodigo(View v) {
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
//                "administracion", null, 1);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//        String cod = et1.getText().toString();
//        Cursor fila = bd.rawQuery(
//                "select descripcion,precio from articulos where codigo=" + cod, null);
//        if (fila.moveToFirst()) {
//            et2.setText(fila.getString(0));
//            et3.setText(fila.getString(1));
//        } else
//            Toast.makeText(this, "No existe un articulo con dicho codigo",
//                    Toast.LENGTH_SHORT).show();
//        bd.close();
//    }
//
//    public void consultapordescripcion(View v) {
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
//                "administracion", null, 1);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//        String descri = et2.getText().toString();
//        Cursor fila = bd.rawQuery(
//                "select codigo,precio from articulos where descripcion='" + descri +"'", null);
//        if (fila.moveToFirst()) {
//            et1.setText(fila.getString(0));
//            et3.setText(fila.getString(1));
//        } else
//            Toast.makeText(this, "No existe un articulo con dicha descripcion",
//                    Toast.LENGTH_SHORT).show();
//        bd.close();
//    }
//
//    public void bajaporcodigo(View v) {
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
//                "administracion", null, 1);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//        String cod= et1.getText().toString();
//        int cant = bd.delete("articulos", "codigo=" + cod, null);
//        bd.close();
//        et1.setText("");
//        et2.setText("");
//        et3.setText("");
//        if (cant == 1)
//            Toast.makeText(this, "Se borro el articulo con dicho codigo",
//                    Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(this, "No existe un articulo con dicho codigo",
//                    Toast.LENGTH_SHORT).show();
//    }
//
//    public void modificacion(View v) {
//        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
//                "administracion", null, 1);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//        String cod = et1.getText().toString();
//        String descri = et2.getText().toString();
//        String pre = et3.getText().toString();
//        ContentValues registro = new ContentValues();
//        registro.put("codigo", cod);
//        registro.put("descripcion", descri);
//        registro.put("precio", pre);
//        int cant = bd.update("articulos", registro, "codigo=" + cod, null);
//        bd.close();
//        if (cant == 1)
//            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
//                    .show();
//        else
//            Toast.makeText(this, "no existe un curso con el codigo ingresado",
//                    Toast.LENGTH_SHORT).show();
//    }
//    /**
//     * Devuelve cursor con todos las columnas del registro
//     */
//    public void verTod(View v) {
//      AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
//            "administracion", null, 1);
//        SQLiteDatabase bd = admin.getWritableDatabase();
//        Cursor c = bd.rawQuery(
//                "SELECT codigo,descripcion,precio FROM articulos ORDER BY codigo", null);
//        //Nos aseguramos de que existe al menos un registro
//        if (c.moveToFirst()) {
//            //Recorremos el cursor hasta que no haya más registros
//            do {
//
//                String codigo= c.getString(0);
//                String descripcion = c.getString(1);
//                String precio = c.getString(2);
//                //Creo un string para almacenar el resultado del cursor
//                String resultado = ("CURSO:\n"+"Id: " + codigo +
//                                    "\nNombre: " + descripcion +
//                                    "\nLink: " + precio);
//                //Utilizo la función para mostrar resultados en base a la eleccion del user de si quiere continuar o no
//                eleccionResultados(resultado);
//
//            } while(c.moveToNext());
//        }
////        //Nos movemos al primer registro de la consulta
////        if (c != null) {
////            c.moveToFirst();
////            txt_result.setText(c.getString(1));
////
////        }
//
//    }
//
//    /**
//     * Mensaje en pantalla que desaparece tras pulsar alguna de sus opciones
//     *
//     */
//    public void eleccionResultados(String cadena){
//        //se prepara la alerta creando nueva instancia
//        final AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
//        //seleccionamos la cadena a mostrar
//        alertbox.setTitle("Resultados");
//        alertbox.setIcon(R.drawable.ic_ok_database);
//        alertbox.setMessage(cadena);
//        //elegimos un positivo SI y creamos un Listener
//        alertbox.setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
//            //Funcion llamada cuando se pulsa el boton Siguiente
//            public void onClick(DialogInterface arg0, int arg1) {
//                mensaje("Siguiente");
//            }
//        });
//
//        //elegimos un positivo Salir y creamos un Listener
//        alertbox.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
//            //Funcion llamada cuando se pulsa el boton Salir
//            public void onClick(DialogInterface arg0, int arg1) {
//
//                mensaje("Pulsado el botón Salir");
//            }
//        });
//
//        //mostramos el alertbox
//        alertbox.show();
//    }
//    /**
//     * Mensaje en pantalla que desaparece tras un tiempo (SHORT o LONG)
//     *
//     */
//    public void mensaje(String cadena){
//        Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show();
//    }
//
//}
