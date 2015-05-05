package com.cipolat.slidenavigation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
* Created by erika_000 on 16/04/2015.
*/
public class EventFragment extends Fragment {
    private static final String TAG = "Fragment EVENTS";
    private Button btn_cargar;
    private WebView webView;


    public EventFragment(){}

    /** En un fragmento, usamos onCreateView a diferencia del mainActivity en el que se usa onCreate,  */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.cards, container, false);

        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
        return rootView;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        btn_lessons = (Button)getActivity().findViewById(R.id.btn_lessons);
//
//        btn_lessons.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv_wellcome.setText("Apretado Lessons");
//                //Llamar al fragment Lessons
//
//                //objMain.
//            }
//        });


        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
    }


    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
        super.onAttach(activity);
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

    @Override
    public void onDestroyView() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
        super.onDestroyView();
    }

}
////
////
////    /** En un fragmento, usamos onCreateView a diferencia del mainActivity en el que se usa onCreate,  */
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////
////        View rootView = inflater.inflate(R.layout.events, container, false);
////
////        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
////        return rootView;
////
////        //btn_cargar = (Button)getActivity().findViewById(R.id.btn_cargar);
////
//////        btn_cargar.setOnClickListener(new Button.OnClickListener() {
//////            @Override
//////            public void onClick(View view) {
//////
////////                //Llamar la uri
////////                Uri uri = Uri.parse("http://www.example.com");
////////                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////////                startActivity(intent);
////////                webView = new WebView();//findViewById(R.id.webView);
////////                setContentView(webView);
//////
//////    }
//////}
////    }
////
////        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
////    }
////        @Override
////        public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                Bundle savedInstanceState) {
////
////            Log.d("SwA", "WVF onCreateView");
////            View v = inflater.inflate(R.layout.web_layout, container, false);
////            if (currentURL != null) {
////                Log.d("SwA", "Current URL  1["+currentURL+"]");
////
////                WebView wv = (WebView) v.findViewById(R.id.webPage);
////                wv.getSettings().setJavaScriptEnabled(true);
////                wv.setWebViewClient(new SwAWebClient());
////                wv.loadUrl(currentURL);
////
////            }
////            return v;
////        }
////
////    public void updateUrl(String url) {
////        Log.d("SwA", "Update URL ["+url+"] - View ["+getView()+"]");
////        currentURL = url;
////
////        WebView wv = (WebView) getView().findViewById(R.id.webPage);
////        wv.getSettings().setJavaScriptEnabled(true);
////        wv.loadUrl(url);
////
////    }
////
////    private class SwAWebClient extends WebViewClient {
////
////        @Override
////        public boolean shouldOverrideUrlLoading(WebView view, String url) {
////            return false;
////        }
////
////    }
////
////}
////- See more at: http://www.survivingwithandroid.com/2013/03/android-fragment-tutorial-webview-example.html#sthash.EIp1SfbI.dpuf
////
////    @Override
////    public void onActivityCreated(Bundle savedInstanceState) {
////        super.onActivityCreated(savedInstanceState);
////
////
////
////    }
////});
////
////    @Override
////    public void onAttach(Activity activity) {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
////        super.onAttach(activity);
////    }
////
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
////        super.onCreate(savedInstanceState);
////    }
////
////
////
////
////    @Override
////    public void onStart() {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
////        super.onStart();
////    }
////
////    @Override
////    public void onResume() {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
////        super.onResume();
////    }
////
////
////    @Override
////    public void onPause() {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
////        super.onPause();
////    }
////
////    @Override
////    public void onStop() {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
////        super.onStop();
////    }
////
////    @Override
////    public void onDetach() {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
////        super.onDetach();
////    }
////
////
////    @Override
////    public void onDestroy() {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
////        super.onDestroy();
////    }
////
////    @Override
////    public void onDestroyView() {
////        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
////        super.onDestroyView();
////    }
////
////}
////
