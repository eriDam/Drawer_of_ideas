package com.example.erika_000.devmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class NotesFecha extends ActionBarActivity {

    //Definimos dos variables que hacen referencia a los EditText donde se cargan la fecha en uno y las notas de dicho día en el otro:
    private EditText et_fecha,et_nota;

//    En el método onCreate obtenemos las referencias de los dos EditText, normalmente lo hago en un
//    método aparte para iniciar pero ahora solo són dos controles :
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_fecha);
        et_fecha=(EditText)findViewById(R.id.et_fecha);
        et_nota=(EditText)findViewById(R.id.et_nota);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes_fecha, menu);
        return true;
    }

    /**Cuando seleccionemos un item del menu, mostrará un mensaje, dependiendo del id que me devuelva line 28,
     * van a haber muchos case*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_inicio:
                Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abre;
                abre = new Intent(NotesFecha.this, MainActivity.class);
                startActivity(abre);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(NotesFecha.this, DevTest.class);
                startActivity(abreDev);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreLessons;
                abreLessons = new Intent(NotesFecha.this, Lessons2Activity.class);
                startActivity(abreLessons);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(NotesFecha.this, Prof3Activity.class);
                startActivity(abreProf);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(NotesFecha.this, OnCode4Activity.class);
                startActivity(abreGit);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(NotesFecha.this, Gestion5Activity.class);
                startActivity(abreGestion);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(NotesFecha.this, Blog6Activity.class);
                startActivity(abreBlog);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                //TODO crear opciones de personalización
//                //arrancar la siguiente activity
//                Intent abreBlog;
//                abreBlog= new Intent(MainActivity.this, Blog6Activity.class);
//                startActivity(abreBlog);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*El método grabar que se ejecuta cuando presionamos el botón grabar (no olvidar de inicializar la
    propiedad onClick de cada botón con el nombre del método respectivo) tenemos primero que extraer la
    fecha ingresada en el primer EditText y remplazar las barras de la fecha por guiones ya que no se
    puede utilizar este caracter dentro de un nombre de archivo en Android:*/
    public void grabar(View v) {
        String nomarchivo=et_fecha.getText().toString();
        nomarchivo=nomarchivo.replace('/','-');
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    nomarchivo, Activity.MODE_PRIVATE));
            archivo.write(et_nota.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "La nota se ha guardado, introduce la fecha para recuperarla",
                Toast.LENGTH_SHORT);
        t.show();
        et_fecha.setText("");
        et_nota.setText("");
    }

    public void recuperar(View v) {
        String nomarchivo=et_fecha.getText().toString();
        nomarchivo=nomarchivo.replace('/','-');
        boolean enco=false;
        String[] archivos = fileList();
        for (int f = 0; f < archivos.length; f++)
            if (nomarchivo.equals(archivos[f]))
                enco= true;
        if (enco==true) {
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput(nomarchivo));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et_nota.setText(todo);
            } catch (IOException e) {
            }
        } else
        {
            Toast.makeText(this, "No hay notas grabadas para esa fecha", Toast.LENGTH_LONG).show();
            et_nota.setText("");
        }
    }

}