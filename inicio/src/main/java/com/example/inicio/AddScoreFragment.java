package com.example.inicio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.inicio.api.RestApi;
import com.example.inicio.api.Uri;
import com.example.inicio.api.models.Game;
import com.example.inicio.api.models.LoginDto;
import com.example.inicio.api.models.ScoreDto;
import com.example.inicio.api.models.SuccessLogin;
import com.example.inicio.api.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddScoreFragment extends Fragment {


    private ArrayList<String> users;

    private Retrofit retrofit;
    private RestApi restApi;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private Spinner spUsers, spGames;
    private Button btnAddScore;
    private EditText etScore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_score, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        retrofit = new Retrofit.Builder()
                .baseUrl(Uri.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofit.create(RestApi.class);

        preferences = this.getActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
        editor = preferences.edit();

        users = new ArrayList<String>();

        Call<List<User>> response = restApi.getUsers();

        btnAddScore = (Button) view.findViewById(R.id.btnAddScore);
        etScore = (EditText) view.findViewById(R.id.etScore);

        response.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                for(User user:response.body()){
                    users.add(user.getUsername());
                }
                spUsers = (Spinner) view.findViewById(R.id.spUsers);
                ArrayAdapter<?> adapterUser = new ArrayAdapter(view.getContext(), R.layout.custom_item_spinner, users);
                adapterUser.setDropDownViewResource(R.layout.custom_spinner);
                spUsers.setAdapter(adapterUser);
                spUsers.setAdapter(adapterUser);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {

            }
        });

        spGames = (Spinner) view.findViewById(R.id.spGames);
        ArrayAdapter<?> adapterGame = ArrayAdapter.createFromResource(view.getContext(), R.array.Games, R.layout.custom_item_spinner);
        adapterGame.setDropDownViewResource(R.layout.custom_spinner);
        spGames.setAdapter(adapterGame);

        btnAddScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int playerId = spUsers.getSelectedItemPosition() + 1;
                int userId = preferences.getInt("userId", 0);
                int gameId = spGames.getSelectedItemPosition() + 1;
                int score = Integer.parseInt(etScore.getText().toString());

                ScoreDto scoreDto = new ScoreDto(score, userId, playerId, gameId);
                Call<ScoreDto> response = restApi.createScore(scoreDto);

                response.enqueue(new Callback<ScoreDto>() {
                    @Override
                    public void onResponse(Call<ScoreDto> call, Response<ScoreDto> response) {

                        if(response.code() == 201){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                            dialog.setTitle("Puntos agregados");
                            dialog.setMessage("Los puntos se agregaron al usuario.");
                            dialog.show();
                            spUsers.setSelection(0);
                            spGames.setSelection(0);
                            etScore.setText("");
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                            dialog.setTitle("Ocurrio un problema");
                            dialog.setMessage("No se puedieron agregar puntos a este usuario.");
                            dialog.show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ScoreDto> call, Throwable throwable) {

                    }
                });

            }
        });

    }



}