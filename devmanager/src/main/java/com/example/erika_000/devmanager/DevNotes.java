package com.example.erika_000.devmanager;

import android.app.Activity;
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
