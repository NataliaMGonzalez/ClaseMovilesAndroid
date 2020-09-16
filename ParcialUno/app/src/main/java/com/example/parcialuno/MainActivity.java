package com.example.parcialuno;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "StateChanged";
    public int contEstados = 0;

    public static final String EXTRA_MESSAGE = "com.example.ParcialUno.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    public static String name = "Name";
    private TextView mTVCalculadora;
    private ImageView mImagenCalculadora;
    private TextView mTVMXaUSD;
    private ImageView mImageCoin;
    private TextView mCambiaNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contEstados++;
        Log.i(TAG, "onCreate " + contEstados);

        mTVCalculadora = findViewById(R.id.TextViewCalculadora);
        mImagenCalculadora = findViewById(R.id.imageCalculadora);
        mTVMXaUSD = findViewById(R.id.TExtViewMXaUSD);
        mImageCoin = findViewById(R.id.imageCurrency);
        mCambiaNombre = findViewById(R.id.TextViewCambiaNombre);

        mImagenCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Calculadora.class);
                startActivity(intent);

            }
        });

        mImageCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrencyChange.class);
                //startActivity(intent);

                startActivityForResult(intent, TEXT_REQUEST);

            }
        });

        mCambiaNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Name.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(Name.EXTRA_REPLY);
                name = reply;
                mCambiaNombre.setText(name);
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        contEstados++;
        Log.i(TAG, "onRestart " + contEstados);
    }

    @Override
    protected void onStart() {
        super.onStart();
        contEstados++;
        Log.i(TAG, "onStart " + contEstados);
    }

    @Override
    protected void onResume() {
        super.onResume();
        contEstados++;
        Log.i(TAG, "onResume " + contEstados);
    }

    @Override
    protected void onPause() {
        super.onPause();
        contEstados++;
        Log.i(TAG, "onPause " + contEstados);
    }

    @Override
    protected void onStop() {
        super.onStop();
        contEstados++;
        Log.i(TAG, "onStop " + contEstados);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contEstados++;
        Log.i(TAG, "onDestroy " + contEstados);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        contEstados++;
        Log.i(TAG, "onConfigurationChanged " + contEstados);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contEstados++;
        Log.i(TAG, "onRestoreInstanceState " + contEstados);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        contEstados++;
        Log.i(TAG, "onSaveInstanceState " + contEstados);
    }
}