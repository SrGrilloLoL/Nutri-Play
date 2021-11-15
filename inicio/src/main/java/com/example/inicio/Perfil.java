package com.example.inicio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unity3d.player.UnityPlayerActivity;

public class Perfil extends AppCompatActivity {

    private int visualizarMenu = 0;
    private LinearLayout lvPerfil, lvActFisica, lvJuego, lvMenu;
    private TextView tvUsuario, tvGenero;
    private Button btPerfil, btActFisica, btJuego, btEditar, btGuardar, btCerrarSesion;
    private EditText etEdad, etEstatura, etPeso;
    private String link = "https://www.youtube.com/channel/UCERTeaGoYINlLt9Y31_fmUw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        lvPerfil = (LinearLayout) findViewById(R.id.lvPerfil);
        lvActFisica = (LinearLayout) findViewById(R.id.lvActFisica);
        lvJuego = (LinearLayout) findViewById(R.id.lvJuego);
        lvMenu = (LinearLayout) findViewById(R.id.lvMenu);

        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        tvGenero = (TextView) findViewById(R.id.tvGenero);

        btPerfil = (Button) findViewById(R.id.btPerfil);
        btActFisica = (Button) findViewById(R.id.btActFisica);
        btJuego = (Button) findViewById(R.id.btJuego);
        btEditar = (Button) findViewById(R.id.btEditar);
        btGuardar = (Button) findViewById(R.id.btGuardar);
        btCerrarSesion = (Button) findViewById(R.id.btCerrarSesion);

        etEdad = (EditText) findViewById(R.id.etEdad);
        etEstatura = (EditText) findViewById(R.id.etEstatura);
        etPeso = (EditText) findViewById(R.id.etPeso);

    }

    public void mostrarPerfil(View view){
        btActFisica.setEnabled(true);
        btPerfil.setEnabled(false);
        btJuego.setEnabled(true);

        lvPerfil.setVisibility(View.VISIBLE);
        lvJuego.setVisibility(View.GONE);
        lvActFisica.setVisibility(View.GONE);
    }

    public void mostrarActFisicas (View view){
        btActFisica.setEnabled(false);
        btPerfil.setEnabled(true);
        btJuego.setEnabled(true);

        lvPerfil.setVisibility(View.GONE);
        lvJuego.setVisibility(View.GONE);
        lvActFisica.setVisibility(View.VISIBLE);
    }

    public void mostrarJuego(View view){
        btActFisica.setEnabled(true);
        btPerfil.setEnabled(true);
        btJuego.setEnabled(false);

        lvPerfil.setVisibility(View.GONE);
        lvJuego.setVisibility(View.VISIBLE);
        lvActFisica.setVisibility(View.GONE);
    }

    public void editarPerfil(View view){
        etPeso.setEnabled(true);
        etEstatura.setEnabled(true);
        etEdad.setEnabled(true);



        btGuardar.setEnabled(true);
        btEditar.setEnabled(false);
    }

    public void guardarPerfil(View view){
        etPeso.setEnabled(false);
        etEstatura.setEnabled(false);
        etEdad.setEnabled(false);



        btGuardar.setEnabled(false);
        btEditar.setEnabled(true);
    }

    public void mostrarMenu(View view){
        if(visualizarMenu == 0){
            lvMenu.setVisibility(View.VISIBLE);
            visualizarMenu = 1;
        } else {
            lvMenu.setVisibility(View.GONE);
            visualizarMenu = 0;
        }
    }

    public void mostrarYoutube(View view){
        Uri _link = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW, _link);
        startActivity(intent);
    }

    public void cerrarSesion(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void visualizarJuego(View view){
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
    }

}