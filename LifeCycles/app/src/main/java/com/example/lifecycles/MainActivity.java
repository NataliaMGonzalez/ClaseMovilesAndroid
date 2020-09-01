package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StateChange";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText fahDeg;
        Button convertButton;
        final TextView result;
        int ans=0;

        // by ID we can use each component which id is assign in xml file
        fahDeg=(EditText) findViewById(R.id.editTextFah);
        convertButton=(Button) findViewById(R.id.convertButton);
        result = (TextView) findViewById(R.id.textViewCelsius);

        // Add_button add clicklistener
        convertButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // fahDeg double type
                // get data which is in edittext, convert it to string
                // using parse Double convert it to Double type
                double dFah = Double.parseDouble(fahDeg.getText().toString());
                //(32 °F − 32) × 5/9 = 0 °C
                double fahToCel = (dFah - 32) * 5 / 9;
                // set it to result textview
                result.setText(Double.toString(fahToCel) + "°C" );
            }
        });
    }
}
