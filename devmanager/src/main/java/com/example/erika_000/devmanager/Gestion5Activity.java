package com.example.erika_000.devmanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Gestion5Activity extends ActionBarActivity {
    private EditText txtCodigo;
    private EditText txtNombre;
    private TextView txtResultado;

    private Button btnInsertar;
    private Button btnActualizar;
    private Button btnEliminar;
    private Button btnConsultar;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion5);

        //Obtenemos las referencias a los controles
        txtCodigo = (EditText)findViewById(R.id.txtReg);
        txtNombre = (EditText)findViewById(R.id.txtVal);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        btnInsertar = (Button)findViewById(R.id.btnInsertar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        btnConsultar = (Button)findViewById(R.id.btnConsultar);

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        UsuariosSQLiteHelper usdbh =
                new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getWritableDatabase();

        btnInsertar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "INSERT INTO Usuarios (codigo,nombre) VALUES ('" + cod + "','" + nom + "') ";
                //db.execSQL(sql);

                //Alternativa 2: método insert()
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("codigo", cod);
                nuevoRegistro.put("nombre", nom);
                db.insert("Usuarios", null, nuevoRegistro);
            }
        });

        btnActualizar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "UPDATE Usuarios SET nombre='" + nom + "' WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Alternativa 2: método update()
                ContentValues valores = new ContentValues();
                valores.put("nombre", nom);
                db.update("Usuarios", valores, "codigo=" + cod, null);
            }
        });

        btnEliminar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                //Recuperamos los valores de los campos de texto
                String cod = txtCodigo.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "DELETE FROM Usuarios WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Alternativa 2: método delete()
                db.delete("Usuarios", "codigo=" + cod, null);
            }
        });

        btnConsultar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                //Alternativa 1: método rawQuery()
                Cursor c = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null);

                //Alternativa 2: método delete()
                //String[] campos = new String[] {"codigo", "nombre"};
                //Cursor c = db.query("Usuarios", campos, null, null, null, null, null);

                //Recorremos los resultados para mostrarlos en pantalla
                txtResultado.setText("");
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        String cod = c.getString(0);
                        String nom = c.getString(1);

                        txtResultado.append(" " + cod + " - " + nom + "\n");
                    } while(c.moveToNext());
                }
            }
        });
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

            case R.id.menu_inicio:
                Toast.makeText(getApplicationContext(), "INICIO", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abre;
                abre = new Intent(Gestion5Activity.this, MainActivity.class);
                startActivity(abre);
                return true;
            case R.id.menu_devtest:
                Toast.makeText(getApplicationContext(), "DEVTEST", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreDev;
                abreDev = new Intent(Gestion5Activity.this, DevTest.class);
                startActivity(abreDev);
                return true;
            case R.id.menu_lessons:
                Toast.makeText(getApplicationContext(), "LESSONS", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreLessons;
                abreLessons = new Intent(Gestion5Activity.this, Lessons2Activity.class);
                startActivity(abreLessons);
                return true;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(), "PERFILES", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreProf;
                abreProf = new Intent(Gestion5Activity.this, Prof3Activity.class);
                startActivity(abreProf);
                return true;
            case R.id.menu_git: /**Este Id  hace referencia al id del item del menu, en este caso buscar*/
                Toast.makeText(getApplicationContext(), "ONCODE", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGit;
                abreGit = new Intent(Gestion5Activity.this, OnCode4Activity.class);
                startActivity(abreGit);
                return true;
            case R.id.menu_gestion:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreGestion;
                abreGestion = new Intent(Gestion5Activity.this, Gestion5Activity.class);
                startActivity(abreGestion);
                return true;
            case R.id.menu_blog:
                Toast.makeText(getApplicationContext(), "GESTIÓN", Toast.LENGTH_SHORT).show();
                //arrancar la siguiente activity
                Intent abreBlog;
                abreBlog = new Intent(Gestion5Activity.this, Blog6Activity.class);
                startActivity(abreBlog);
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
                //TODO crear opciones de personalización
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
