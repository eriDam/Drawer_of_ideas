package com.example.erika_000.almacen;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erika_000.almacen.EstructuraDatos.Estructura;

//Ejemplo aplicacion Android en el que utilizamos la API SQLite para realizar
//operaciones sobre una Base de Datos


public class MainActivity extends Activity {
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
        setContentView(R.layout.activity_main);
        
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
    
    //Evento On Click para buscar un producto en la tabla Ventas por nombre
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

		//Cláusula WHERE para buscar por producto
		String producto = Estructura.COLUMN_NAME_TITLE + " = '" +  edProducto.getText().toString() + "'";
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
				//Para mostrar
				dialog = new ProgressDialog(MainActivity.this);
				dialog.setTitle("Mostrar Registros");
				dialog.setMessage("El curso " + edProducto.getText().toString()
						+ " está almacenado con Identificador " + identificador);
				dialog.show();


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
    		//Se establece la condición del _id del producto a modificar
    		String selection = Estructura._ID + " LIKE " + identificador;
    		
    		//Se llama al método update pasándole los parámetros para modificar el producto con el identificado como condición de busqueda
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
