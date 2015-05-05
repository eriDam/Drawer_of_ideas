package com.example.erika_000.devmanager;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class OnCode4Activity extends ActionBarActivity {
    Button btn_buscar, btn_stackOv,btn_git;
    EditText et_intro_busc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_code4);
        btn_buscar    = (Button)findViewById(R.id.btn_buscar);
        btn_stackOv   = (Button)findViewById(R.id.btn_stackOv);
        et_intro_busc = (EditText)findViewById(R.id.et_intro_busc);
        btn_git        = (Button)findViewById(R.id.btnTwitter);
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
                abre = new Intent(OnCode4Activity.this, MainActivity.class);
                startActivity(abre);
                return true;
            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(OnCode4Activity.this, DevTest.class);
                startActivity(abreDev);
                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreLessons;
                abreLessons = new Intent(OnCode4Activity.this, Lessons2Activity.class);
                startActivity(abreLessons);
                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(OnCode4Activity.this, Prof3Activity.class);
                startActivity(abreProf);
                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(OnCode4Activity.this, OnCode4Activity.class);
                startActivity(abreGit);
                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(OnCode4Activity.this, Gestion5Activity.class);
                startActivity(abreGestion);
                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(OnCode4Activity.this, Blog6Activity.class);
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
