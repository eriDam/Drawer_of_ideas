package com.cipolat.slidenavigation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BdFragment extends Fragment {

    private static final String TAG = "Fragment Sup";
    public BdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_bd_fragment, container, false);
        /** Para interactuar con  botones (views), se puede colocar tanto en onCreateView como
         *  en onActivityCreated*/

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /**
         * Recuperamos el boton y el textView de nuestros resources con .findViewById(R.id.btnSup,
         * como el fragment no controla donde esta cada uno de los elemntos, tenemos qe acceder
         * al activity que está cargando el fragment con getActivity().
         *
         *  */
        final Button btn = (Button) getActivity().findViewById(R.id.btn_crear);
        final TextView tv_text_changer = (TextView) getActivity().findViewById(R.id.tv_text_changer);

        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                tv_text_changer.setText("Apretado");
            }
        });
    }






}