// MainActivity.java
package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;

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

        findViewById(R.id.button_tiyatroya_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTheatreActivity();
            }
        });

        findViewById(R.id.button_profile_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProfileActivity();
            }
        });

        findViewById(R.id.button_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
    }

    private void startCinemaActivity() {
        Intent intent = new Intent(MainActivity.this, CinemaActivity.class);
        startActivity(intent);
    }

    private void startTheatreActivity() {
        Intent intent = new Intent(MainActivity.this, TheatersActivity.class);
        startActivity(intent);
    }

    private void startProfileActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void logoutUser() {
        // SharedPreferences'teki verileri silmeden oturumu sonlandır
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        // Geri tuşu için istediğiniz işlevi buraya ekleyebilirsiniz
    }
}
