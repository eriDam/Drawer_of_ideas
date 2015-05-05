package com.example.erika_000.almacen;

import android.provider.BaseColumns;


//Ejemplo aplicacion Android en el que utilizamos la API SQLite para realizar
//operaciones sobre una Base de Datos


public class EstructuraDatos {
	
	public EstructuraDatos(){}
	
	public static abstract class Estructura implements BaseColumns
	{
		public static final String TABLE_NAME = "Cursos";
        public static final String COLUMN_NAME_TITLE = "titulo";
        public static final String COLUMN_NAME_CANTIDAD = "cantidad";
        public static final String COLUMN_NAME_SECCION = "seccion";

	}

}
