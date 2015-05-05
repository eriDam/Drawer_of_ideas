package com.cipolat.slidenavigation;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/*  Fragment para seccion perfil */ 
public class ProfileFragment extends Fragment {
    //Botones
    private Button btnGplus, btnFb, btnTwitter, btnGit;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.profile, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnGplus = (Button) getActivity().findViewById(R.id.btnGplus);
        btnTwitter = (Button) getActivity().findViewById(R.id.btnTwitter);
        btnFb = (Button) getActivity().findViewById(R.id.btnFb);
        btnGit = (Button) getActivity().findViewById(R.id.btnGit);


        //Botón btnGplus
        btnGplus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/"));
                startActivity(intento);

            }
        });

        //Botón btnTwitter
        btnTwitter.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
                startActivity(intento);

            }
        });

        //Botón btnFb
        btnFb.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                startActivity(intento);

            }
        });
        //Botón btnGit
        btnGit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eriDam"));
                startActivity(intento);

            }
        });

    }


}