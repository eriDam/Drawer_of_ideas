package com.cipolat.slidenavigation;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
	    private String[] titulos;
	    private DrawerLayout NavDrawerLayout;
	    private ListView NavList;
        private ArrayList<Item_objct> NavItms;
        private TypedArray NavIcons;
	    private ActionBarDrawerToggle mDrawerToggle;
	    private CharSequence mDrawerTitle;
	    private CharSequence mTitle;
	    NavigationAdapter NavAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
            // Definimos la orientacion a vertical - Set portrait orientation
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			setContentView(R.layout.main);		

			//Obtengo el Drawer Layout del main.xml mediante su id
			NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			//Obtengo la Lista del main.xml
	        NavList = (ListView) findViewById(R.id.lista);

	        //Declaramos el header el cual sera el layout de header.xml imagen perfil del navDrawer
	        View header = getLayoutInflater().inflate(R.layout.header, null);
	        //Establecemos header
	        NavList.addHeaderView(header);

			//Tomamos listado de imgs desde drawable, he declarado el array en strings y hay cojo un array de drawable
	        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);			
			//Tomamos listado  de titulos desde el string-array de los recursos @string/nav_options
	        titulos = getResources().getStringArray(R.array.nav_options);

	        //Obtener Listado de titulos de barra de navegacion para que se visualicen
	        NavItms = new ArrayList<Item_objct>();
	        //Agregamos objetos Item_objct al array, tantos como hay declarados en el array de strings de imagenes y títulos
	        //Inicio
	        NavItms.add(new Item_objct(titulos[0], NavIcons.getResourceId(0, -1)));
	        //Perfiles
	        NavItms.add(new Item_objct(titulos[1], NavIcons.getResourceId(1, -1)));
	        //Lessons
	        NavItms.add(new Item_objct(titulos[2], NavIcons.getResourceId(2, -1)));
	        //Gestión lessons
	        NavItms.add(new Item_objct(titulos[3], NavIcons.getResourceId(3, -1)));
	        //onCode
	        NavItms.add(new Item_objct(titulos[4], NavIcons.getResourceId(4, -1)));
	        //Eventos - Calendario (Convertiré en utilidades para: submenú camara - radio - reproductor - calendario)
	        NavItms.add(new Item_objct(titulos[5], NavIcons.getResourceId(5, -1)));
	        //Blog Roll
	        NavItms.add(new Item_objct(titulos[6], NavIcons.getResourceId(6, -1)));
            //Configuración para cambiar el estilo de la app
            NavItms.add(new Item_objct(titulos[7], NavIcons.getResourceId(7, -1)));
            //Salir
            NavItms.add(new Item_objct(titulos[8], NavIcons.getResourceId(8, -1)));

	        //Declaramos y seteamos nuestro adaptador al cual le pasamos el array con los titulos
	        NavAdapter= new NavigationAdapter(this,NavItms);
	        NavList.setAdapter(NavAdapter);	
	        //Siempre vamos a mostrar el mismo titulo
	        mTitle = mDrawerTitle = getTitle();
	        
	        //Declaramos el mDrawerToggle y las imgs a utilizar
	        mDrawerToggle = new ActionBarDrawerToggle(
	                this,                  /* host Activity */
	                NavDrawerLayout,         /* DrawerLayout object */
	                R.drawable.ic_drawer,  /* Icono de navegacion*/
	                R.string.app_name,  /* "open drawer" description */
	                R.string.hello_world  /* "close drawer" description */
	                ) {
                /** Called when a drawer has settled in a completely open state. */
                public void onDrawerOpened(View drawerView) {
                    Log.e("Apertura completa", "!!");
                }
	            /** Called when a drawer has settled in a completely closed state. */
	            public void onDrawerClosed(View view) {

	            	Log.e("Cerrado completo", "!!");
	            }


	        };	        
	        
	        // Establecemos que mDrawerToggle declarado anteriormente sea el DrawerListener
	        NavDrawerLayout.setDrawerListener(mDrawerToggle);
	        //Establecemos que el ActionBar muestre el Boton Home
	        getActionBar().setDisplayHomeAsUpEnabled(true);

	        //Establecemos la accion al clickear sobre cualquier item del menu.
	        //De la misma forma que hariamos en una app comun con un listview.
	        NavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
	            	MostrarFragment(position);
	            }
	        });
//
	        //Cuando la aplicación cargue por defecto mostrar la opción Home

	         MostrarFragment(1);
	}

    //Método para cuando el usuario pulse el boton back no cierre la app
    @Override
    public void onBackPressed() {

        MostrarFragment(1);
        Log.e("Vuelve al home", "!!");
    }
	
	/*Pasando la posicion de la opción en el menu nos mostrará el Fragment correspondiente*/
    private void MostrarFragment(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
        case 1:
            fragment = new HomeFragment();
            break;
        case 2:
            fragment = new ProfileFragment();
            break;
        case 3:
            fragment = new FavoritosFragment();
            break;
        case 4:
            fragment = new BdFragment();
            break;
        case 5:
                fragment = new oncodeFragment();
                break;
        case 6:
                fragment = new EventFragment();
                break;

        default:
        	//si no esta la opcion mostrará un toast y nos mandará a Home
        	Toast.makeText(getApplicationContext(),"Opción "+titulos[position-1]+" no disponible!", Toast.LENGTH_SHORT).show();
            fragment = new HomeFragment();
            position=1;
            break;
        }
        //Validamos si el fragment no es nulo
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
 
            // Actualizamos el contenido segun la opcion elegida
            NavList.setItemChecked(position, true);
            NavList.setSelection(position);
            //Cambiamos el titulo en donde decia "
            setTitle(titulos[position-1]);
            //Cerramos el menu deslizable
            NavDrawerLayout.closeDrawer(NavList);
        } else {
            //Si el fragment es nulo mostramos un mensaje de error.
            Log.e("Error  ", "MostrarFragment"+position);
        }
    }
	  
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            Log.e("mDrawerToggle pushed", "x");
          return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);


    }
}
