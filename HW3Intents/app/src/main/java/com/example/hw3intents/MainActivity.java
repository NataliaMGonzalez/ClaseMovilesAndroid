package com.example.hw3intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.hw3intents.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    public static int counter = 0;
    private Button mBtnSayHello;
    private Button mBtnCount;
    private TextView mTextViewCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSayHello = findViewById(R.id.BtnSayHello);
        mBtnCount = findViewById(R.id.BtnCount);
        mTextViewCounter = findViewById(R.id.TextViewCount);
        mTextViewCounter.setText(String.valueOf(counter));

        mBtnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                mTextViewCounter.setText(String.valueOf(counter));
            }
        });
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = String.valueOf(counter);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                counter = parseInt(reply);
                mTextViewCounter.setText(reply);

            }
        }
    }

}