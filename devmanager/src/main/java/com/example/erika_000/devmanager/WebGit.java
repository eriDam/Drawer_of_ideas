package com.example.erika_000.devmanager;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class WebGit extends ActionBarActivity {
    //Declaro los controles
    WebView wview_git;
    final String urlG = "https://github.com/eriDam";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_git);
        //Obtengo los controles
        wview_git = (WebView) findViewById(R.id.wview_git);

        WebSettings settings = wview_git.getSettings();
        settings.setJavaScriptEnabled(true);
        wview_git.setWebViewClient(new MyWebViewClientG());
        wview_git.loadUrl(urlG);
    }

    //Creo clase privada MyWebClient para manejar la vista de web
    private class MyWebViewClientG extends WebViewClient
    {
        //ctrol+o sobreescribir metod, cogemos este para sobreescribir solo.
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(urlG);
            return true;
        }
    }//FIN CLASS MyWebViewClient



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**Cuando seleccionemos un item del menu, mostrar un mensaje, dependiendo del id que me devuelva line 28,
     * van a haber muchos case*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_inicio:
                Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abre;
                abre = new Intent(WebGit.this, MainActivity.class);
                startActivity(abre);
                return true;
            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(WebGit.this, DevTest.class);
                startActivity(abreDev);
                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreLessons;
                abreLessons = new Intent(WebGit.this, Lessons2Activity.class);
                startActivity(abreLessons);
                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(WebGit.this, Prof3Activity.class);
                startActivity(abreProf);
                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(WebGit.this, OnCode4Activity.class);
                startActivity(abreGit);
                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTION", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(WebGit.this, Gestion5Activity.class);
                startActivity(abreGestion);
                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "BLOG", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(WebGit.this, Blog6Activity.class);
                startActivity(abreBlog);
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                //TODO crear opciones personalizar
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
