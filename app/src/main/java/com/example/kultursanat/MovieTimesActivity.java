package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MovieTimesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_times);

        findViewById(R.id.button_koltuk_secmeye_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMovieSeatsActivity();
            }
        });
    }
    private void startMovieSeatsActivity() {
        Intent intent = new Intent(MovieTimesActivity.this, MovieSeatsActivity.class);
        startActivity(intent);
    }
}