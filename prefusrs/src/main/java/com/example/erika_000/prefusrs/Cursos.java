package com.example.erika_000.prefusrs;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.erika_000.prefusrs.util.Curso;
import com.example.erika_000.prefusrs.util.CursosListAdapter;
import com.example.erika_000.prefusrs.util.TextchangeListener;

import java.util.ArrayList;


public class Cursos extends ActionBarActivity {

    //Declaro los controles del layout
    private EditText txt_area, txt_nombre, txt_link, txt_profe;
    /*Creo una lista genérica de tipo Curso y será una clase ArrayList, más adelante este
    * arrayList será reemplazado por una base de datos
      private List<Curso> cursos = new ArrayList<Curso>();No damos tamaño, iremos rellenando
    *
    * Cap5. Comento, x q reemplazo el arrayList por un ArrayAdapter:
    * Que tiene toda la infraestructura de notificaciones para agregar.
    *  Ya contiene una lista con 1 coleccion de datos, en este caso
    *  un arrayList que vamos a utilizar que seran todos los
    * contactos que vamos dando de alta. Si lo hicieramos a través del arrayList, tendríamos que
    * agregar el contacto al ArrayList y después volver a publicar el contenido dentro
    * del arrayAdapter (estamos haciendo el trabajo 2 veces)
    */
    private ArrayAdapter<Curso> adapter;

    //Declaramos una referencia a nuestro objeto Listview
    private ListView cursosListview;
    private ImageView imgViewCurso;
    private Button btn_guardar;
    //private Uri imageUri;
    //A veces van a llegar varias notificaciones , hay que saber cual estams esperando
    private int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Carga la interfaz visual
        setContentView(R.layout.activity_cursos);

        //Inicializo los componentes de la UI
        inicializarComponentesUI();
        //Lo llamo después de inicializar componentes
        inicializarListaCursos();

        //Las pestañas dentro de TabHost hay que inicialiarlas y si no queremos que ponga TAB1 y 2
        inicializarTabs();
    }
    //Para esto hay que crear otra clase mas que va a heredar de ArrayAdapter, su función sera integrar cada
    //elemento en el listView, cuando agregamos nuevos cursos serán añadidos directamente al adaptador no a la lista
    private void inicializarListaCursos() {
        //Creamos el objeto de tipo adapter. Pasamos el contexto this que es esta misma actividad
        adapter = new CursosListAdapter(this, new ArrayList<Curso>());//creamos aqui nustro arraList, embebido dentro de nuestro CursosListAdapter
        //Publicamos el cursosListview, decimos de donde vaa obtener la info, del adaptador que acabo de inicializar
        cursosListview.setAdapter(adapter);
    }

    //Método para inicializarTabs
    private void inicializarTabs() {
        //Su unica función es generar una instancia de la clase TabHost
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();//Le indico a Android que voy a configurar las pestañas

        //creo un objeto de tipo TabSpec
        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");//pongo el mmismo nombre que el id
        spec.setContent(R.id.tab1);
        spec.setIndicator("Crear");//Pongo el titulo
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tab2");//pongo el mmismo nombre que el id
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lista");//Pongo el titulo
        tabHost.addTab(spec);

    }


    //Método para inicializar los componentes
    private void inicializarComponentesUI() {
        txt_area = (EditText) findViewById(R.id.etxt_area);
        txt_nombre = (EditText) findViewById(R.id.etxt_nombre);
        txt_link = (EditText) findViewById(R.id.etxt_link);
        txt_profe = (EditText) findViewById(R.id.etxt_profe);
        //Inicializo el list
        cursosListview = (ListView) findViewById(R.id.listView);
        //Inicializo imagen
        imgViewCurso = (ImageView) findViewById(R.id.imgViewCurso);

        //Creo un package util y una clase TextChangeListener, la creo aparte
        //por que si la creo en el Main tengo que sobreescribir todos los métodos ya q  es una clase abstracta
        //Asigno al campo área el listener y creo una nueva clase anónima new TextchangeListener() y sobreescribo el método que quiero
        txt_area.addTextChangedListener(new TextchangeListener() {
            //sobreescribo el onTextchanged, se ejcutara cada vez que el user escriba algo en el campo
            @Override
            public void onTextChanged(CharSequence seq, int start, int before, int count) {
                //Necesito obtener la instancia del botón
                btn_guardar = (Button) findViewById(R.id.btn_guardar);
                //Le asigno que se active o no, cambio el nombre a la sequencia de caracteres y esa secuencia que la
                // convierta a cadena, quite los espacios en blanco y si está vacia, si no esta vacia se activa, si esta vacia está desactivado
                btn_guardar.setEnabled(!seq.toString().trim().isEmpty());

            }
        });
        txt_nombre.addTextChangedListener(new TextchangeListener() {
            @Override
            public void onTextChanged(CharSequence seq, int start, int before, int count) {
                //Le asigno que se active o no, cambio el nombre a la sequencia de caracteres y esa secuencia que la
                // convierta a cadena, quite los espacios en blanco y si está vacia, si no esta vacia se activa, si esta vacia está desactivado
                btn_guardar.setEnabled(!seq.toString().trim().isEmpty());

            }
        });
        txt_link.addTextChangedListener(new TextchangeListener() {
            @Override
            public void onTextChanged(CharSequence seq, int start, int before, int count) {
                //Le asigno que se active o no, cambio el nombre a la sequencia de caracteres y esa secuencia que la
                // convierta a cadena, quite los espacios en blanco y si está vacia, si no esta vacia se activa, si esta vacia está desactivado
                btn_guardar.setEnabled(!seq.toString().trim().isEmpty());

            }
        });
        txt_profe.addTextChangedListener(new TextchangeListener() {
            @Override
            public void onTextChanged(CharSequence seq, int start, int before, int count) {
                //Le asigno que se active o no, cambio el nombre a la sequencia de caracteres y esa secuencia que la
                // convierta a cadena, quite los espacios en blanco y si está vacia, si no esta vacia se activa, si esta vacia está desactivado
                btn_guardar.setEnabled(!seq.toString().trim().isEmpty());

            }
        });


    }


    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cursos, menu);
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


    public void onClick(View view) {
        //Creo un método dentro del onClick para agregar contactos a la lista,
        //le voy a pasar cada una de las cadenas que se ha escrito en cada campo cuando integre la bd este método vendrá muy bien
        agregarCurso(
                txt_area.getText().toString(),
                txt_nombre.getText().toString(),
                txt_link.getText().toString(),
                txt_profe.getText().toString(),
                (Uri) imgViewCurso.getTag()
        );

        //Hago uso del format para evitar concatenar con el mas, eso supone carga para el equipo
        //%s indica que le voy a pasar una view con un texto
        String mesg = String.format("%s ha sido agregado a la lista!", txt_area.getText());
        //Le paso al Toast el mensaje
        Toast.makeText(this, mesg, Toast.LENGTH_SHORT).show();

        //Creo el método limpiar campos() ctrl+enter, una vez se le ha dado click en guardar, borro pantalla
        limpiarCampos();

        //Creo otro método para inicializar la lista (lo utilizo directo y ctrl+enter lo creará solo)
        //inicializarListaCursos();
        btn_guardar.setEnabled(false);//cuando se haya limpiado el campo se vuelve a desactivar el boton

    }



    private void agregarCurso(String area, String nombre, String link, String profe, Uri imageUri) {
       Curso nuevoCurso =new Curso(area,nombre,link,profe,imageUri);//añado los param
       // Lo agregamos al adapter
       adapter.add(nuevoCurso);
        //cuando ya se agrega el curso auto se le notifica al listView que hay una modificacion y actualiza
    }

    private void limpiarCampos() {
        // borra los campos de texto de la pantalla, así es mas fácil para el usuario
        txt_area.getText().clear();
        txt_nombre.getText().clear();
        txt_link.getText().clear();
        txt_profe.getText().clear();
        //restablecemos la imagen por default
        imgViewCurso.setImageResource(R.drawable.ic_cam);
        txt_area.requestFocus();
    }

    //Cuando el ususario toque la pantalla donde está la imagen, saldrá un dialogo y que pueda escoger una foto de su galeria
    //Hay uqe verificar la version de la plataforma y pedir permisos
      public void onImgClick(View view) {
          Intent intent = null;
          if (Build.VERSION.SDK_INT < 19)
              //android JellyBean 4.3 y anteriores se utiliza de una forma y a partir de Kitkat se maneja de otra
          {
              //Para JellyBean creamos un intent...
              intent = new Intent();
              //Indicamos a Android con el intent que solicitamos acceso a un tipo de contenido
              intent.setAction(Intent.ACTION_GET_CONTENT);
              //intent.setType("image/*");//Este contenido va a ser de tipo mime, el * significa cualquier tipo de imagen
              // startActivityForResult(intent, request_code);
          }else
          {
            //Para Android Kitkat 4.4 o sup. cambia un poco el Intent
              //La creación del objeto hay que hacerla a través de
              intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
              // añado categoría archivos que puedan ser abiertos CATEGORY_OPENABLE es para
              intent.addCategory(Intent.CATEGORY_OPENABLE);
              //intent.setType("image/*");

              //startActivityForResult(intent, request_code);
          }
            //Estas dos líneas las ejecutará despues de cumplir una de las dos condiciones,
            //Las coloco aquí para optimizar el código ya que estan repetidas(dejo comentadas)

          /*Este contenido va a ser de tipo mime, el * significa cualquier tipo de imagen
          *Utilizamos este para solicitar a android abrir el dialogo*/
           intent.setType("image/*");

          /*Iniciamos también con startActivityForResult, esto permite lanzar
           *el objeto intent  y obtener un método de respuesta*/
          startActivityForResult(intent, request_code);
    }


    /*Cap 6: Para obtener la imagen seleccionada, sobreescribo el metodo onActivityResult
    *Permite identificar que tipo de respuesta estamos recibiendo, podemos estar llamando varios dialogos
    * Para obtener varias haré un switch*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode == RESULT_OK && requestCode == request_code)
       {
        imgViewCurso.setImageURI(data.getData());
           //Utilizamos el atributo TAG para almacenar la uri al archivo seleccionado, es como una envoltura para guardar informacion que necesitemos posteriormente
            //guardamos el objeto uri ya que no hay forma de obtenerlo como uri, luego lo necesitaré para la lista


       }
    }
}
