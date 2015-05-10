package com.example.erika_000.visornoticias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by erika_000 on 10/05/2015.
 */
public class NoticiaActivity extends Activity {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												CAMPOS 																   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Campos gráficos
    private TextView txtTitulo;					// Campo gráfico que muestra el título de la noticia
    private TextView txtDescripcion;			// Campo gráfico que muestra la descripción de la noticia
    private TextView txtFecha;					// Campo gráfico que muestra la fecha de la noticia
    private TextView txtLink;					// Campo gráfico que muestra el link de la noticia


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												FIN CAMPOS 															   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												MÉTODOS 															   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Al iniciar la aplicación ...
     * En el método onCreate() de la segunda actividad inicializamos los campos y llamamos al método mostrar noticia
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        // INICIALIZACIÓN DE CAMPOS /////////////////////////////////////////////////////////////////////////////////////////

        // Incialización de campos gráficos
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtLink = (TextView) findViewById(R.id.txtLink);

        // FIN INICIALIZACIÓN DE CAMPOS /////////////////////////////////////////////////////////////////////////////////////

        // Muestra la noticia
        mostrarNoticia();
    }

    /**
     * Obtiene y muestra la noticia
     * Creamos el método que nos permitirá mostrar la noticia que recibimos a través de intent de la primera actividad.
     */
    public void mostrarNoticia(){

        // CAMPOS ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Intent intent;
        Noticia noticia;		// Almacena la noticia

        // FIN CAMPOS ////////////////////////////////////////////////////////////////////////////////////////////////////////



        // EJECUCIÓN /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Obtiene la noticia
        intent = getIntent();
        noticia = (Noticia) intent.getSerializableExtra("NOTICIA");

        // Muestra la noticia
        txtTitulo.setText("Título: "+noticia.getTitulo().toString());
        txtDescripcion.setText("Descripción: "+ noticia.getDescripcion().toString());
        txtFecha.setText("Fecha de la noticia: "+ noticia.getFecha().toString());
        txtLink.setText("Link: " + noticia.getLink().toString());

        // FIN EJECUCIÓN /////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												FIN MÉTODOS 														   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
