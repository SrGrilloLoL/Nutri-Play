package com.example.inicio;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.inicio.api.RestApi;
import com.example.inicio.api.Uri;
import com.example.inicio.api.models.UserDto;
import com.example.inicio.api.models.UserSuccess;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Registrarse extends AppCompatActivity {

    private Retrofit retrofit;
    private RestApi restApi;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText etUsuario, etContraseña;
    private Spinner spGenero, spEdad, spPeso, spEstatura, spActividadFisica, spFrecuenciaActividad;
    private Button btRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        //REST API CONNECTION
        retrofit = new Retrofit.Builder()
                .baseUrl(Uri.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofit.create(RestApi.class);

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

        btRegistrarse = (Button) findViewById(R.id.btnAddScore);

    }

    public void registrarse(View view){

        UserDto userDto = new UserDto();

        String username = etUsuario.getText().toString();
        String password = etContraseña.getText().toString();

        if(username.equals("")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setTitle("Campos faltantes");
            dialog.setMessage("Por favor ingresa un usuario válido.");

            dialog.show();

            return;
        }

        if(password.equals("")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setTitle("Campos faltantes");
            dialog.setMessage("Por favor ingresa una contraseña válida.");

            dialog.show();
            return;
        }

        int age = Integer.parseInt(spEdad.getSelectedItem().toString());
        int height = Integer.parseInt(spEstatura.getSelectedItem().toString());
        int weight = Integer.parseInt(spPeso.getSelectedItem().toString());
        int genderId = spGenero.getSelectedItemPosition()+1;
        int physicActivityId = spActividadFisica.getSelectedItemPosition()+1;
        int physicalActivityFrecuencyId = spFrecuenciaActividad.getSelectedItemPosition()+1;

        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setAge(age);
        userDto.setHeight(height);
        userDto.setWeight(weight);
        userDto.setGenderId(genderId);
        userDto.setPhysicalActivityId(physicActivityId);
        userDto.setPhysicalActivityFrecuencyId(physicalActivityFrecuencyId);

        Call<UserSuccess> response = restApi.createUser(userDto);

        response.enqueue(new Callback<UserSuccess>() {
            @Override
            public void onResponse(Call<UserSuccess> call, Response<UserSuccess> response) {

                System.out.println("Status Code: " + response.code());

                if(response.code() == 201){
                    Intent intent = new Intent(Registrarse.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Registrarse.this);
                    dialog.setTitle("Ocurrio un problema");
                    dialog.setMessage("El usuario no pudo ser creado");
                    dialog.show();
//                    System.out.println("");
                }

            }
            @Override
            public void onFailure(Call<UserSuccess> call, Throwable t) {
                String message = "Login Failed";
                System.out.println("Error ---> " + t.getMessage());
            }
        });

    }

}