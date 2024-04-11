package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CinemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);
    }

    public void seansClicked(View view) {
        Button seansButton = (Button) view;
        String selectedSeans = seansButton.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("selectedSeans", selectedSeans);
        editor.apply();

        Intent intent = new Intent(CinemaActivity.this, MovieSeatsActivity.class);
        intent.putExtra("selectedSeans", selectedSeans);
        startActivity(intent);
    }
}
