package com.example.inicio;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.inicio.api.RestApi;
import com.example.inicio.api.Uri;
import com.example.inicio.api.models.LoginDto;
import com.example.inicio.api.models.LoginFailed;
import com.example.inicio.api.models.SuccessLogin;
import com.unity3d.player.UnityPlayerActivity;

import java.io.IOException;
import java.io.StringBufferInputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RestApi restApi;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText etUsuario, etContraseña;
    private Button btIniciarSesion;
    private TextView tvRegistrarse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContraseña = (EditText) findViewById(R.id.etContraseña);
        btIniciarSesion = (Button) findViewById(R.id.btIniciarSesion);
        tvRegistrarse = (TextView) findViewById(R.id.tvRegistrarse);

        //REST API CONNECTION
        retrofit = new Retrofit.Builder()
                .baseUrl(Uri.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofit.create(RestApi.class);

        preferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        editor = preferences.edit();

        if(preferences.getBoolean("isLogin", false)){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();
        }

    }

    public void iniciarSesion (View view){

        String username = etUsuario.getText().toString();
        String password = etContraseña.getText().toString();

        LoginDto loginDto = new LoginDto(username, password);

        Call<SuccessLogin> response = restApi.login(loginDto);

//        try{
//            String token = response.execute().body().getData().getAccessToken();
//            System.out.println("token: " + token );
//        } catch(IOException e){
//            System.out.println("Error: "+ e.getMessage());
//        }


        response.enqueue(new Callback<SuccessLogin>() {
            @Override
            public void onResponse(Call<SuccessLogin> call, Response<SuccessLogin> response) {

                System.out.println("Status Code: " + response.code());


                if(response.code() == 201){

                    SuccessLogin success = response.body();
//                    System.out.println("Token: " + success.getData().getAccessToken());

//                    System.out.println("ROLE -----> " + success.getData().getRole());

                    editor.putString("token", success.getData().getAccessToken());
                    editor.putString("username", success.getData().getUsername());
                    editor.putString("role", success.getData().getRole());
                    editor.putInt("userId", success.getData().getUserId());
                    editor.putBoolean("isLogin", true);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);

                }else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Ocurrio un problema");
                    dialog.setMessage("Creadenciales no válidas");
                    dialog.show();

                    String message = response.message();

                    editor.putString("token", null);
                    editor.putBoolean("isLogin", false);
                    editor.commit();
                }

            }
            @Override
            public void onFailure(Call<SuccessLogin> call, Throwable t) {
                String message = "Login Failed";
                System.out.println("Error ---> " + t.getMessage());
            }
        });

    }

    public void registrarse (View view){
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);

        MenuItem mi = menu.findItem(R.id.scoreFragment);
        mi.setVisible(true);
//        menu.getItem(R.id.physicalActivityFragment).setVisible(true);
        return true;
    }
}