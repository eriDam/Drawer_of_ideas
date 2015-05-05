package com.cipolat.slidenavigation;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


public class Activity_ListView extends ActionBarActivity implements View.OnClickListener {
    //Creo el objeto cursor
    private Cursor cursor;
    //Declaro el ListView
    private ListView lista;
    //Declaro un SimpleCursorAdapter
    private SimpleCursorAdapter adapter;
    // Declaro la Bd
    private DataBaseManager managerDb;
    //Declaro el editText y el imageButton
    private EditText etBuscar;
    private ImageButton iBtnBuscar;
    private ImageButton iBtnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__list_view);
        //Inicio el objeto de la BD
        managerDb = new DataBaseManager(this);
        //Inicializo y Obtengo la lista
        lista = (ListView) findViewById(R.id.listView);
        //Inicializo y Obtengo el editText y el imageButton
        etBuscar = (EditText) findViewById(R.id.eTBuscar);
        iBtnBuscar =(ImageButton) findViewById(R.id.iBtnBuscar);
        iBtnBuscar.setOnClickListener(this);
        iBtnEdit = (ImageButton) findViewById(R.id.iBtnEdit);


        //El 1º de los 2 campos nombre de la columna,  le indicamos al adaptador que campos queremos.
        String[] from = new String[]{managerDb.CN_TITLE, managerDb.CN_LINK};
        //El 2º to, indica el id del layout donde queremos mostrar estos valores, vamos a mostrar todos
        //los registros título en el text1
        int[] to = new int[] {android.R.id.text1, android.R.id.text2};

        cursor = managerDb.cargarCursorCursos();
        //Utilizamos un layout de android predefinido de dos filas, pongo el 0, una especie de flag(bandera)
        // por que el constructor por defecto está obsolteo aunque se puede utilizar
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor, from,to,0);
        //Utilizamos el adaptador
        lista.setAdapter(adapter);

        iBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerDb.modificarLink("C++1","http://www.c.conclase.net");
                //managerDb.modificarLink(etBuscar.getText().toString());
                Toast.makeText(getApplicationContext(), "Link de C++1 modificado", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__list_view, menu);
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
    //Si ponemos mas botones solo se ejecutará nuestro botón
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iBtnBuscar){
            //Llamamos a la clase BuscarTask
            new BuscarTask().execute();
        }

    }


    //Creo la Clase interna AsyncTask, es una plantilla le ponemos los 3 para Void y generamos los
    //métodos que nos pide
    private class BuscarTask extends AsyncTask<Void,Void,Void >{

        //Este se ejecuta en segundo plano
        @Override
        protected Void doInBackground(Void... params) {
            //Obtendrá el título del textView y buscará el titulo q coincida, como
            //Esto devuelve un cursor se lo asignamos
            cursor = managerDb.buscarCurso(etBuscar.getText().toString());
            return null;
        }

        //Despues de terminar la operación en segundo plano
        // este metodo se ejecuta en el hilo principal
        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Buscando curso...",Toast.LENGTH_SHORT).show();
        }

        //
        @Override
        protected void onPostExecute(Void aVoid) {
            adapter.changeCursor(cursor);
            Toast.makeText(getApplicationContext(), "Finalizada búsqueda...",Toast.LENGTH_SHORT).show();
        }
    }
}
