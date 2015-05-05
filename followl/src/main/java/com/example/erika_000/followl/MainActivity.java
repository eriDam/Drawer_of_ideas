package com.example.erika_000.followl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private Button btn_abrir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/**Lo relacionamos con el layout*/
        //TabHost res = getTabHost();
        Resources res = getResources();
        /** Creo una variable de tipo TabHOst y hago referencia al control principal mediante su id tabhost*/
        TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();/**preparandolo para su configuración con su metodo setup */

        /**Añadimos las pestañas mediante el metodo newTabSpec*/
        TabHost.TabSpec spec = tabs.newTabSpec("Lessons");
        spec.setContent(R.id.tab1);/**Asignamos al layout del contenido correspondiente*/
        spec.setIndicator("Lessons",null);
        tabs.addTab(spec);
        /**Añadimos la  pestaña 2 mediante el metodo newTabSpec*/
        spec=tabs.newTabSpec("Manager");
        spec.setContent(R.id.tab2);/**Asignamos al layout del contenido correspondiente*/
        /**Damos un nombre y pintamos un icono o nombre o icono en versiones antiguas los dos*/
        spec.setIndicator("Manager", null);
        tabs.addTab(spec);

        /**Añadimos la  pestaña 3 mediante el metodo newTabSpec*/
        spec=tabs.newTabSpec("OnCode");
        spec.setContent(R.id.tab2);/**Asignamos al layout del contenido correspondiente*/
        /**Damos un nombre y pintamos un icono o nombre o icono en versiones antiguas los dos*/
        spec.setIndicator("OnCode", null);
        tabs.addTab(spec);
        tabs.setCurrentTab(0);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);/**Lo relacionamos con el menu llamado main2*/
        return true;
    }

    /**Cuando seleccionemos un item del menu, mostrará un mensaje, dependiendo del id que me devuelva line 28,
     * van a haber muchos case*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "Git", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreManager;
                abreManager = new Intent().setClass(
                        MainActivity.this, MainActivity2Activity.class);
                startActivity(abreManager);
                return true;
            case R.id.menu_home:
                Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_profiles:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_bd:
                Toast.makeText(getApplicationContext(), "MAGANER", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_lugares:
                Toast.makeText(getApplicationContext(), "LUGARES", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_eventos:
                Toast.makeText(getApplicationContext(), "EVENTOS", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}