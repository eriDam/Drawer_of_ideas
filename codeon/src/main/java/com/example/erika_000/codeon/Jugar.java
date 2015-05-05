package com.example.erika_000.codeon;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//Implemento de OnCLickListener
public class Jugar extends ActionBarActivity implements View.OnClickListener{

    Button btn_1, btn_2, btn_3, btn_4;
    TextView tv_pregunta;
    //Hacemos la instancia una variable de clase / global
    EPreguntas p = null;
    DPreguntas objPreguntas = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        //Obtengo los controles
        btn_1       = (Button)findViewById(R.id.btn_1);
        btn_2       = (Button)findViewById(R.id.btn_2);
        btn_3       = (Button)findViewById(R.id.btn_3);
        btn_4       = (Button)findViewById(R.id.btn_4);
        //Asignamos el método onClick  a los botones y le pasamos this por q el metodo esta en la class
        //Así ya podemos escuchar los eventos
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);

        tv_pregunta = (TextView)findViewById(R.id.tv_preg);


        //LLamamos generarPreguntas
        generarPreguntas();

    }

    //Método para generar las Preguntas random
    private void generarPreguntas()
    {
        //Declaramos una instancia/ objeto de preguntas
        objPreguntas = new DPreguntas(this);//le pasamos como contesto la clase con this

        //Creo un ArrayList de EPreguntas, para que obtenga el contenido de todas las  preguntas que esten en la condicion de 0 no acertadas
        ArrayList<EPreguntas> preg= objPreguntas.getPregunta("0");
        //Verifico que preg no esté vacío para generar las preguntas aleatoriamente
        if (!preg.isEmpty())
        {
            //Si no esta vacío, generamos un random y le pasamos en lugar de un numero nosotros el size del ArrayList preg, si hay 100 genera de 0 a 100
            int aleatorio = generarAleatorio(preg.size());
            //Declaro una Entidad de EPreguntas, va a ser igual al arrayList.get
            p = preg.get(aleatorio);//obtenemos como indice el num aleat


            //Ponemos texto en los botones  ctrl+d para repetir
            btn_1.setText(p.getA1());
            btn_2.setText(p.getA2());
            btn_3.setText(p.getA3());
            btn_4.setText(p.getA4());
            //Establezco el texto de la pregunta
            tv_pregunta.setText(p.getPregunta());

        }
    }

    //Método para generar un numero random
    private int generarAleatorio(int cantidad)
    {
        return (int)(Math.random()*cantidad);
    }

//Método onClick implementado
    @Override
    public void onClick(View v) {
    Button btn = (Button) v;
    //Comparamos la cadena que contiene el boton
        if(p.getAc().equals(btn.getText()))
        {
            Toast.makeText(getApplicationContext(),"Has acertado :)",Toast.LENGTH_SHORT).show();
            //Llamamos a la var objPreguntas la actualizamos y le pasamos la var p
            p.setEstado(1);
            objPreguntas.actualizarPreguntas(p);
            //generamos un aleatorio y asi ya no mostrará la pregunta si se ha acertado
            generarPreguntas();

        }else
        {
            Toast.makeText(getApplicationContext(),"Has fallado :(",Toast.LENGTH_SHORT).show();
        }


    }
}
