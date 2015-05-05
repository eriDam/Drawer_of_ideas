package com.example.erika_000.oncode;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//2 parte Añadiendo Tabs al ViewPager
/*cambiando la extensión de la clase por "ActionBarActivity" para poder hacer uso de las tabs.
Implementamos las dos interfaces "ActionBar.TabListener" y "OnPageChangeListener"*/
public class MainActivity  extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    static final Inf inf = new Inf();
    static final Sup sup = new Sup();
    // CREAMOS EL OBJETO FUERA DEL ONCREATE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Establecemos el layout creado previamente a través del método "setcontentView()".
        // Y creamos un objeto de nuestra clase (PagerAdapter) que utilizaremos
        //  como adaptador de las vistas. Ya por ultimo configuramos el "ViewPager"
        //  de nuestro layout y le aplicamos el adaptador.
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        //aplicamos a nuestro ViewPager setOnPageChangeListener
       mViewPager.setOnPageChangeListener(this);

        //Se crea el objeto actionBar para ponerlo en modo tabs y creamos las
        // tres pestañas aplicándoles el listener a través del "this"
        ActionBar actionBar = getSupportActionBar();
         actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText(R.string.lessons).setTabListener(this);
        actionBar.addTab(tab);
        ActionBar.Tab tab2 = actionBar.newTab().setText(R.string.Perfiles).setTabListener(this);
        actionBar.addTab(tab2);
        ActionBar.Tab tab3 = actionBar.newTab().setText(R.string.oncode).setTabListener(this);
        actionBar.addTab(tab3);
        ActionBar.Tab tab4 = actionBar.newTab().setText(R.string.Manager).setTabListener(this);
        actionBar.addTab(tab4);



        //Listview lessons
        /**Creo el array aquí en lugar de en strings
         * */
        String[] lessons = {"Github", "C++", "Qt","JavaScript","HTML 5", "CSS3","JQuery","Ajax",
                "JSon","PHP","Dreamweaver","Drupal","Android-Java","MySql","Blogger",
                "Wordpress","SEO","Photoshop","Illustrator","Linux"};

        /**
         * Sustituyo el ArrayAdapter ArrayAdapter<String> adapter = new ArrayAdapter<String>
         * (this,R.layout.activity_main,R.id.textViewSo,so); que es el que estaba poniendo la
         * información por un adaptador propio, po ruqe las imagenes van a ser diferentes,
         * dependiendo del texto,
         *
         *  Usaré estos parametros para el constructor igual que en el anterior ArrayAdapter
         *  = new MiAdaptador(context, resource, textViewResourceId, objects)
         *  */

        //MiAdaptador adapterLis = new MiAdaptador(this, R.layout.list_layout, R.id.tv_lessons, lessons);

        /**
         * Utilizamos el metodo para ponerle el adapter, el list View coge estos datos y los
         * representa por pantalla
         * */
        //setListAdapter(adapterLis);




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
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "Git", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
//                Intent abreManager;
//                abreManager = new Intent().setClass(
//                        MainActivity.this, MainActivity2Activity.class);
//                startActivity(abreManager);
                return true;
            case R.id.menu_buscar:
                Toast.makeText(getApplicationContext(), "BUSCAR", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_favoritos:
                Toast.makeText(getApplicationContext(), "MAGANER", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_compartir:
                Toast.makeText(getApplicationContext(), "LUGARES", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "EVENTOS", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Metodo para el item de la lista de cursos
    protected void itemSeleccionado(String item) {
        inf.setItemSeleccionado(item);
    }
    //Metodos implementados
    //INTERFACES
    //Este método lo podremos utilizar para controlar cuando una vista se esta desplazando.
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        // Dentro del método le estamos diciendo que cambie de tab y ponga la correspondiente.
        getSupportActionBar().setSelectedNavigationItem(position);
    }
    //se utiliza cuando una vista se muestra en pantalla al deslizar de un lado a otro.



    /*Se utiliza para controlar el estado de desplazamiento, es decir, podríamos controlar el puntero del usuario al cambiar
     de vistas y preguntar cuando empieza a deslizar, cuando esta deslizando y cuando a terminado de deslizar una vista.*/
    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //INTERFACES
    //Utilizamos el método "setTabSelected()" para que cuando el usuario pinche en una tab o
    // pestaña nuestro ViewPager cambie automaticamente de vista.
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
    /**
     * ListActivity tiene este listener onListItemClick donde nos va a devolver los parametros
     * entre parentesis (el listView, el View sobre el cual está el listView, que posicion
     * dentro del array se ha seleccionado y otro elemento)
     * */
    //@Override
   // protected void onListItemClick(ListView l, View v, int position, long id){
        /** lo que se quiere obtener es el item, entonces, del ListAdapter se coje el item que hemos clicado
        String item = (String) getListAdapter().getItem(position);*/
        /** Se utiliza la clase Toast para mostrar por pantalla un pop up o mensaje que podemos lanzar
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();*/
//    }



}
