package com.example.parcialuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyChange extends AppCompatActivity {


    private EditText mTipoCambio;
    private EditText mCantidad;
    private Button mBtnCalcular;
    private TextView mTextViewDolares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_change);

        mTipoCambio = findViewById(R.id.EditTextTipoCambio);
        mCantidad = findViewById(R.id.EditTextCantidad);
        mBtnCalcular = findViewById(R.id.ButtonCalcular);
        mTextViewDolares = findViewById(R.id.TextViewDolares);


        mBtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tipoCambio= Integer.valueOf(String.valueOf(mTipoCambio.getText()));
                int cantidad = Integer.valueOf(String.valueOf(mCantidad.getText()));
                int dolares = cantidad / tipoCambio;
                mTextViewDolares.setText(Integer.toString(dolares));
            }
        });


    }
}