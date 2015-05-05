package com.cipolat.slidenavigation;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/*  Fragment para seccion perfil implements View.OnClickListener*/
public class HomeFragment extends Fragment {
    //Botones
    private CardView card_cpp_h, card_qt_h, card_android_h;
    private Button btn_lesson, btn_lesson2, btn_lesson3,
            btn_profile, btn_profile2, btn_profile3,
            btn_oncode_git, btn_oncode2, btn_oncode3,
            btn_bd, btn_bd2, btn_blog;

    private static final String TAG = "Fragment HOME";

    public HomeFragment() {
    }

    /**
     * En un fragmento, usamos onCreateView a diferencia del mainActivity en el que se usa onCreate,
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_light, container, false);
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        card_cpp_h = (CardView) getActivity().findViewById(R.id.card_cpp_h);
        card_qt_h = (CardView) getActivity().findViewById(R.id.card_qt_h);
        card_android_h = (CardView) getActivity().findViewById(R.id.card_android_h);
        btn_profile = (Button) getActivity().findViewById(R.id.btn_profile);
        btn_profile2 = (Button) getActivity().findViewById(R.id.btn_profile2);
        btn_profile3 = (Button) getActivity().findViewById(R.id.btn_profile3);
        btn_oncode_git = (Button) getActivity().findViewById(R.id.btn_oncode_git);

        btn_bd       = (Button)getActivity().findViewById(R.id.btn_bd);
//        btn_bd2      = (Button)getActivity().findViewById(R.id.btn_bd2);
//        btn_blog     = (Button)getActivity().findViewById(R.id.btn_blog);
        // btn_cal = (Button)getActivity().findViewById(R.id.btn_cal);

       /*Eventos Lessons*/
        card_cpp_h.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://es.cppreference.com/w/"));
                startActivity(intento);

            }
        });
         /*Eventos Lessons*/
        card_qt_h.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://doc.qt.io/"));
                startActivity(intento);

            }
        });
        card_android_h.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"));
                startActivity(intento);

            }
        });



        /*Eventos Perfiles*/
        btn_profile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Fragment abrFr = new FavoritosFragment();
                //Llamar al fragment Profiles
                //Fragment favoritosFragment = new FavoritosFragment();

                //arrancar la siguiente activity
                // Intent mainIntent = new Intent().setClass(HomeFragment.this, FavoritosFragment.class);
                //startActivity(mainIntent);
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/"));
                startActivity(intento);

            }
        });
        btn_profile2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
                startActivity(intento);

            }
        });
        btn_profile3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                startActivity(intento);

            }
        });

        btn_oncode_git.setOnClickListener(new Button.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eriDam"));
                 startActivity(intento);
            }
         });

        btn_bd.setOnClickListener(new Button.OnClickListener() {
//            @Override
            public void onClick(View view) {
                //arrancar la siguiente activity
                Intent intent = new Intent(getActivity(), ActivityBd.class);
                startActivity(intent);
//                android.app.FragmentTransaction ft;
//                Fragment frag;
//                frag = new BdFragment();
//                ft = getSupportFragmentManager().beginTransaction().replace(R.id.home, frag);
//                ft.addToBackStack(frag.getClass().getName());
//                ft.commit();

          }
        });
        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
    }


    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
        super.onAttach(activity);
    }
public FragmentManager getSupportFragmentManager() {
    FragmentManager supportFragmentManager  =null;
    return supportFragmentManager;
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

//    Implemento método onClkick obligatorio al implementar la interfaz OnCLickListener
//    @Override
//    public void onClick(View v) {
//
//    }
}