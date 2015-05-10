package com.example.erika_000.devmanager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Declaramos los campos que vayamos a utilizar de la actividad principal.
 *
 * Muestra un listado de noticas
 * Se puede seleccionar cualquier noticia para obtener más detalles
 * */
public class NoticiasActivity extends Activity {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												CAMPOS 																   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Campos gráficos
    private ListView lstvNoticias;				// Campo gráfico que muestra un listado de noticias

    // Otros campos
    private URL url;							// Almacena la url desde donde se descarga el fichero xml
    private ArrayList<Noticia> noticias;		// Almacena las noticias
    private String[] tituloNoticias;			// Almacena los titulos de las noticias
    private ArrayAdapter adaptador;				// Adaptador



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												FIN CAMPOS 															   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												MÉTODOS 															   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Al iniciar la aplicación ...
     * inicializamos todos los campos en el método onCreate() de la actividad principal además de declarar y programar los eventos necesarios
     */
    @SuppressLint({ "NewApi", "NewApi", "NewApi" })
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        // INICIALIZACIÓN DE CAMPOS /////////////////////////////////////////////////////////////////////////////////////////

        // Inicialización campos gráficos
        lstvNoticias = (ListView) findViewById(R.id.lstvNoticias);


        // Inicialización de otros campos
        try {

            url = new URL("http://www.xatakandroid.com/index.xml");

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        noticias = new ArrayList<Noticia>();

        // FIN INICIALIZACIÓN DE CAMPOS /////////////////////////////////////////////////////////////////////////////////////

        // Permisos para acceder a internet
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // Lee los datos del fichero xml
        leerDatos();

        // Almacena los titulos de las noticias
        obtenerTitulos();

        // Adaptador para la lista
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tituloNoticias);

        // Se estaablece el adaptador a la lista
        lstvNoticias.setAdapter(adaptador);




        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //												EVENTOS 															   //
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        lstvNoticias.setOnItemClickListener(new OnItemClickListener() {

            /**
             * Muestra detalladamente la noticia seleccionada
             */
            public void onItemClick(AdapterView<?> adaptador, View vista, int posicion,
                                    long arg3) {

                // Obtiene la noticia
                Intent intent = new Intent(NoticiasActivity.this, NoticiaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("NOTICIA", noticias.get(posicion));
                intent.putExtras(bundle);

                // Envía la noticia e inicia la actividad NoticiaActivity para mostrar detalladamente la noticia
                startActivity(intent);
            }
        });

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //												FIN EVENTOS 														   //
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    /**
     * Obtiene y lee los datos del fichero xml
     * Creamos el método el cual obtendrá las noticias del fichero rss,
     * la url desde el cual obtenemos el fichero rss es http://www.nerja.es/rss.php
     */
    public void leerDatos(){

        // CAMPOS ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        XmlPullParserFactory factory;
        XmlPullParser xml;					// Almacena el recurso xml
        int evento;							// Almacena el evento producido por el xml

        // Arrays
        ArrayList<String> titulos;			// Almacena los titulos de las noticias
        ArrayList<String> descripciones;	// Almacena las descripciones de las noticias
        ArrayList<String> fechas;			// Almacena las fechas de las noticias
        ArrayList<String> links;			// Almacena los links de las noticias

        // Banderas
        boolean esItem;						// Indica si es una noticia
        boolean leerTitutlo;				// Indica si se puede leer el titulo
        boolean leerDescripcion;			// Indica si se puede leer la descripción
        boolean leerFecha;					// Indica si se puede leer la fecha
        boolean leerLink;					// Indica si se puede leer el link

        // FIN CAMPOS ///////////////////////////////////////////////////////////////////////////////////////////////////////



        // EJECUCIÓN ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Incialización de arrays
        titulos = new ArrayList<String>();
        descripciones = new ArrayList<String>();
        fechas = new ArrayList<String>();
        links = new ArrayList<String>();

        // Inicialización de banderas
        esItem = false;
        leerTitutlo = false;
        leerDescripcion = false;
        leerFecha = false;
        leerLink = false;


        try {

            // Obtiene el fichero xml
            factory = XmlPullParserFactory.newInstance();
            xml = factory.newPullParser();
            xml.setInput(url.openStream(),"UTF-8");

            // Obtiene el evento producido por el xml
            evento = xml.getEventType();

            // Recorre el fichero xml
            while (evento != XmlPullParser.END_DOCUMENT){

                switch (evento) {

                    case XmlPullParser.START_TAG:

                        // Controla si es el inicio de una noticia
                        if (xml.getName().equals("item")){

                            esItem = true;
                        }

                        // Controla si es una noticia
                        if (esItem){
                            // Si es una noticia ...

                            // Comprobar inicio etiquetas///////////////////////////////

                            if (xml.getName().equals("title")){

                                leerTitutlo = true;
                            }

                            if (xml.getName().equals("link")){

                                leerLink = true;
                            }

                            if (xml.getName().equals("pubDate")){

                                leerFecha = true;
                            }

                            if (xml.getName().equals("description")){

                                leerDescripcion = true;
                            }

                            // FIN Comprobar inicio etiquetas //////////////////////////////

                        }

                        break;

                    case XmlPullParser.TEXT:

                        // Almacenar el contenido de las etiquetas /////////////////////////

                        if (leerTitutlo){

                            titulos.add(xml.getText());
                        }

                        if (leerLink){

                            links.add(xml.getText());
                        }

                        if (leerFecha){

                            fechas.add(xml.getText());
                        }

                        if (leerDescripcion){

                            descripciones.add(xml.getText());
                        }

                        // FIN Almacenar el contenido de las etiquetas ///////////////////////


                        break;


                    case XmlPullParser.END_TAG:

                        // Comprobar el fin de la etiquetas ////////////////////////////////////

                        if (xml.getName().equals("title")){

                            leerTitutlo = false;
                        }

                        if (xml.getName().equals("link")){

                            leerLink = false;
                        }

                        if (xml.getName().equals("pubDate")){

                            leerFecha = false;
                        }

                        if (xml.getName().equals("description")){

                            leerDescripcion = false;
                        }

                        // Comprueba si es el final de la noticia
                        if (xml.getName().equals("item")){

                            // Reinicia la bandera
                            esItem = false;
                        }

                        // FIN Comprobar el fin de la etiquetas //////////////////////////////////


                        break;

                }

                // Avanza una posición en el fichero xml
                evento = xml.next();
            }


        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Almacena todas las noticias obtenidas
        almacenarNoticias(titulos, descripciones, fechas, links);

        // FIN EJECUCIÓN ////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    /**
     * Almacena las noticias
     *  Creamos el método que nos permite guardar las noticias en la aplicación
     *
     * @param titulos Titulos de las noticias
     * @param descripciones	 Descripciones de las noticias
     * @param fechas Fechas de las noticias
     * @param links Links de las noticias
     */
    public void almacenarNoticias(ArrayList<String> titulos, ArrayList<String> descripciones, ArrayList<String> fechas, ArrayList<String> links){

        // Recorre el array de titulos
        for (int i = 0; i < titulos.size(); i++){

            // Almacena la noticia completa
            noticias.add(new Noticia(titulos.get(i), descripciones.get(i), fechas.get(i), links.get(i)));
        }
    }

    /**
     * Obtiene y almacena los titulos de las noticias
     * Tendremos que obtener los títulos de todas las noticias para mostrarlas en la actividad para ello programamos el siguiente método.
     */
    public void obtenerTitulos(){

        // Inicializa el array
        tituloNoticias = new String[noticias.size()];

        // Recorre todas las noticias
        for (int i = 0; i < noticias.size(); i++){

            // Almacena el titulos de las noticia
            tituloNoticias[i] = noticias.get(i).getTitulo();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												FIN MÉTODOS 														   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_noticiass);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_noticiass, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
