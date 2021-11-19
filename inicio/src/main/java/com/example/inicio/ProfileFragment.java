package com.example.inicio;

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

public class ProfileFragment extends Fragment {

    private EditText etGenero, etEdad, etPeso, etEstatura, etActFisica, etFrecFisica;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

    }
}