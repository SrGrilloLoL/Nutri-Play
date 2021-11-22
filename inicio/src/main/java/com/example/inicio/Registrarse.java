package com.example.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class Registrarse extends AppCompatActivity {

    EditText etUsuario, etContraseña;
    Spinner spGenero, spEdad, spPeso, spEstatura, spActividadFisica, spFrecuenciaActividad;
    Button btRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContraseña = (EditText) findViewById(R.id.etContraseña);

        spGenero = (Spinner) findViewById(R.id.spGenero);
        ArrayAdapter<?> adapterGenero = ArrayAdapter.createFromResource(this, R.array.Genero, R.layout.custom_item_spinner);
        adapterGenero.setDropDownViewResource(R.layout.custom_spinner);
        spGenero.setAdapter(adapterGenero);

        spEdad = (Spinner) findViewById(R.id.spEdad);
        ArrayAdapter<?> adapterEdad = ArrayAdapter.createFromResource(this, R.array.Edad, R.layout.custom_item_spinner);
        adapterEdad.setDropDownViewResource(R.layout.custom_spinner);
        spEdad.setAdapter(adapterEdad);

        spPeso = (Spinner) findViewById(R.id.spPeso);
        ArrayAdapter<?> adapterPeso = ArrayAdapter.createFromResource(this, R.array.Peso, R.layout.custom_item_spinner);
        adapterPeso.setDropDownViewResource(R.layout.custom_spinner);
        spPeso.setAdapter(adapterPeso);

        spEstatura = (Spinner) findViewById(R.id.spEstatura);
        ArrayAdapter<?> adapterEstatura = ArrayAdapter.createFromResource(this, R.array.Estatura, R.layout.custom_item_spinner);
        adapterEstatura.setDropDownViewResource(R.layout.custom_spinner);
        spEstatura.setAdapter(adapterEstatura);

        spActividadFisica = (Spinner) findViewById(R.id.spActividadFisica);
        ArrayAdapter<?> adapterActividadFisica = ArrayAdapter.createFromResource(this, R.array.ActFisica, R.layout.custom_item_spinner);
        adapterActividadFisica.setDropDownViewResource(R.layout.custom_spinner);
        spActividadFisica.setAdapter(adapterActividadFisica);


        spFrecuenciaActividad = (Spinner) findViewById(R.id.spFrecuenciaActividad);
        ArrayAdapter<?> adapterFrecuenciaActividad = ArrayAdapter.createFromResource(this, R.array.FrecFisica, R.layout.custom_item_spinner);
        adapterFrecuenciaActividad.setDropDownViewResource(R.layout.custom_spinner);
        spFrecuenciaActividad.setAdapter(adapterFrecuenciaActividad);

        btRegistrarse = (Button) findViewById(R.id.btRegistrarse);

    }

    public void registrarse(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}