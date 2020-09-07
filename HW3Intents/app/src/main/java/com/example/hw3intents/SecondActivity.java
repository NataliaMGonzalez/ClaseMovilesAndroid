package com.example.hw3intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.hw3intents.extra.REPLY";

    private TextView mTextViewCounter;
    private EditText mEditTextNewValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTextViewCounter = findViewById(R.id.TextViewCountHello);
        mEditTextNewValue = findViewById(R.id.EditTextNewValue);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mTextViewCounter.setText(String.valueOf(message));

    }

    // Back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:

                String newCounter = mEditTextNewValue.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, newCounter);
                setResult(RESULT_OK, replyIntent);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        String newCounter = mEditTextNewValue.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,newCounter);
        setResult(RESULT_OK,replyIntent);
        finish();
    }

}