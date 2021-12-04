package com.example.inicio;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.inicio.api.RestApi;
import com.example.inicio.api.Uri;
import com.example.inicio.api.models.ScoreResponse;
import com.example.inicio.api.models.User;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScoreFragment extends Fragment {

    private Retrofit retrofit;
    private RestApi restApi;

    private TabLayout tabLayout;
    private TableLayout tableLayout;

    private ViewPager viewPager;
    private VPAdapter vpAdapter;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private ConstraintLayout adminLayout;
    private ConstraintLayout studentLayout;

    private Button btnBuscar;
    private Spinner spGame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adminLayout = (ConstraintLayout) view.findViewById(R.id.adminScore);
        studentLayout = (ConstraintLayout) view.findViewById(R.id.studentScore);
        tableLayout = (TableLayout) view.findViewById(R.id.table);
        btnBuscar = (Button) view.findViewById(R.id.btBuscar);

        retrofit = new Retrofit.Builder()
                .baseUrl(Uri.base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofit.create(RestApi.class);

        preferences = this.getActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
        editor = preferences.edit();
        String role = preferences.getString("role", "student");

        if(role.equals("admin")){
            adminLayout.setVisibility(View.VISIBLE);

            tabLayout = (TabLayout) view.findViewById(R.id.tabScore);
            viewPager = (ViewPager) view.findViewById(R.id.viewPager);

            tabLayout.setupWithViewPager(viewPager);
            vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            vpAdapter.addFragment(new AddScoreFragment(), "AGREGAR");
            vpAdapter.addFragment(new ConsultScoreFragment(), "CONSULTAR");
            viewPager.setAdapter(vpAdapter);
        } else {
            studentLayout.setVisibility(View.VISIBLE);

            spGame = (Spinner) view.findViewById(R.id.spGame);
            ArrayAdapter<?> adapterGame = ArrayAdapter.createFromResource(view.getContext(), R.array.Games2, R.layout.custom_item_spinner);
            adapterGame.setDropDownViewResource(R.layout.custom_spinner);
            spGame.setAdapter(adapterGame);

            int playerId = preferences.getInt("userId", 0);

            btnBuscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tableLayout.removeAllViews();
                    int gameId = spGame.getSelectedItemPosition();
                    getScore(playerId, gameId);
                }
            });
            getScore(playerId, 0);
        }
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

}