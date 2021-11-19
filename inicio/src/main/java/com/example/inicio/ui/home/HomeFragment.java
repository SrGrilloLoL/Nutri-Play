package com.example.inicio.ui.home;

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
import androidx.lifecycle.ViewModelProvider;

import com.example.inicio.R;

public class HomeFragment extends Fragment {

    private Button btTutoriales;
    private String link = "https://www.youtube.com/channel/UCERTeaGoYINlLt9Y31_fmUw";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btTutoriales = (Button) view.findViewById(R.id.btTutoriales);

        btTutoriales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(link);
                Intent intent = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(intent);
            }
        });

    }




}