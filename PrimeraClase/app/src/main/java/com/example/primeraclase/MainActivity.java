package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.buttonExample);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cuantos = 0;
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context,"Hiciste click: ",Toast.LENGTH_SHORT);
                toast.show();
                cuantos++;

            }
        });

    }


}