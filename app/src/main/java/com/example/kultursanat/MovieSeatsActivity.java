package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MovieSeatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_seats);
        findViewById(R.id.button_film_koltuk_onay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSummaryAndConfirmationActivity();
            }
        });
    }

    private void startSummaryAndConfirmationActivity() {
        Intent intent = new Intent(MovieSeatsActivity.this, SummaryAndConfirmationActivity.class);
        startActivity(intent);
    }
}