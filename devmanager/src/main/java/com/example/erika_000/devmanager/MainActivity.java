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
    private CardView card_cpp_h, card_qt_h, card_android_h, card_test,
            card_music, card_notes, card_db, card_blog, card_rss, card_feedly;
    private Button
            btn_profile_go, btn_profile_tw, btn_profile_fc, btn_profile_git,
            btn_oncode_git, btn_oncode2, btn_bd, btn_mas_test, btn_blog_roll,
            btn_mas_lessons, btn_mas_prof, btn_mas_oncode, btn_mas_blog, btn_miblog,
            btn_youtube, btn_stack;

    private static final String TAG = "Fragment HOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Definimos la orientacion a vertical - Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        //Llamo al metodo iniciar controles
        iniciarControles();

        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
    }


    //Metodo para recuperar los controles mediante su id, para descargar el onCreate
    private void iniciarControles() {
        //Obtnego los controls mediante su id
        card_cpp_h = (CardView) findViewById(R.id.card_cpp_h);
        card_qt_h = (CardView) findViewById(R.id.card_qt_h);
        card_android_h = (CardView) findViewById(R.id.card_android_h);
        card_test = (CardView) findViewById(R.id.card_test);
        card_music = (CardView) findViewById(R.id.card_music);
        card_notes = (CardView) findViewById(R.id.card_notes);
        card_db = (CardView) findViewById(R.id.card_db);
        card_rss = (CardView) findViewById(R.id.card_rss);
        card_blog = (CardView) findViewById(R.id.card_blog);
        card_feedly = (CardView) findViewById(R.id.card_feedly);


        btn_profile_go = (Button) findViewById(R.id.btn_profile_go);
        btn_profile_tw = (Button) findViewById(R.id.btn_profile_tw);
        btn_profile_fc = (Button) findViewById(R.id.btn_profile_fc);
        btn_profile_git = (Button) findViewById(R.id.btn_profile_git);
        btn_oncode_git = (Button) findViewById(R.id.btn_oncode_git);
        btn_oncode2 = (Button) findViewById(R.id.btn_oncode2);
        btn_mas_lessons = (Button) findViewById(R.id.btn_mas_lessons);
        btn_mas_prof = (Button) findViewById(R.id.btn_mas_prof);
        btn_mas_blog = (Button) findViewById(R.id.btn_mas_blog);
        btn_mas_oncode = (Button) findViewById(R.id.btn_mas_oncode);
        btn_mas_test = (Button) findViewById(R.id.btn_mas_test);
        btn_youtube = (Button) findViewById(R.id.btn_youtube);
        btn_stack = (Button) findViewById(R.id.btn_stack);


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
                Intent abreLessons = new Intent(MainActivity.this, WebLessonsCpp.class);
                startActivity(abreLessons);

//                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://es.cppreference.com/w/"));
//                startActivity(intento);

            }
        });
         /*Card Lessons Qt*/
        card_qt_h.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreLessonsQt = new Intent(MainActivity.this, WebLessonsQt.class);
                startActivity(abreLessonsQt);
            }
        });

       /*Card Lessons card_android_h*/
        card_android_h.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abreLessonsAndroid = new Intent(MainActivity.this, WebLessonsAndroid.class);
                startActivity(abreLessonsAndroid);
//                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"));
//                startActivity(intento);

            }
        });
        //Abrir la activity Test
        card_test.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoTest = new Intent(MainActivity.this, DevTest.class);
                startActivity(intentoTest);


            }
        });
        card_notes.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoDevNotes = new Intent(MainActivity.this, NotesFecha.class);
                startActivity(intentoDevNotes);


            }
        });
        card_music.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, Music_activity.class);
                startActivity(intent);


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

        btn_profile_go.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent abreGoogle = new Intent(MainActivity.this,WebProfGoogle.class);
//                startActivity(abreGoogle);
                Intent intentoG = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/"));
                startActivity(intentoG);


            }
        });

        //Perfil Twiter abre en navegador
        btn_profile_tw.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com"));
                startActivity(intento);


            }
        });
        //Perfil Facebook abre en navegado, necesario usar la API para login, si no se viola el protocolo y no muestra
        btn_profile_fc.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                startActivity(intento);

//                Intent abreF = new Intent(MainActivity.this,WebProfFace.class);
//                startActivity(abreF);

            }
        });
        btn_profile_git.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eriDam"));
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
                Intent abreGit = new Intent(MainActivity.this, WebGit.class);
                startActivity(abreGit);


//                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eriDam"));
//                startActivity(intento);
            }
        });
        btn_oncode2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoT = new Intent(Intent.ACTION_VIEW, Uri.parse("https:/www.trello.com"));
                startActivity(intentoT);
            }
        });

//        btn_bd.setOnClickListener(new Button.OnClickListener() {
//            //            @Override
//            public void onClick(View view) {
////                //arrancar la siguiente activity
////                Intent intent = new Intent(MainActivity.this,Gestion5Activity.class);
////                startActivity(intent);
//                Intent intent = new Intent(MainActivity.this,Gestion5Lessons.class);
//                startActivity(intent);
//
//            }
//        });
        btn_mas_test.setOnClickListener(new Button.OnClickListener() {
            //            @Override
            public void onClick(View view) {
                //arrancar la siguiente activity Test
                Intent intent = new Intent(MainActivity.this, DevTest.class);
                startActivity(intent);

            }
        });

        //CardView Blog ecabDam
        card_blog.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, Blog6Activity.class);
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
        //Boton btn_blog_roll es el de rss
        card_rss.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abreRss = new Intent(MainActivity.this, NoticiasActivity.class);
                startActivity(abreRss);

            }
        });
        card_db.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View view) {

                //arrancar la siguiente activity
                Intent intent = new Intent(MainActivity.this, AdminLessons.class);
                startActivity(intent);

            }
        });
        card_feedly.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoFeedly = new Intent(Intent.ACTION_VIEW, Uri.parse("https://feedly.com"));
                startActivity(intentoFeedly);

            }
        });
        btn_youtube.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                //abro navegador
                Intent intentoY = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCnx8IvRaWinWN9I6VrBdFDQ"));
                startActivity(intentoY);

            }
        });

        btn_stack.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stackoverflow.com/"));
                startActivity(intento);
            }
        });
        Log.i(TAG, getClass().getSimpleName() + ":entered Controles iniciados");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Cuando seleccionemos un item del menu, mostrará un mensaje, dependiendo del id que me devuelva line 28,
     * van a haber muchos case
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

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
                abreGestion = new Intent(MainActivity.this, AdminLessons.class);
                startActivity(abreGestion);

                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "BLOG", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(MainActivity.this, Blog6Activity.class);
                startActivity(abreBlog);

                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                //TODO crear opciones de personalización
//                //arrancar la siguiente activity
                Intent abreGestionOld;
                abreGestionOld = new Intent(MainActivity.this, Gestion5Lessons.class);
                startActivity(abreGestionOld);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
