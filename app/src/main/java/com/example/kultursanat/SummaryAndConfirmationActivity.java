package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class SummaryAndConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_and_confirmation);

        TextView textView_show_user = findViewById(R.id.textView_show_user);
        TextView textView_show_movie = findViewById(R.id.textView_show_movie);
        TextView textView_show_seat = findViewById(R.id.textView_show_seat);

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String selectedSeans = sharedPreferences.getString("selectedSeans", "");
        String selectedSeat = sharedPreferences.getString("selectedSeat", "");

        textView_show_user.setText(getString(R.string.username_summary_textview) + " " + savedUsername);
        textView_show_movie.setText(getString(R.string.movie_summary_textview) + " " + selectedSeans);
        textView_show_seat.setText(getString(R.string.seat_summary_textview) + " " + selectedSeat);

        findViewById(R.id.button_maine_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData(); // Kayıt işlemini gerçekleştir
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(SummaryAndConfirmationActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void saveUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String selectedSeans = sharedPreferences.getString("selectedSeans", "");
        String selectedSeat = sharedPreferences.getString("selectedSeat", "");

        String[] selectedSeats = sharedPreferences.getString("selectedSeats", "").split(",");

        String selectedSeatsKayit = "";
        selectedSeatsKayit = selectedSeatsKayit + selectedSeat;

        for (String seat : selectedSeats) {
            selectedSeatsKayit = selectedSeatsKayit + "," + seat;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("savedUsername", savedUsername);
        editor.putString("selectedSeans", selectedSeans);
        editor.putString("selectedSeat", selectedSeat);
        editor.putString("selectedSeats", selectedSeatsKayit);
        editor.apply();
    }

}