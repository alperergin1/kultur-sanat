package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryAndConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_and_confirmation);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String selectedSeans = sharedPreferences.getString("username", "");
        String selectedSeat = sharedPreferences.getString("username", "");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("savedUsername", savedUsername);
        editor.putString("selectedSeans", selectedSeans);
        editor.putString("selectedSeat", selectedSeat);
        editor.apply();

        TextView textView_signup_username = findViewById(R.id.textView_username);
        TextView textView_signup_password = findViewById(R.id.textView_password);
        TextView textView_signup_username = findViewById(R.id.textView_username);


        textView_show_user.setText(getString(R.string.username_signup_textview) + " " + savedUsername);
        textView_show_movie.setText(getString(R.string.password_signup_textview) + " " + selectedSeans);
        textView_show_seat.setText(getString(R.string.password_signup_textview) + " " + selectedSeat);

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