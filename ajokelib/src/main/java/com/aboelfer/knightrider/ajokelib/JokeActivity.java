package com.aboelfer.knightrider.ajokelib;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {


    public String loadedJoke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView textView = findViewById(R.id.textView);
        String receivedJoke;

        Intent intent = getIntent();
        if (intent != null){

            receivedJoke = intent.getStringExtra(getString(R.string.JOKE_KEY));
            textView.setText(receivedJoke);

        }
    }

}
