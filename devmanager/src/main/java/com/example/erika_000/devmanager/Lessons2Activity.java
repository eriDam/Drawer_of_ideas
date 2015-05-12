package com.example.erika_000.devmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Lessons2Activity extends ActionBarActivity {
    //Declaro los controles
    CardView card_cpp;
    CardView card_qt;
    CardView card_android;
    CardView card_js;
    CardView card_php_1,card_php;
    CardView card_jquery;
    CardView card_json;
    CardView card_mysql;
    CardView card_sqlite;
    CardView card_html;
    CardView card_dw;
    CardView card_ps;
    CardView card_ilustr;
    CardView card_css2,card_css_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons2);
        //Obtengo los controles
        //Programación
        card_cpp = (CardView)findViewById(R.id.card_cpp);
        card_qt = (CardView)findViewById(R.id.card_qt);
        card_android = (CardView)findViewById(R.id.card_android);
        card_js = (CardView)findViewById(R.id.card_js);
        card_php_1 = (CardView)findViewById(R.id.card_php_1);
        card_php  = (CardView)findViewById(R.id.card_php);
        card_jquery = (CardView)findViewById(R.id.card_jquery);
        card_json = (CardView)findViewById(R.id.card_json);

        //Bd
        card_mysql = (CardView)findViewById(R.id.card_mysql);
        card_sqlite = (CardView)findViewById(R.id.card_sqlite);


        //Web
        card_html = (CardView)findViewById(R.id.card_html);
       // card_css = (CardView)findViewById(R.id.card_css);

        card_ps = (CardView)findViewById(R.id.card_ps);
        card_ilustr = (CardView)findViewById(R.id.card_ilustr);
        card_css2 = (CardView)findViewById(R.id.card_css2);
        card_css_web = (CardView)findViewById(R.id.card_css_web);
        card_dw =  (CardView)findViewById(R.id.card_dw);

        //Eventos  cards
        card_cpp.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreLessons = new Intent(Lessons2Activity.this,WebLessonsCpp.class);
                startActivity(abreLessons);
                finish();//finalizo activity para liberar memoria

            }
        });

        card_qt.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreLessonsQt = new Intent(Lessons2Activity.this,WebLessonsQt.class);
                startActivity(abreLessonsQt);
                finish();//finalizo activity para liberar memoria

            }
        });

        card_android.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreLessonsAnd = new Intent(Lessons2Activity.this,WebLessonsAndroid.class);
                startActivity(abreLessonsAnd);
                finish();//finalizo activity para liberar memoria

            }
        });

        card_js.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreLessonsJs = new Intent(Lessons2Activity.this,WebLessonsJs.class);
                startActivity(abreLessonsJs);
                finish();//finalizo activity para liberar memoria

            }
        });

        card_php_1.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://php.net/"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
         card_jquery.setOnClickListener(new CardView.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.desarrolloweb.com/articulos/curso-jquery.html"));
                 startActivity(intento);
                 finish();//finalizo activity para liberar memoria

             }
        });
         card_json.setOnClickListener(new CardView.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.w3schools.com/json/"));
                 startActivity(intento);
                 finish();//finalizo activity para liberar memoria

             }
        });
        card_mysql.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://programacion.net/articulo/tutorial_basico_de_mysql_189"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
        card_sqlite.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tutorialspoint.com/sqlite/"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
        card_html.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.w3schools.com/html/html5_intro.asp"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
        card_css2.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.desarrolloweb.com/manuales/css3.html"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
        card_css_web.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.desarrolloweb.com/manuales/css3.html"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });


        card_dw.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.desarrolloweb.com/articulos/332.php"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
        card_php.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://php.net/"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
        card_ps.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cursosenhd.com/featured/curso-completo-photoshop-cs6-complete-course-chapter-1/"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });
        card_ilustr.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aulaclic.es/illustratorcs3/"));
                startActivity(intento);
                finish();//finalizo activity para liberar memoria

            }
        });




    }//Fin onCreate



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lessons2, menu);
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
                abre = new Intent(Lessons2Activity.this, MainActivity.class);
                startActivity(abre);
                finish();//finalizo activity para liberar memoria
                return true;

            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(Lessons2Activity.this, DevTest.class);
                startActivity(abreDev);
                finish();
                return true;

            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(Lessons2Activity.this, Prof3Activity.class);
                startActivity(abreProf);
                finish();
                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(Lessons2Activity.this, OnCode4Activity.class);
                startActivity(abreGit);
                finish();
                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(Lessons2Activity.this, Gestion5Lessons.class);
                startActivity(abreGestion);
                finish();
                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "BLOG", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(Lessons2Activity.this, Blog6Activity.class);
                startActivity(abreBlog);
                finish();
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                //TODO crear opciones de personalización
//                //arrancar la siguiente activity
//                Intent abreBlog;
//                abreBlog= new Intent(Lessons2Activity.this, Blog6Activity.class);
//                startActivity(abreBlog);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
