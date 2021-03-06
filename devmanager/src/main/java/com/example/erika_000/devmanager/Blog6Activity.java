package com.example.erika_000.devmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Blog6Activity extends ActionBarActivity {

    //Controles
    private Button btn_rss_xak, btn_blog_qt, btn_blog_eridam, btn_blog_android, btn_feedly, btn_blog_androide_libre,
            btn_blog_geeky, btn_blog_minidosis, btn_blog_codalonso, btn_blog_sgoliver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog6);
    //Inicializar controles de la vista
        btn_rss_xak             = (Button)findViewById(R.id.btn_rss_xak);
        btn_feedly              = (Button)findViewById(R.id.btn_feedly);
        btn_blog_android        = (Button)findViewById(R.id.btn_blog_android);
        btn_blog_qt             = (Button)findViewById(R.id.btn_blog_qt);
        btn_blog_androide_libre = (Button)findViewById(R.id.btn_blog_androide_libre);
        btn_blog_eridam         = (Button)findViewById(R.id.btn_blog_eridam);
        btn_blog_geeky          = (Button)findViewById(R.id.btn_blog_geeky);
        btn_blog_minidosis      = (Button)findViewById(R.id.btn_blog_minidosis);
        btn_blog_codalonso      = (Button)findViewById(R.id.btn_blog_codalonso);
        btn_blog_sgoliver       = (Button)findViewById(R.id.btn_blog_sgoliver);



        //Eventos botones
        btn_rss_xak.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abreRss = new Intent(Blog6Activity.this,NoticiasActivity.class);
                startActivity(abreRss);
            }
        });
        btn_feedly.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoFeedly = new Intent(Intent.ACTION_VIEW, Uri.parse("https://feedly.com"));
                startActivity(intentoFeedly);
            }
        });

        btn_blog_android.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoBlogD = new Intent(Intent.ACTION_VIEW, Uri.parse("http://android-developers.blogspot.com.es/"));
                startActivity(intentoBlogD);
            }
        });


        btn_blog_qt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoQt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.qt.io/"));
                startActivity(intentoQt);
            }
        });
        btn_blog_androide_libre.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoBlog = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.elandroidelibre.com/"));
                startActivity(intentoBlog);
            }

        });

        btn_blog_eridam.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoBlog = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ecabdam.blogspot.com.es/"));
                startActivity(intentoBlog);
            }

        });
        btn_blog_geeky.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoBlog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://geekytheory.com/"));
                startActivity(intentoBlog);
            }

        });
        btn_blog_minidosis.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoBlog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://geekytheory.com/"));
                startActivity(intentoBlog);
            }

        });

        btn_blog_codalonso.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoBlog = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.codigoalonso.com/2013/10/Introduccion-SQLite-Android.html"));
                startActivity(intentoBlog);
            }

        });
        btn_blog_sgoliver.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentoBlog = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sgoliver.net/blog/"));
                startActivity(intentoBlog);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blog6, menu);
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
                abre = new Intent(Blog6Activity.this, MainActivity.class);
                startActivity(abre);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(Blog6Activity.this, DevTest.class);
                startActivity(abreDev);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreLessons;
                abreLessons = new Intent(Blog6Activity.this, Lessons2Activity.class);
                startActivity(abreLessons);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(Blog6Activity.this, Prof3Activity.class);
                startActivity(abreProf);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(Blog6Activity.this, OnCode4Activity.class);
                startActivity(abreGit);
                finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(Blog6Activity.this, Gestion5Lessons.class);
                startActivity(abreGestion);
                finish();//finalizo activity para liberar memoria
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
