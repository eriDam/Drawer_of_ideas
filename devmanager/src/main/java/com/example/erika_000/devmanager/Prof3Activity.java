package com.example.erika_000.devmanager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Prof3Activity extends ActionBarActivity {
    //Botones
    private Button btnGplus, btnFb, btn_twiter, btnGit, btn_youtube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof3);

        btnGplus    = (Button) findViewById(R.id.btnGplus);
        btn_twiter  = (Button) findViewById(R.id.btn_twiter);
        btnFb       = (Button) findViewById(R.id.btnFb);
        btnGit      = (Button) findViewById(R.id.btnGit2);
        btn_youtube = (Button) findViewById(R.id.btn_youtube);
        //Botón btnGplus
        btnGplus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreGoogle = new Intent(Prof3Activity.this, WebProfGoogle.class);
                startActivity(abreGoogle);

            }
        });

        //Botón btnTwitter
        btn_twiter.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com"));
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
                //abro navegador
//                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eriDam"));
//                startActivity(intento);

                //Abre activity webView
                Intent abreGoogle = new Intent(Prof3Activity.this,WebGit.class);
                startActivity(abreGoogle);
            }
        });
        //Botón btn_youtube, abre mi canal de youtube
        btn_youtube.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abro navegador
                Intent intentoY = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCnx8IvRaWinWN9I6VrBdFDQ"));
                startActivity(intentoY);
            }
        });

    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_prof3, menu);
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
                    abre = new Intent(Prof3Activity.this, MainActivity.class);
                    startActivity(abre);
                    finish();//finalizo activity para liberar memoria
                    return true;
                case R.id.menu_devtest:
                    Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                    //arrancar la siguiente activity
                    Intent abreDev;
                    abreDev = new Intent(Prof3Activity.this, DevTest.class);
                    startActivity(abreDev);
                    finish();//finalizo activity para liberar memoria
                    return true;
                case R.id.menu_lessons:
                    Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                    //arrancar la siguiente activity
                    Intent abreLessons;
                    abreLessons = new Intent(Prof3Activity.this, Lessons2Activity.class);
                    startActivity(abreLessons);
                    finish();//finalizo activity para liberar memoria
                    return true;

                case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                    Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                    //arrancar la siguiente activity
                    Intent abreGit;
                    abreGit = new Intent(Prof3Activity.this, OnCode4Activity.class);
                    startActivity(abreGit);
                    finish();//finalizo activity para liberar memoria
                    return true;
                case R.id.menu_gestion:
                    Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                    //arrancar la siguiente activity
                    Intent abreGestion;
                    abreGestion = new Intent(Prof3Activity.this, Gestion5Lessons.class);
                    startActivity(abreGestion);
                    finish();//finalizo activity para liberar memoria
                    return true;
                case R.id.menu_blog:
                    Toast.makeText(getApplicationContext(), "BLOG", Toast.LENGTH_SHORT).show();
                    //arrancar la siguiente activity
                    Intent abreBlog;
                    abreBlog = new Intent(Prof3Activity.this, Blog6Activity.class);
                    startActivity(abreBlog);
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
