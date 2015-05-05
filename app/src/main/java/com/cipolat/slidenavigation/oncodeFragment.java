package com.cipolat.slidenavigation;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class oncodeFragment extends Fragment {
    Button btn_buscar, btn_stackOv,btn_git;
    EditText et_intro_busc;
    private static final String TAG = "Fragment HOME";

    public oncodeFragment() {
        // Required empty public constructor
    }

    /** En un fragmento, usamos onCreateView a diferencia del mainActivity en el que se usa onCreate,  */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.oncode_fragment, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_buscar    = (Button)getActivity().findViewById(R.id.btn_buscar);
        btn_stackOv   = (Button)getActivity().findViewById(R.id.btn_stackOv);
        et_intro_busc = (EditText)getActivity().findViewById(R.id.et_intro_busc);
        btn_git        = (Button)getActivity().findViewById(R.id.btnTwitter);
        //Campo de texto
        et_intro_busc.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //borramos el texto del editTex cuando sea pulsado para escribir
                et_intro_busc.setText("");
            }
        });

        //Botón buscar
        btn_buscar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Este intent para buscar a través de google
                Requiere los permisos:<uses-permission android:name="android.permission.INTERNET"/>
                */
                Intent intentoBuscar = new Intent(Intent.ACTION_WEB_SEARCH);
                intentoBuscar.putExtra(SearchManager.QUERY, "("+ et_intro_busc.getText() +")+");


                startActivity(intentoBuscar);
                //Para intentar lanzar un nuevo activity, se utiliza la clase Intent
//                Intent mapa = new Intent(
//                        android.content.Intent.ACTION_VIEW,
//                        //la direccion la cogerá mediante getText() del campo de texto
//                        Uri.parse("geo:0,0?q= (" + et_intro_busc.getText() + ")")
//                );

            }
        });

        //Botón Mis lugares
        btn_stackOv.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para intentar lanzar un nuevo activity desde un fragment, se utiliza la clase Intent y getActivity
//                Intent abreMisLugares = new Intent(getActivity(), MisLugares.class);
//                startActivity(abreMisLugares);

                /*
                Intent abreMisLugares = new Intent(getActivity(), MisLugares.class);
                                //En el intent se intenta enviar la información de la primera ventana
                //A través del método putExtra podemos poner información básica no muy extensa
                abreMisLugares.putExtra("Lugar", et_intro_lugar.getText().toString());

                //Esta es otra forma de lanzar el intent de abrir la segunda ventana, vamos a esperar que nos devuelva un resultado
                //El segundo parametro, nos indica si es mayor o igual que 0, el resultado pasará por el metodo onActivityResult
                startActivityForResult(abreMisLugares,1);*/

                //Abriré el navegador con un intent y la uri de misLugares en goole maps
//                String url = "https://www.google.com/maps/d/edit?hl=es&authuser=0&mid=zsNKk6nb3KAI.kSO8Z5yh2JZw";
//                Intent abreMisLugares = new Intent(Intent.ACTION_VIEW);
//                abreMisLugares.setData(Uri.parse(url));
//                startActivity(abreMisLugares);

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stackoverflow.com/"));

                startActivity(intento);

            }

        });

        //Botón btnGit
        btn_git.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eriDam"));
                startActivity(intento);

            }
        });
        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
    }


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
/*
    //Creamos método para recoger los datos de la segunda actividad
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        //creamos variable de TextView (la misma que metemos en el boton buscar)
        final EditText lugar=(EditText)getActivity().findViewById(R.id.et_intro_lugar);
        //Hacemos la lógica para que aparezca el string que mandamos de la segunda actividad
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String resultado=data.getStringExtra("Lugar");//
                lugar.setText(resultado);
            }
            if (resultCode == RESULT_CANCELED) {
            }
        }
    }*/
}