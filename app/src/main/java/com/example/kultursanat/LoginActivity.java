package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");


        EditText editText_username = findViewById(R.id.editText_username);
        EditText editText_password = findViewById(R.id.editText_password);
        editText_username.setText(savedUsername);
        editText_password.setText(savedPassword);
        findViewById(R.id.button_maine_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });

        findViewById(R.id.button_login_yap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_yap();
            }
        });



    }

    private void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void login_yap() {

    }

}