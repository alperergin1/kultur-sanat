package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MovieSeatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_seats);
    }

        public void seatClicked(View view){
            Button seatButton = (Button) view;
            String selectedSeat = seatButton.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("selectedSeat", selectedSeat);
            editor.apply();

            Intent intent = new Intent(MovieSeatsActivity.this, SummaryAndConfirmationActivity.class);
            startActivity(intent);
        }
    }

