package com.example.erika_000.codeon;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class splash_screen extends ActionBarActivity {

    //Declaro variable para almacenar las preferencias de usuario
    private boolean estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //La primera vez que se inicie muestra el splash screen - La segunda vez ya no lo muestra
        setContentView(R.layout.activity_splash_screen);
       //Carga las preferencias
        cargarPreferencias();
        //Comprobamos el estado(recibe lo que hemos guardado) de las preferencias
        if (estado)
        {
            //Si han sido cargadas muestra la siguiente pantalla, el código está en postExecute


        }
        else
        {
            //Si no han sido cargadas, insertará todas las preguntas que tiene el procesoCarga
            ProcesoCarga procesoCarg = new ProcesoCarga();
            procesoCarg.execute();//Para ejecutar el AsyncTask usamos el execute
        }
    }

    /*Cargamos Preferencias para saber si han sido insertados datos
     * Sirven para guardar si han sido insertados datos si se han  insertado cargamos una cosa si no otra */
    private void cargarPreferencias()
    {
        SharedPreferences misPreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
       //estado será igual a false
        estado = misPreferencias.getBoolean("isLoad",false);
    }

    /*Guardar preferencias, */
    private void guardarPreferencias(boolean valor)
    {
        SharedPreferences misPreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putBoolean("isLoad",valor);
        editor.commit();

    }

    //
    // Clase Privada Proceso de carga AsyncTask, implementamos los metodos.
    //


/**Utilizamos el AsyncTask para cuando una tarea es demasiado pesada que se ejecute en 2 plano
 * */
    private class ProcesoCarga extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog dialog;
        //Creo un array con nuestra entidad EPreguntas, asList es para crear lista,
        ArrayList<EPreguntas> preguntas = new ArrayList<EPreguntas>(Arrays.<EPreguntas>asList(
                //Paso las pregunta las respuestas y por ultimo la respuesta correcta
                new EPreguntas("¿Cual es tu lenguaje preferido?","Android-Java","C++","Qt","Javascript","Android-Java"),
                new EPreguntas("¿Que tipos de Layouts conoces?","RelativeLayout,LinnearLayout,ScrollLayout,FrameLayout, ListLayout","0","1","2","RelativeLayout,LinnearLayout,ScrollLayout,FrameLayout, ListLayout"),
                new EPreguntas("¿Que sentencia SQL es para ordenar?","Having","Short","Order","Select","Order"),
                new EPreguntas("¿Que es un puntero?","Una variable","Una variable con espacio","Una variable que apunta a espacio en memoria","SQL","Una variable que apunta a espacio en memoria"),
                new EPreguntas("En SQL, ¿Cual de estas sentencias añade una fila a una tabla en una base de datos?","ADD","INSERT","UPDATE","INCLUDE","INSERT"),
                new EPreguntas("En SQL, para eliminar las filas duplicadas de una sentencia SELECT se emplea,","NO DUPLICATE","UNIQUE","DISTINC","GOUP BY","DISTINC"),
                new EPreguntas("En cual de estas sentencias se emplea la clasusula SET","DELETE","DROP","UPDATE","SELECT","UPDATE"),
                new EPreguntas("If, else, for y while son","Funciones de acceso a datos "," Sentencias de control","Tipos de datos ","Las anteriores respuestas no son correctas ","Las anteriores respuestas no son correctas "),
                new EPreguntas("¿Qué características son propias de la programación orientada a objetos?","La modularidad, el principio de ocultación y la reutilización","La abstracción, el anidamiento y la parametrización "," El encapsulamiento, la herencia y el polimorfismo","Las anteriores respuestas no son correctas "," El encapsulamiento, la herencia y el polimorfismo"),
                new EPreguntas("Int, char, float, string y boolean son","Funciones de acceso a datos ","Instrucciones de acceso a datos "," Sentencias de control","Tipos de datos","Tipos de datos"),
                new EPreguntas("¿Tu app favorita?","Ninguna","Esta","CodeOn","MusicApp","Esta")
        ));

        //Se va a ejecutar antes d que se inicie un hilo, el asyncTask es un hilo
       @Override
        protected void onPreExecute() {
       // super.onPreExecute();
        dialog = new ProgressDialog(splash_screen.this);
        dialog.setTitle("Este es el título");
        dialog.setMessage("Insertando en BD");
        dialog.show();//Para mostrar
       }

        //Se ejecuta cuando ha terminado el doInBackground

        @Override
        protected void onPostExecute(Void aVoid) {
          //Guardo preferencias por que ya ha sido cargado
            guardarPreferencias(true);
            if(dialog.isShowing())//Si se muestra...
            {
                Intent intent = new Intent(splash_screen.this, MainActivity.class);
                startActivity(intent);
                finish();
               dialog.dismiss();//Que se deje de mostrar
           }
        }

        //Para que empiece a correr en segundo plano
        @Override
        protected Void doInBackground(Void... params) {
            //Creo una instancia de DPreguntas por que neceito el método insertarPreguntas
            DPreguntas dPregHelper = new DPreguntas(splash_screen.this);
            EPreguntas preg = new EPreguntas();
            //Hago un for para recorrer el ARrayListPreguntas
            for (int i=0; i<preguntas.size();i++)
            {
                preg = preguntas.get(i);
                System.out.println("Pregunta insertada ok");
                //Utilizo el objeto de la clase DPreguntas para insertar
                dPregHelper.insertarPreguntas(preg);

                try {
                    //Le pongo medio segundo de sleep, para q el dialog tarde un poco más
                    Thread.sleep(500);
                    System.out.println("espero 1/2 segundo");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Ha ocurrido un error al cargar");
                }
            }
            return null;
        }
    }

}
