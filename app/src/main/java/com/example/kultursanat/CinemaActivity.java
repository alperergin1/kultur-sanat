package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CinemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        findViewById(R.id.button_film_saatlerine_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMovieTimesActivity();
            }
        });
    }
    private void startMovieTimesActivity() {
        Intent intent = new Intent(CinemaActivity.this, MovieTimesActivity.class);
        startActivity(intent);
    }
}