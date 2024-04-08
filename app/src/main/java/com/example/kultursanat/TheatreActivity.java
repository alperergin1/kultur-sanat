package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TheatreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre);

        findViewById(R.id.button_tiyatrolara_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTheatresActivity();
            }
        });
    }

    private void startTheatresActivity() {
        Intent intent = new Intent(TheatreActivity.this, TheatersActivity.class);
        startActivity(intent);
    }
}