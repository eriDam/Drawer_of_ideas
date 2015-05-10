package com.example.erika_000.devmanager;

import java.io.Serializable;

/**
 * Created by erika_000 on 10/05/2015.
 * Clase modelo noticia la cual no servirá para poder guardas las noticias obtenidas del fichero rss.
 */
@SuppressWarnings("serial")
public class Noticia implements Serializable {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												CAMPOS 																   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String titulo;				// Almacena el titulo de la noticia
    private String descripcion;			// Almacena la descripción de la noticia
    private String fecha;				// Almacena la fecha de la noticia
    private String link;				// Almacena el link de la noticia

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												FIN CAMPOS 															   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												CONSTRUCTOR															   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Inicializa una nueva instancia de la clase
     *
     * @param titulo Titutlo de la noticia
     * @param descripcion Descripción de la noticia
     * @param fecha Fecha de la noticia
     * @param link Link de la noticia
     */
    public Noticia(String titulo, String descripcion, String fecha, String link) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.link = link;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												FIN CONSTRUCTOR														   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												PROPIEDADES															   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @return Obtiene el titulo de la noticia
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return Obtiene la descripción de la noticia
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @return Obtiene la fecha de la noticia
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @return Obtiene el link de la noticia
     */
    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "tituLo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												FIN PROPIEDADES														   //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
