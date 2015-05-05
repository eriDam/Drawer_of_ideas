package com.example.erika_000.prefusrs.util;

import android.net.Uri;

/**
 * Created by erika_000 on 05/05/2015.
 *
 * Esta clase va a tener unos atributos de tipo String
 */
public class Curso {
    //Atributos
    private String area, nombre, link, profe;
    private Uri imageUri;//como este objeto es un parametro importante se lo paso tambien al constructor

    //Generamos constructor que inicializa los 4 param
    public Curso(String area, String nombre, String link, String profe, Uri imageUri) {
        this.area = area;
        this.nombre = nombre;
        this.link = link;
        this.profe = profe;
        this.imageUri = imageUri;
    }
//Como no los vamos a volver a tocar, pedimos al sistema que los colapse

    //<editor-fold desc="GETTER - SETTERS METHODS">
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfe() {
        return profe;
    }

    public void setProfe(String profe) {
        this.profe = profe;
    }

    public Uri getImageUri() { return imageUri;}

    public void setImageUri(Uri imageUri) {this.imageUri = imageUri; }

    //</editor-fold>
}//END CLASS
