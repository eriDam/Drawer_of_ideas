package com.example.erika_000.oncode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by erika_000 on 22/04/2015.
 */
public class Fragment_Manager extends Fragment {
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fm_manager, container, false);

        TextView texto = (TextView) rootView.findViewById(R.id.tv_manager);

        texto.setText("Tab seleccionada" + "\n\n" + "Gestión");

        return rootView;
    }

}
