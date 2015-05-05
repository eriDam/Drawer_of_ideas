package com.cipolat.slidenavigation;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {
    ImageButton ibtn_git, ibtn_cpp, ibtn_qt, ibtn_html,ibtn_css,ibtn_js,ibtn_jquery,ibtn_ajax,ibtn_json,ibtn_php,ibtn_drupal,ibtn_dw;
    TextView tv_wellcome;
    private static final String TAG = "Fragment FAVORITOS";

    public FavoritosFragment() {
    // Required empty public constructor
}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
        return inflater.inflate(R.layout.favoritos, container, false);
    }


//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        ibtn_git = (ImageButton)getActivity().findViewById(R.id.ibtn_git);
//        ibtn_cpp = (ImageButton)getActivity().findViewById(R.id.ibtn_cpp);
//        ibtn_qt = (ImageButton)getActivity().findViewById(R.id.ibtn_qt);
//        ibtn_html = (ImageButton)getActivity().findViewById(R.id.ibtn_html);
//        ibtn_css = (ImageButton)getActivity().findViewById(R.id.ibtn_css);
//        ibtn_js = (ImageButton)getActivity().findViewById(R.id.ibtn_js);
//        ibtn_jquery = (ImageButton)getActivity().findViewById(R.id.ibtn_jquery);
//        ibtn_ajax  = (ImageButton)getActivity().findViewById(R.id.ibtn_ajax);
//        ibtn_json = (ImageButton)getActivity().findViewById(R.id.ibtn_json);
//        ibtn_php = (ImageButton)getActivity().findViewById(R.id.ibtn_php);
//        ibtn_drupal = (ImageButton)getActivity().findViewById(R.id.ibtn_drupal);
//        ibtn_dw = (ImageButton)getActivity().findViewById(R.id.ibtn_dw);
//
//        ibtn_git.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//        ibtn_cpp.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "http://c.conclase.net/curso/?cap=040";
//                Intent abreCpp = new Intent(Intent.ACTION_VIEW);
//                abreCpp.setData(Uri.parse(url));
//                startActivity(abreCpp);
//            }
//        });
//
//        ibtn_qt.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam/Qt_Cpp_Projects";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_html.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam/Html_JScript_Examples";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_css.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam/HTML5-CSS3";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_js.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam/Javascript_Advanced";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_json.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam/Javascript_Advanced";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_php.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "http://www.aprenderaprogramar.es/index.php?option=com_content&view=category&id=70&Itemid=193";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_drupal.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://www.drupal.org/";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_dw.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "http://www.aulaclic.es/dreamweaver-cs5/";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//
//        ibtn_ajax.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam/Javascript_Advanced";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//        ibtn_jquery.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Abriré el navegador con un intent y la uri de git
//                String url = "https://github.com/eriDam/Javascript_Advanced";
//                Intent abreGit = new Intent(Intent.ACTION_VIEW);
//                abreGit.setData(Uri.parse(url));
//                startActivity(abreGit);
//            }
//        });
//        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
//    }

}
