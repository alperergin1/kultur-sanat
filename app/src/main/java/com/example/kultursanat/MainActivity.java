package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_sinemaya_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCinemaActivity();
            }
        });
    }

    private void startCinemaActivity() {
        Intent intent = new Intent(MainActivity.this, CinemaActivity.class);
        startActivity(intent);
    }
}