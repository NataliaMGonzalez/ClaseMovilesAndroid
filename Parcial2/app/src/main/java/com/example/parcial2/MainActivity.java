package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    static final String STATE_FRAGMENT = "state_of_fragment";
    private RecyclerView mRecyclerView;
    public Adapter mAdapter;
    private List<Materias> mMateriasList = new ArrayList ();
    private TextView materiaActual;
    private TextView diaActual;
    private TextView horarioActual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*  Inicia código de Fragment  */
        // Create instance of fragment we will be using

        dynamicFragment dinFragment = new dynamicFragment();
        // Initializing fragment manager to start working with dynamic fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Indicate where and what fragment will be added
        fragmentTransaction.add(R.id.fragment_container, dinFragment).addToBackStack(null).commit();

       /*   Recycler View           */
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMateriasList = new ArrayList<>();

        parseMaterias();

    }

    private void parseMaterias(){

           String materia = "Android";
           String dia = "Martes";
           String horario = "6:00pm";

           mMateriasList.add(new Materias(materia, horario,dia));
           mAdapter = new Adapter(MainActivity.this, mMateriasList);
           mRecyclerView.setAdapter(mAdapter);

    }

}