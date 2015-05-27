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


public class WebLessonsJs extends ActionBarActivity {
    //Declaro los controles
    WebView wview_lesson_js;
    final String url = "http://www.w3schools.com/js/default.asp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_lessons_js);
        //Obtengo los controles
        wview_lesson_js = (WebView) findViewById(R.id.wview_lesson_js);
        WebSettings settings = wview_lesson_js.getSettings();
        settings.setJavaScriptEnabled(true);
        wview_lesson_js.setWebViewClient(new MyWebViewClient());
        wview_lesson_js.loadUrl(url);
    }


    //Creo clase privada MyWebClient para manejar la vista de web
    private class MyWebViewClient extends WebViewClient
    {
        //ctrol+o sobreescribir metod, cogemos este para sobreescribir solo.
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }//FIN CLASS MyWebViewClient



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_lessons, menu);
        return true;
    }

    /**Cuando seleccionemos un item del menu, mostrara un mensaje, dependiendo del id que me devuelva line 28,
     * van a haber muchos case*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_inicio:
                Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abre;
                abre = new Intent(WebLessonsJs.this, MainActivity.class);
                startActivity(abre);
                this.finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(WebLessonsJs.this, DevTest.class);
                startActivity(abreDev);
                this.finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreLessons;
                abreLessons = new Intent(WebLessonsJs.this, Lessons2Activity.class);
                startActivity(abreLessons);
                this.finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(WebLessonsJs.this, Prof3Activity.class);
                startActivity(abreProf);
                this.finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(WebLessonsJs.this, OnCode4Activity.class);
                startActivity(abreGit);
                this.finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTION", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(WebLessonsJs.this, Gestion5Activity.class);
                startActivity(abreGestion);
                this.finish();//finalizo activity para liberar memoria
                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "BLOG", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(WebLessonsJs.this, Blog6Activity.class);
                startActivity(abreBlog);
                this.finish();//finalizo activity para liberar memoria
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                //TODO crear opciones de personalizacion
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
