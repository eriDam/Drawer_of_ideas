package com.cipolat.slidenavigation;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ManagerBdActivity extends ActionBarActivity {
    //Con una instancia d la clase DataBaseManager pasandole el contexto this,
    // ya nos crea nuestro Helper y nuestro objeto SQLite,
    // Declaro la Bd
    private DataBaseManager managerDb;
    //Creo el objeto cursor
    private Cursor cursor;
    //Declaro el ListView
    private ListView lista;
    //Declaro un SimpleCursorAdapter
    SimpleCursorAdapter adapter;


    //Declaro los controles a utilizar
    Button btn_crear;
    Button btn_insertar;
    Button btn_buscar;
    Button btn_editar;
    Button btn_eliminar;
    Button btn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_fragment);

        //Le paso this para pasarle el contexto de la clase
//        DbHelper helper = new DbHelper(this);
//        SQLiteDatabase db = helper.getWritableDatabase();
        //Inicio el objeto de la BD
        managerDb = new DataBaseManager(this);


        //BOTÓN  CREAR
        btn_crear = (Button)findViewById(R.id.btn_crear);//Recupero el control ya declarado en la clase
        btn_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aviso de que ha sido creada la bd, pero ha sido creada cuando inicio objeto de la BD
                Toast.makeText(getApplicationContext(), "BD creada correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        //BOTON INSERTAR
        btn_insertar =(Button)findViewById(R.id.btn_insertar);
        btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        /*ejemplos de uso*/

                managerDb.insertar("C++","http://www.c.conclase.net/curso/index.php?cap=001#inicio");
                Toast.makeText(getApplicationContext(), "Insert ok C++", Toast.LENGTH_SHORT).show();
                managerDb.insertar2("C++1","http://www.c.conclase.net/curso/index.php?cap=001#inicio");
                Toast.makeText(getApplicationContext(), "Insert ok C++1", Toast.LENGTH_SHORT).show();
                managerDb.insertar("C++2","http://www.c.conclase.net/curso/index.php?cap=001#inicio");
                Toast.makeText(getApplicationContext(), "Insert ok C++2", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Inserts Realizados", Toast.LENGTH_SHORT).show();

            }
        });

        //Botón Buscar
        btn_buscar = (Button)findViewById(R.id.btn_buscar);
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arrancar la siguiente activity para cagar en ella el cursor y el listView
                Intent abrirLista = new Intent().setClass(
                        ManagerBdActivity.this, Activity_ListView.class);
                startActivity(abrirLista);
            }
        });

        //Botón editar
        btn_editar = (Button)findViewById(R.id.btn_editar);
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arrancar la siguiente activity para cagar en ella el cursor y el listView
                Intent abrirListaEd = new Intent().setClass(
                        ManagerBdActivity.this, Activity_ListView.class);
                startActivity(abrirListaEd);
            }
        });

        btn_eliminar = (Button)findViewById(R.id.btn_eliminar);
        btn_eliminar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                managerDb.eliminar("C++");
                Toast.makeText(getApplicationContext(), "Delete ok C++", Toast.LENGTH_SHORT).show();
            }
        });

        btn_salir = (Button)findViewById(R.id.btn_salir);
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arrancar la siguiente activity para volver a la ventana principal
                Intent volverInicio = new Intent().setClass(
                        ManagerBdActivity.this, MainActivity.class);
                startActivity(volverInicio);
            }
        });

    }//Fin onCreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manager_bd, menu);
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
}
