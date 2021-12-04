package com.example.inicio;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.inicio.api.RestApi;
import com.example.inicio.api.Uri;
import com.example.inicio.api.models.ScoreResponse;
import com.example.inicio.api.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConsultScoreFragment extends Fragment {

    private Retrofit retrofit;
    private RestApi restApi;

    private ArrayList<ScoreResponse> usersScore;
    private ArrayList<String> users;
    private ArrayList<User> usuarios;

    private TableLayout tableLayout;
    private Button btnBuscar;
    private Spinner spGame, spUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consult_score, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tableLayout = (TableLayout) view.findViewById(R.id.table);
        btnBuscar = (Button) view.findViewById(R.id.btBuscar);

        retrofit = new Retrofit.Builder()
                .baseUrl(Uri.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofit.create(RestApi.class);

        usersScore = new ArrayList();
        users = new ArrayList<String>();
        usuarios = new ArrayList<User>();

        spGame = (Spinner) view.findViewById(R.id.spGame);
        ArrayAdapter<?> adapterGame = ArrayAdapter.createFromResource(view.getContext(), R.array.Games2, R.layout.custom_item_spinner);
        adapterGame.setDropDownViewResource(R.layout.custom_spinner);
        spGame.setAdapter(adapterGame);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableLayout.removeAllViews();

                String username = spUser.getSelectedItem().toString();
                int gameId = spGame.getSelectedItemPosition();

                User user = getUserByUsername(username);

                int playerId = (user != null )? user.getUserId() : 0;

//                System.out.println("userId ----> " + userId);
//                System.out.println("gameId ----> " + gameId);

                getScore(playerId, gameId);
            }
        });

        Call<List<User>> response = restApi.getUsers();

        response.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users.add("Todos");
                for(User user:response.body()){
                    users.add(user.getUsername());
                    usuarios.add(user);
                }
                spUser = (Spinner) view.findViewById(R.id.spUser);
                ArrayAdapter<?> adapterUser = new ArrayAdapter(view.getContext(), R.layout.custom_item_spinner, users);
                adapterUser.setDropDownViewResource(R.layout.custom_spinner);
                spUser.setAdapter(adapterUser);
                spUser.setAdapter(adapterUser);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {

            }
        });

        getScore(0, 0);

    }

    public void addStyles(TextView tv, String text, float weight){
        tv.setText(text);
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(12);

        float paddingDp = 10f;
        int paddingPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, paddingDp, getResources().getDisplayMetrics());

        tv.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setLayoutParams( new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weight));
    }

    public void addHeaderStyles(TextView tv, String text, float weight){
        tv.setText(text);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(14);

        float paddingDp = 10f;
        int paddingPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, paddingDp, getResources().getDisplayMetrics());

        tv.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setLayoutParams( new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weight));
    }


    public void getScore(int playerId, int gameId){
        Call<List<ScoreResponse>> response = restApi.getScore(playerId, gameId);

        response.enqueue(new Callback<List<ScoreResponse>>() {
            @Override
            public void onResponse(Call<List<ScoreResponse>> call, Response<List<ScoreResponse>> response) {
                if(response.code() == 200){

                    TableRow rowHeader = new TableRow(getContext());
                    TextView usernameHeader = new TextView(getContext());
                    TextView gameHeader = new TextView(getContext());
                    TextView scoreHeader = new TextView(getContext());

                    rowHeader.setBackground(ContextCompat.getDrawable(getContext(), R.color.purple_200));

                    addHeaderStyles(usernameHeader, "Usuario", 4f);
                    addHeaderStyles(gameHeader, "Juego", 4f);
                    addHeaderStyles(scoreHeader, "Puntos", 2f);

                    rowHeader.addView(usernameHeader);
                    rowHeader.addView(gameHeader);
                    rowHeader.addView(scoreHeader);

                    tableLayout.addView(rowHeader);

                    for(ScoreResponse scoreResponse:response.body()){

                        TableRow row = new TableRow(getContext());

                        TextView username = new TextView(getContext());
                        TextView game = new TextView(getContext());
                        TextView score = new TextView(getContext());

                        addStyles(username, scoreResponse.getPlayer().getUsername(), 4f);
                        addStyles(game, scoreResponse.getGame().getName(), 4f);
                        addStyles(score, String.valueOf(scoreResponse.getScore()), 2f);

                        row.addView(username);
                        row.addView(game);
                        row.addView(score);

                        tableLayout.addView(row);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<ScoreResponse>> call, Throwable throwable) {

            }
        });
    }

    public User getUserByUsername(String username){

        for(User user:usuarios){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

}