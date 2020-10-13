package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentInicial#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentInicial extends Fragment {

    private static final int DEPORTES = 10;
    private static final int TECNOLOGIA = 11;

    public FragmentInicial() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentInicial.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentInicial newInstance() {
        FragmentInicial fragment = new FragmentInicial();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_inicial, container, false);

        Button toDeportes = rootView.findViewById(R.id.btn_toEncuesta_b);
        Button toTecnologia = rootView.findViewById(R.id.btn_toEncuesta_a);

        toDeportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentPreguntas fragmentPreguntas = FragmentPreguntas.newInstance(DEPORTES);

                MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                MainActivity.fragmentTransaction.replace(R.id.fragment_container, fragmentPreguntas).commit();
            }
        });

        toTecnologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentPreguntas fragmentPreguntas = FragmentPreguntas.newInstance(TECNOLOGIA);

                MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                MainActivity.fragmentTransaction.replace(R.id.fragment_container, fragmentPreguntas).commit();
            }
        });

        return rootView;
    }
}