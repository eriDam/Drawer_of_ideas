package com.example.erika_000.oncode;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by erika_000 on 22/04/2015.
 * http://elbauldeandroid.blogspot.com.es/2013/10/actionbar-android-en-construccion.html
 * Crear las vistas que incluirá el ViewPager.
 * FragmentPagerAdapter: es la clase mas indicada para crear un numero determinado de vistas
 FragmentStatePagerAdapter: clase mas indicada para cuando tenemos un numero indeterminado de vistas, automáticamente
 Android irá destruyendo fragmentos que no estén a la vista reduciendo el consumo de memoria.

 Creamos nuestro adaptador y al extender "FragmentPagerAdapter" nos obliga a crear un constructor (que en este caso no lo
 usaremos, por lo tanto lo dejamos tal cual)
 */
public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

//Sobreescribir los métodos
//Estamos indicando que cuando tenga que cargar dicha vista nos cree un nuevo fragmento.
        public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment_Lessons();
            case 1:
                return new Fragment_Profiles();
            case 2:
                return new Fragment_Code();
            case 3:
                return new Fragment_Manager();
            default:
                return null;
        }
    }
//Le devolvemos el numero de vistas.
    public int getCount() {
        return 4;
    }

//Este método sera el encargado de poner el titulo en el nuevo panel informativo que estamos creando.
//    public CharSequence getPageTitle(int position) {
//        String titulo = null;
//        switch (position) {
//            case 0:
//                titulo = "LESSONS";
//                break;
//            case 1:
//                titulo = "PERFILES";
//                break;
//            case 2:
//                titulo = "CODE";
//                break;
//            case 3:
//                titulo = "GESTIÓN";
//                break;
//        }
//        return titulo;
//    }
}

