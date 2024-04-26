package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MovieSeatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_seats);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String[] selectedSeats = sharedPreferences.getString("selectedSeats", "").split(",");
        Button[] seatButtons = new Button[9];
        seatButtons[0] = findViewById(R.id.button_film_koltuk_1);
        seatButtons[1] = findViewById(R.id.button_film_koltuk_2);
        seatButtons[2] = findViewById(R.id.button_film_koltuk_3);
        seatButtons[3] = findViewById(R.id.button_film_koltuk_4);
        seatButtons[4] = findViewById(R.id.button_film_koltuk_5);
        seatButtons[5] = findViewById(R.id.button_film_koltuk_6);
        seatButtons[6] = findViewById(R.id.button_film_koltuk_7);
        seatButtons[7] = findViewById(R.id.button_film_koltuk_8);
        seatButtons[8] = findViewById(R.id.button_film_koltuk_9);

        for (String seat : selectedSeats) {
            int seatIndex = Integer.parseInt(seat.trim()) - 1;
            if (seatIndex >= 0 && seatIndex < 9) {
                Button selectedButton = seatButtons[seatIndex];
                selectedButton.setEnabled(false);
                selectedButton.setTextColor(Color.GRAY);
            }
        }

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

