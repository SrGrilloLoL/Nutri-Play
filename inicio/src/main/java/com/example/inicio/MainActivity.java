package com.example.inicio;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etContraseña;
    Button btIniciarSesion;
    TextView tvRegistrarse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        etUsuario = (EditText) findViewById(R.id.etUsuario);
//        etContraseña = (EditText) findViewById(R.id.etContraseña);
//        btIniciarSesion = (Button) findViewById(R.id.btIniciarSesion);
//        tvRegistrarse = (TextView) findViewById(R.id.tvRegistrarse);


    }

    public void iniciarSesion (View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void registrarse (View view){
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }

}