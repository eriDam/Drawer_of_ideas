package com.example.erika_000.oncode;

/**
 * He definido en el layout-activityMain dos frameLayout (frgaments que voy a añadir
 * dinamicamente desde esta clase Inf y desde Sup).
 * Inflate() es 1 Método que se utiliza para construir y añadir las Views a los diseños de:
 * 	Fragment
 Menu o ActionBar
 Adapter
 Dialogs
 Para añadir una View a otra en cuando precisemos
 * */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Inf extends Fragment {
    /**Se crea un TAG para uitilizar en el Log*/
    private static final String TAG = "Fragment Inf";

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
    }

    /** En un fragmento, usamos onCreateView a diferencia del mainActivity en el que se usa onCreate,  */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /** Utilizamos el inflater pasandole un fragment inf como parámetro  */
        return inflater.inflate(R.layout.fragment_inferior, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
        super.onResume();
    }


    @Override
    public void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
        super.onStop();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
        super.onDetach();
    }


    @Override
    public void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
        super.onDestroyView();
    }
    /** Método/función que cambia el contenido del editText segun hayamos seleccionado un item*/
    protected void setItemSeleccionado(String item) {

        final TextView text = (TextView)getActivity().findViewById(R.id.editTextSo);
        text.setText(item);
        final Button btn_abre =(Button)getActivity().findViewById(R.id.Abre);
        btn_abre.setText("Abrir "+item);
  //      btn_abre.setOnClickListener(new TextView.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               Intent abreFicha =  new Intent (getActivity(), Ficha.class);
//
//            }
//        });
    }

}