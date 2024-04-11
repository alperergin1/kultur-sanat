package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryAndConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_and_confirmation);

        // Intent'ten verileri al
        Intent intent = getIntent();
        String selectedSeans = intent.getStringExtra("selectedSeans");
        String selectedSeat = intent.getStringExtra("selectedSeat");
        String kullaniciAdiSignup = intent.getStringExtra("username");

        // TextView'ları bul
        TextView textView_signup_username = findViewById(R.id.textView_show_user);
        TextView textViewMovie = findViewById(R.id.textView_show_movie);
        TextView textViewSeat = findViewById(R.id.textView_show_seat);

        // TextView'lara verileri yazdır
        textView_signup_username.setText(getString(R.string.show_user, kullaniciAdiSignup));
        textViewMovie.setText(getString(R.string.show_movie, selectedSeans));
        textViewSeat.setText(getString(R.string.show_seat, selectedSeat));

        findViewById(R.id.button_maine_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
    }
    private void startMainActivity() {
        Intent intent = new Intent(SummaryAndConfirmationActivity.this, MainActivity.class);
        startActivity(intent);
    }
}