package com.example.erika_000.prefusrs.util;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by erika_000 on 04/05/2015.
 *
 *  Creo un package util y una clase TextChangeListener, la creo aparte
 *  por que si la creo en el Main tengo que sobreescribir todos los métodos
 *  ya que es una clase abstracta.
 *
 *  Los adaptadores son clases que implementan de forma predeterminada, todos los métodos
 *  de una interfaz. ctrl+o podemos seleccionarlos
 *
 *  Implemneto la interfaz TextWatcher y sus métodos
 */
public class TextchangeListener implements TextWatcher{
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
