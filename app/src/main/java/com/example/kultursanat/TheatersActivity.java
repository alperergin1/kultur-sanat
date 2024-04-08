package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TheatersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theaters);
        findViewById(R.id.button_tiyatro_koltuk_secmeye_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTheatreSeatsActivity();
            }
        });
    }

    private void startTheatreSeatsActivity() {
        Intent intent = new Intent(TheatersActivity.this, TheatreSeatsActivity.class);
        startActivity(intent);
    }
}