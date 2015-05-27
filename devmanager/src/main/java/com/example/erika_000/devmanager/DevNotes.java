package com.example.erika_000.devmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


    public class DevNotes extends Activity {
        private Button btnEscribirFichero = null;
        private Button btnLeerFichero = null;
        private Button btnLeerRaw = null;
        private EditText et_nota;
        @Override
    /*El metodo onCreate tiene por objetivo verificar si existe el archivo de texto,
    proceder a su lectura y mostrar su contenido en el EditText.
    */
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dev_notes);

            et_nota=(EditText)findViewById(R.id.et_nota);

            //Primero obtenemos la lista de todos los archivos creados por
            //la Activity. En nuestra app puede ser cero o uno:
            String[] archivos = fileList();
            //Llamamos a un método que verifica si en el vector de tipo String existe el archivo "notas.txt":
            if (existe(archivos, "notas.txt"))

                try {
                    //En el caso que me retorne true procedemos a crear un objeto de la clase InputStreamReader y
                    //al constructor de dicha clase le pasamos el dato devuelto por el metodo openFileInput:
                    InputStreamReader archivo = new InputStreamReader(
                            openFileInput("notas.txt"));
                    //Creamos un objeto de la clase BufferedReader y le pasamos al constructor
                    //la referencia del objeto de la clase InputStreamReader:
                    BufferedReader br = new BufferedReader(archivo);
                    //Leemos la primer linea del archivo de texto:
                    String linea = br.readLine();
                    // Inicializamos un String vacio:
                    String todo = "";
                    //  Mientras el metodo readLine de la clase BufferedReader devuelva un String:
                    while (linea != null) {
                        // Lo concatenamos al String junto a un salto de linea:
                        todo = todo + linea + "\n";
                        // Leemos la proxima línea:
                        linea = br.readLine();
                    }
                    // Llamamos al metodo close de la clase BufferedReader y al del InputStreamReader:
                    br.close();
                    archivo.close();
                    // Cargamos el EditText con el contenido del String que contiene todos los datos del archivo de texto:
                    et_nota.setText(todo);
                } catch (IOException e) {
                }
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_dev_notes, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            {
                switch (item.getItemId()) {
                    case R.id.menu_inicio:
                        Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
                        //arrancar la siguiente activity
                        Intent abre;
                        abre = new Intent(DevNotes.this, MainActivity.class);
                        startActivity(abre);
                        finish();//finalizo activity para liberar memoria
                        return true;
                    case R.id.menu_devtest:
                        Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                        //arrancar la siguiente activity
                        Intent abreDev;
                        abreDev = new Intent(DevNotes.this, DevTest.class);
                        startActivity(abreDev);

                        finish();//finalizo activity para liberar memoria
                        return true;
                    case R.id.menu_lessons:
                        Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                        //arrancar la siguiente activity
                        Intent abreLessons;
                        abreLessons = new Intent(DevNotes.this, Lessons2Activity.class);
                        startActivity(abreLessons);

                        finish();//finalizo activity para liberar memoria
                        return true;
                    case R.id.menu_profile:
                        Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                        //arrancar la siguiente activity
                        Intent abreProf;
                        abreProf = new Intent(DevNotes.this, Prof3Activity.class);
                        startActivity(abreProf);

                        finish();//finalizo activity para liberar memoria
                        return true;
                    case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                        Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                        //arrancar la siguiente activity
                        Intent abreGit;
                        abreGit = new Intent(DevNotes.this, OnCode4Activity.class);
                        startActivity(abreGit);

                        finish();//finalizo activity para liberar memoria
                        return true;

                    case R.id.menu_blog:
                        Toast.makeText(getApplicationContext(), "BLOG", Toast.LENGTH_SHORT).show();
                        //arrancar la siguiente activity
                        Intent abreBlog;
                        abreBlog = new Intent(DevNotes.this, Blog6Activity.class);
                        startActivity(abreBlog);

                        finish();//finalizo activity para liberar memoria
                        return true;
                    case R.id.action_settings:
                        Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                        //TODO crear opciones de personalización
//                //arrancar la siguiente activity
                        Intent abreGestionOld;
                        abreGestionOld = new Intent(DevNotes.this, Gestion5Lessons.class);
                        startActivity(abreGestionOld);
                        return true;
                    default:
                        return super.onOptionsItemSelected(item);
                }
            }
        }
        /*El método existe llega un vector de tipo String y otro String a buscar.
        Dentro de un for verificamos el String a buscar con cada uno de los String del vector,
        si lo encontramos retornamos true. Si recorre todo el for sin encontrarlo fuera del for retornamos false:*/
        private boolean existe(String[] archivos, String archbusca) {
            for (int f = 0; f < archivos.length; f++)
                if (archbusca.equals(archivos[f]))
                    return true;
            return false;
        }
        /*en el método grabar que se ejecuta cuando presionamos el botón "grabar"
         (recordar inicializar la propiedad "onClick" del botón con el valor "grabar"):
        */
        public void grabar(View v) {

        /*T esto está cerrado en un try/catch para verificar si sucede algún error en la apertura del archivo.*/
            try {
        /*Creamos un objeto de la clase OutputStreamWriter y al constructor de dicha
        clase le enviamos el dato que retorna el método openFileOutput propio de la clase
        ActionBarActivity que le pasamos como parámetro el nombre del archivo de texto y el modo de apertura.
        */
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                        "notas.txt", Activity.MODE_PRIVATE));
                //Seguidamente si el archivo se creó correctamente procedemos a llamar al método write y le pasamos
                //el String a grabar, en este caso extraemos los datos del EditText:
                archivo.write(et_nota.getText().toString());
            /*con el método write llamamos al método flush para que vuelque todos los
            datos que pueden haber quedado en el buffer y procedemos al cerrado del archivo:*/
                archivo.flush();
                archivo.close();
            } catch (IOException e) {
            }
            //mostramos un mensaje temporal en pantalla utilizando la clase Toast:
            Toast t = Toast.makeText(this, "La nota ha sido guardada",
                    Toast.LENGTH_SHORT);
            t.show();
            finish();
        }
    }
