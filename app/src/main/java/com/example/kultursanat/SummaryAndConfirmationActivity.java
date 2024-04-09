package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SummaryAndConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_and_confirmation);

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