package com.example.inicio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.unity3d.player.UnityPlayerActivity;

public class PuzzleFragment extends Fragment {

    private String link = "https://www.youtube.com/channel/UCERTeaGoYINlLt9Y31_fmUw";
    private  Button btnPuzzle;
    private Button btnTutorial;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_puzzle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPuzzle = (Button) view.findViewById(R.id.btnPuzzle);
        btnTutorial = (Button) view.findViewById(R.id.btnTutorial);


        btnPuzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UnityPlayerActivity.class);
                startActivity(intent);
            }
        });

        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(link);
                Intent intent = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(intent);
            }
        });

    }




}