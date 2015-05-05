package com.example.erika_000.prefusrs;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebProfGoogle extends ActionBarActivity {
    //Declaro los controles
    WebView wview_google;
    final String urlG = "https://plus.google.com/u/0/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_prof_google);
        //Obtengo los controles
        wview_google = (WebView) findViewById(R.id.wview_google);
        //Utilizo metodo para abrir y no llenar el onCreate
        abreWebG(wview_google);


    }

    //Metodo para abrir webView
    public void abreWebG(View v)
    {
        WebSettings settings = wview_google.getSettings();
        settings.setJavaScriptEnabled(true);
        wview_google.setWebViewClient(new MyWebViewClient());
        wview_google.loadUrl(urlG);
    }


    //Creo clase privada MyWebClient para manejar la vista de web
    private class MyWebViewClient extends WebViewClient
    {
        //ctrol+o sobreescribir metodos, cogemos este para sobreescribir solo.
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
        getMenuInflater().inflate(R.menu.menu_web_prof_google, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
