package com.example.inicio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.unity3d.player.UnityPlayerActivity;

public class Perfil extends AppCompatActivity {

    private int visualizarMenu = 0;
    private LinearLayout lvPerfil, lvActFisica, lvJuego, lvMenu, lvBanda, lvRompecabeza;
    private TextView tvUsuario, tvGenero;
    private Button btPerfil, btActFisica, btJuego, btEditar, btGuardar, btBanda, btRompecabeza;
    private Spinner spEdadP, spEstaturaP, spPesoP;
    private String link = "https://www.youtube.com/channel/UCERTeaGoYINlLt9Y31_fmUw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        lvPerfil = (LinearLayout) findViewById(R.id.lvPerfil);
        lvActFisica = (LinearLayout) findViewById(R.id.lvActFisica);
        lvJuego = (LinearLayout) findViewById(R.id.lvJuego);
        lvMenu = (LinearLayout) findViewById(R.id.lvMenu);
        lvBanda = (LinearLayout) findViewById(R.id.lvBanda);
        lvRompecabeza = (LinearLayout) findViewById(R.id.lvRompecabeza);

        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        tvGenero = (TextView) findViewById(R.id.tvGenero);

        btPerfil = (Button) findViewById(R.id.btPerfil);
        btActFisica = (Button) findViewById(R.id.btActFisica);
        btJuego = (Button) findViewById(R.id.btJuego);
        btEditar = (Button) findViewById(R.id.btEditar);
        btGuardar = (Button) findViewById(R.id.btGuardar);
        btBanda = (Button) findViewById(R.id.btBanda);
        btRompecabeza = (Button) findViewById(R.id.btRompecabeza);

        spEdadP = (Spinner) findViewById(R.id.spEdadP);
        String edad[] = {"Selecciona", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapterEdad = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                edad);
        spEdadP.setAdapter(adapterEdad);
        spEdadP.setEnabled(false);

        spPesoP = (Spinner) findViewById(R.id.spPesoP);
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
        spPesoP.setAdapter(adapterPeso);
        spPesoP.setEnabled(false);

        spEstaturaP = (Spinner) findViewById(R.id.spEstaturaP);
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
        spEstaturaP.setAdapter(adapterEstatura);
        spEstaturaP.setEnabled(false);

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
        spPesoP.setEnabled(true);
        spEstaturaP.setEnabled(true);
        spEdadP.setEnabled(true);



        btGuardar.setEnabled(true);
        btEditar.setEnabled(false);
    }

    public void guardarPerfil(View view){
        spPesoP.setEnabled(false);
        spEstaturaP.setEnabled(false);
        spEdadP.setEnabled(false);



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

    public void visualizarBanda(View view){
        btBanda.setEnabled(false);
        btRompecabeza.setEnabled(true);
        lvRompecabeza.setVisibility(View.GONE);
        lvBanda.setVisibility(View.VISIBLE);
    }

    public void visualizarRompecabezas(View view){
        btBanda.setEnabled(true);
        btRompecabeza.setEnabled(false);
        lvRompecabeza.setVisibility(View.VISIBLE);
        lvBanda.setVisibility(View.GONE);
    }

}