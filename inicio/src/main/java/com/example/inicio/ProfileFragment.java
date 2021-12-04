package com.example.inicio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.inicio.api.RestApi;
import com.example.inicio.api.Uri;
import com.example.inicio.api.models.SuccessLogin;
import com.example.inicio.api.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileFragment extends Fragment {

    private EditText etGenero, etEdad, etPeso, etEstatura, etActFisica, etFrecFisica;
    private Retrofit retrofit;
    private RestApi restApi;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etGenero = (EditText) view.findViewById(R.id.etGenero);
        etEdad = (EditText) view.findViewById(R.id.etEdad);
        etPeso = (EditText) view.findViewById(R.id.etPeso);
        etEstatura = (EditText) view.findViewById(R.id.etEstatura);
        etActFisica = (EditText) view.findViewById(R.id.etActFisica);
        etFrecFisica = (EditText) view.findViewById(R.id.etFrecFisica);

        retrofit = new Retrofit.Builder()
                .baseUrl(Uri.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofit.create(RestApi.class);

        preferences = this.getActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
        editor = preferences.edit();

        int userId = preferences.getInt("userId", 0);
        String token = preferences.getString("token", "token");

        Call<User> response = restApi.getUser(token, userId);

        response.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println("code: " + response.code());
                if(response.code() == 200){

                    User user = response.body();
                    etGenero.setText(user.getGender());
                    etEdad.setText(String.valueOf(user.getAge()));
                    etPeso.setText(user.getWeight() + " kg");
                    etEstatura.setText(user.getHeight() + " cm");
                    etActFisica.setText(user.getPhysicActivity());
                    etFrecFisica.setText(user.getPhysicalActivityFrecuency());

                } else {
                    System.out.println("El usuario seleccionado no fue encontrado");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println("Error: -> "+throwable.getMessage());
            }
        });



    }
}