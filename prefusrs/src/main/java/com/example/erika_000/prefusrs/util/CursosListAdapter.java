package com.example.erika_000.prefusrs.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erika_000.prefusrs.R;

import java.util.List;

/**
 * Created by erika_000 on 05/05/2015.
 * Sobreescribo el método getview de ArrayAdapter
 */
public class CursosListAdapter extends ArrayAdapter{
    //Declaro una variable instancia de la clase Activity, ctx hace alusión al contexto
    //cada Activity en si es un contexto
    private Activity ctx;

   //Le pongo Activity en lugar de Context como marca Android, opara asegurarme de
   // que reciba siempre una Actividad
    public CursosListAdapter(Activity context, List<Curso> cursos) {
        super(context, R.layout.listview_item,cursos);
        //Pasamos al constructor de la clase padre el contexto
        this.ctx = context;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
         if (view == null)
         {
             view = ctx.getLayoutInflater().inflate(R.layout.listview_item, parent, false);
         }
        Curso actual= (Curso) this.getItem(position);
        inializarCamposDeTexto(view, actual);

        return view;

    }

    private void inializarCamposDeTexto(View view, Curso actual) {
        TextView textViewA = (TextView) view.findViewById(R.id.view_area);
        //inicializo su valor
        textViewA.setText(actual.getArea());

        TextView textViewN = (TextView) view.findViewById(R.id.view_nombre);
        //inicializo su valor
        textViewN.setText(actual.getNombre());

        TextView textViewL = (TextView) view.findViewById(R.id.view_link);
        //inicializo su valor
        textViewL.setText(actual.getLink());

        TextView textViewP = (TextView) view.findViewById(R.id.view_profe);
        //inicializo su valor
        textViewL.setText(actual.getProfe());
        //Aunque el metodo se llame inicializarCamposDeTexto, inicializo aqui la immg
        ImageView ivCursoImage = (ImageView)view.findViewById(R.id.ivCursoImage);
    }
}
