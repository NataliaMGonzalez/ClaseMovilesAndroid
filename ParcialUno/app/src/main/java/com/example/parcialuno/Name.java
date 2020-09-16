package com.example.parcialuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Name extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.ParcialUno.extra.REPLY";

    String newName;
    private Button mButtonChangeName;
    private EditText mEditTextNewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mButtonChangeName = findViewById(R.id.ButtonChangeName);
        mEditTextNewName = findViewById(R.id.EditTextNewName);

        Intent intent = getIntent();
        // String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

       // mEditTextNewName.setText(String.valueOf(message));

        mButtonChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newName = mEditTextNewName.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY,newName);
                setResult(RESULT_OK,replyIntent);
                finish();

            }
        });
    }

/*
    @Override
    public void onBackPressed() {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,newName);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
*/

}