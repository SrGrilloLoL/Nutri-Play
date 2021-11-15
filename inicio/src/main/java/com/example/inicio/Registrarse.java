package com.example.inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
        String genero[] = {"Selecciona","Niño", "Niña"};
        ArrayAdapter<String> adapterGenero = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                genero);
        spGenero.setAdapter(adapterGenero);

        spEdad = (Spinner) findViewById(R.id.spEdad);
        String edad[] = {"Selecciona", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapterEdad = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                edad);
        spEdad.setAdapter(adapterEdad);

        spPeso = (Spinner) findViewById(R.id.spPeso);
        String peso[] = {"Selecciona", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
                "30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
                "40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
                "50", "51", "52", "53", "54", "55", "56", "57", "58", "59",
                "60", "61", "62", "63", "64", "65", "66", "67", "68", "69",
                "70", "71", "72", "73", "74", "75", "76", "77", "78", "79",
                "80", "81", "82", "83", "84", "85", "86", "87", "88", "89",
                "90", "91", "92", "93", "94", "95", "96", "97", "98", "99",
                "100"};
        ArrayAdapter<String> adapterPeso = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                peso);
        spPeso.setAdapter(adapterPeso);

        spEstatura = (Spinner) findViewById(R.id.spEstatura);
        String estatura[] = {"Selecciona", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
                "30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
                "40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
                "50", "51", "52", "53", "54", "55", "56", "57", "58", "59",
                "60", "61", "62", "63", "64", "65", "66", "67", "68", "69",
                "70", "71", "72", "73", "74", "75", "76", "77", "78", "79",
                "80", "81", "82", "83", "84", "85", "86", "87", "88", "89",
                "90", "91", "92", "93", "94", "95", "96", "97", "98", "99",
                "100", "101", "102", "103", "104", "105", "106", "107", "108", "109",
                "110", "111", "112", "113", "114", "115", "116", "117", "118", "119",
                "120", "121", "122", "123", "124", "125", "126", "127", "128", "129",
                "130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
                "140", "141", "142", "143", "144", "145", "146", "147", "148", "149",
                "150", "151", "152", "153", "154", "155", "156", "157", "158", "159",
                "160", "161", "162", "163", "164", "165", "166", "167", "168", "169",
                "170", "171", "172", "173", "174", "175", "176", "177", "178", "179",
                "180", "181", "182", "183", "184", "185", "186", "187", "188", "189",
                "190", "191", "192", "193", "194", "195", "196", "197", "198", "199",
                "200"};
        ArrayAdapter<String> adapterEstatura = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                estatura);
        spEstatura.setAdapter(adapterEstatura);

        spActividadFisica = (Spinner) findViewById(R.id.spActividadFisica);
        String actividadFisica[] = {"Selecciona", "Casi siempre estoy sentado viendo la televisión o jugando videojuegos",
        "Me gusta caminar y estar parado",
        "Me gusta correr y estar muy activo",
        "Practico un deporte como jugar futboll, natación o salgo a andar en bici"};
        ArrayAdapter<String> adapterActividadFisica = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                actividadFisica);
        spActividadFisica.setAdapter(adapterActividadFisica);


        spFrecuenciaActividad = (Spinner) findViewById(R.id.spFrecuenciaActividad);
        String frecuenciaActividad[] = {"Selecciona", "Nunca",
                "De 1 a 3 veces por semana",
                "De 4 a 6 veces por semana",
                "Los 7 días de la semana"};
        ArrayAdapter<String> adapterFrecuenciaActividad = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                frecuenciaActividad);
        spFrecuenciaActividad.setAdapter(adapterFrecuenciaActividad);

        btRegistrarse = (Button) findViewById(R.id.btRegistrarse);

    }

    public void registrarse(View view){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

}