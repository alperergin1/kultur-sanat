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

        findViewById(R.id.button_film1_seans1e_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMovieSeatsActivity();
            }
        });

        findViewById(R.id.button_film1_seans1e_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMovieSeatsActivity();
            }
        });

        findViewById(R.id.button_film1_seans2ye_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMovieSeatsActivity();
            }
        });

        findViewById(R.id.button_film2_seans1e_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMovieSeatsActivity();
            }
        });

        findViewById(R.id.button_film2_seans2ye_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMovieSeatsActivity();
            }
        });
     }

    private void startMovieSeatsActivity() {
        Intent intent = new Intent(CinemaActivity.this, MovieSeatsActivity.class);
        startActivity(intent);
    }
}