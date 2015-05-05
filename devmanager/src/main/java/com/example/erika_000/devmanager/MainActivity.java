package com.example.erika_000.devmanager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    //Botones
    private CardView card_cpp_h, card_qt_h, card_android_h, card_test;
    private Button
            btn_profile, btn_profile2, btn_profile3,
            btn_oncode_git, btn_oncode2,btn_bd, btn_mas_test, btn_blog,
            btn_mas_lessons,btn_mas_prof,btn_mas_oncode,btn_mas_gest,btn_mas_blog;

    private static final String TAG = "Fragment HOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Definimos la orientacion a vertical - Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        card_cpp_h      = (CardView) findViewById(R.id.card_cpp_h);
        card_qt_h       = (CardView) findViewById(R.id.card_qt_h);
        card_android_h  = (CardView) findViewById(R.id.card_android_h);
        card_test  = (CardView) findViewById(R.id.card_test);

        btn_profile     = (Button) findViewById(R.id.btn_profile);
        btn_profile2    = (Button) findViewById(R.id.btn_profile2);
        btn_profile3    = (Button) findViewById(R.id.btn_profile3);
        btn_oncode_git  = (Button) findViewById(R.id.btn_oncode_git);
        btn_bd          = (Button) findViewById(R.id.btn_bd);
        btn_mas_lessons = (Button) findViewById(R.id.btn_mas_lessons);
        btn_mas_prof    = (Button) findViewById(R.id.btn_mas_prof);
        btn_mas_gest    = (Button) findViewById(R.id.label_nombre);
        btn_mas_blog    = (Button) findViewById(R.id.btn_mas_blog);
        btn_mas_oncode  = (Button) findViewById(R.id.btn_mas_oncode);
        btn_mas_test         =  (Button) findViewById(R.id.btn_mas_test);


    /*Eventos Lessons btn mas*/
        btn_mas_lessons.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, Lessons2Activity.class);
                startActivity(intent);
            }
        });

  /*Card Lessons card_cpp_h*/
        card_cpp_h.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreLessons = new Intent(MainActivity.this,WebLessonsCpp.class);
                startActivity(abreLessons);

//                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://es.cppreference.com/w/"));
//                startActivity(intento);

            }
        });
         /*Card Lessons Qt*/
        card_qt_h.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreLessonsQt = new Intent(MainActivity.this,WebLessonsQt.class);
                startActivity(abreLessonsQt);
            }
        });

       /*Card Lessons card_android_h*/
        card_android_h.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abreLessonsAndroid = new Intent(MainActivity.this,WebLessonsAndroid.class);
                startActivity(abreLessonsAndroid);
//                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"));
//                startActivity(intento);

            }
        });
        //Abrir la activity Test
        card_test.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoTest = new Intent(MainActivity.this,DevTest.class);
                startActivity(intentoTest);


            }
        });

        /*Eventos Perfiles*/
        btn_mas_prof.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, Prof3Activity.class);
                startActivity(intent);
//                MainActivity.this.finish();//finalizo activity para liberar memoria
            }
        });

        btn_profile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abreGoogle = new Intent(MainActivity.this,WebProfGoogle.class);
                startActivity(abreGoogle);


            }
        });

        //Perfil Twiter abre en navegador
        btn_profile2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com"));
                startActivity(intento);


            }
        });
        //Perfil Facebook abre en navegado, necesario usar la API para login, si no se viola el protocolo y no muestra
        btn_profile3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                startActivity(intento);

//                Intent abreF = new Intent(MainActivity.this,WebProfFace.class);
//                startActivity(abreF);

            }
        });
     /*Eventos onCode*/
        btn_mas_oncode.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, OnCode4Activity.class);
                startActivity(intent);

            }
        });
        btn_oncode_git.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Abre activity webView
                Intent abreGit = new Intent(MainActivity.this,WebGit.class);
                startActivity(abreGit);


//                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eriDam"));
//                startActivity(intento);
            }
        });

        btn_bd.setOnClickListener(new Button.OnClickListener() {
            //            @Override
            public void onClick(View view) {
//                //arrancar la siguiente activity
//                Intent intent = new Intent(MainActivity.this,Gestion5Activity.class);
//                startActivity(intent);
                 Intent intent = new Intent(MainActivity.this,Gestion5Lessons.class);
                 startActivity(intent);

            }
        });
        btn_mas_test.setOnClickListener(new Button.OnClickListener() {
            //            @Override
            public void onClick(View view) {
                //arrancar la siguiente activity Test
                Intent intent = new Intent(MainActivity.this,DevTest.class);
                startActivity(intent);

            }
        });

        btn_mas_gest.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, Gestion5Activity.class);
                startActivity(intent);

            }
        });


        btn_mas_blog.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, Blog6Activity.class);
                startActivity(intent);

            }
        });

        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**Cuando seleccionemos un item del menu, mostrará un mensaje, dependiendo del id que me devuelva line 28,
     * van a haber muchos case*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_inicio:
                Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abre;
                abre = new Intent(MainActivity.this, MainActivity.class);
                startActivity(abre);


                return true;
            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(MainActivity.this, DevTest.class);
                startActivity(abreDev);

                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreLessons;
                abreLessons = new Intent(MainActivity.this, Lessons2Activity.class);
                startActivity(abreLessons);

                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(MainActivity.this, Prof3Activity.class);
                startActivity(abreProf);

                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                  //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(MainActivity.this, OnCode4Activity.class);
                startActivity(abreGit);

                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(MainActivity.this, Gestion5Activity.class);
                startActivity(abreGestion);

                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(MainActivity.this, Blog6Activity.class);
                startActivity(abreBlog);

                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                //TODO crear opciones de personalización
//                //arrancar la siguiente activity
//                Intent abreBlog;
//                abreBlog= new Intent(MainActivity.this, Blog6Activity.class);
//                startActivity(abreBlog);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
