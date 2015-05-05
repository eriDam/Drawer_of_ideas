package com.example.erika_000.prefusrs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
   //Declaro los controles del layout
    private EditText txt_nombre;
    private Button btn_guardar, btn_google;
    private CheckBox chk_estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //Enlazo/obtengo los ontroles mediante su id
        txt_nombre  = (EditText)findViewById(R.id.txt_nombre);
        btn_guardar = (Button)findViewById(R.id.btn_guardar);
        chk_estado  = (CheckBox)findViewById(R.id.chk_estado);
        btn_google  = (Button)findViewById(R.id.btn_google);
        //Cuando carguemos la aplicación llamaremos a cargarPreferencias
        cargarPreferencias();

        //Agregamos listener al Boton
        // Hacemos que se guarden las preferencias del usuario al pulsar el botón
        btn_guardar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPreferencias();

            }
        });
        btn_google.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent abreGoogle = new Intent(MainActivity.this,WebProfGoogle.class);
                startActivity(abreGoogle);

            }
        });
    }



    //Creo unos métodos para CARGAR y otro para GUARDAR PREFERENCIAS

    //Método cargarPreferencias
      public void cargarPreferencias()
    {
        //NEcesitamos 2 param: El 1er parametro que le pasamos es el nombre del archivo xml que se crea con SharedPreferences
        //El 2º para que solo sea accedido por esta aplicacion, hay otros
        SharedPreferences misPreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);

        //Como estamos cargando hay que mostrarlo en algún sitio, usamos misPreferencias con getBoolean, el 1er para
        //que necesito es el nombre con que guardar la preferencia en el archivo xml y el 2 el valor por default que deberia tener este control
         chk_estado.setChecked(misPreferencias.getBoolean("checked",false));

        //Lo hacemos también con el de arriba, pero aqui es texto(String) no un boolean, damos un nombre y por default vacío
        txt_nombre.setText(misPreferencias.getString("nombre",""));



    }

    //Método para guardar las preferencias
    public void guardarPreferencias()
    {
        //Necesitamos 2 param: El 1er parametro que le pasamos es el nombre del archivo xml que se crea con SharedPreferences
        //El 2º para que solo sea accedido por esta aplicacion, hay otros
        SharedPreferences misPreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);

        //Creamos una variable de tipo Editor, para empezar a editar en nuestro archivo xml esas prefrencias
        SharedPreferences.Editor editor = misPreferencias.edit();

        //Declaro un boolean valor, le digo que obtenga del chechkbox si esta check o no
        boolean valor = chk_estado.isChecked();
        //Declaro un String para que obtenga el valor de la caja del nombre
        String valorNombre = txt_nombre.getText().toString();
        //Utilizo el objeto que acabo de crear con el primer param que es un boolean, le paso valor con el estado del checkBox
        editor.putBoolean("checked",valor);
        //Colocamos el string
        editor.putString("nombre",valorNombre);
        //Hacemos un commit para que se guarden los cambios
        editor.commit();


        //Como estamos cargando hay que mostrarlo en algún sitio, usamos misPreferencias con getBoolean, el 1er para
        //que necesito es el nombre con que guardar la preferencia en el archivo xml y el 2 el valor por default que deberia tener este control
        chk_estado.setChecked(misPreferencias.getBoolean("checked",false));
        //Lo hacemos también con el de arriba, pero aqui es texto(String) no un boolean, damos un nombre y por default vacío
        txt_nombre.setText(misPreferencias.getString("nombre", ""));


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

    public void onClick(View view) {
        Intent abreCursos = new Intent(MainActivity.this,Cursos.class);
        startActivity(abreCursos);
    }
}
