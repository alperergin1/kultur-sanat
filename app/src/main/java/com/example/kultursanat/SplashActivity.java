package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 1100; // Bekleme süresi (ms)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean x=loginOlmusMu();
                if (x){
                    startMainActivity();
                }
                else {
                    startLoginActivity();
                }

                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    private void startLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    private void startMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);

        startActivity(intent);
    }

    public boolean loginOlmusMu() {
        boolean loginOlundu=false;


        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");

        Intent intent = new Intent(SplashActivity.this, SplashActivity.class);
        intent.putExtra("username", savedUsername);
        intent.putExtra("password", savedPassword);

        if (savedUsername!="" && savedPassword!=""){
            loginOlundu=true;
        }
        return loginOlundu;

    }

}