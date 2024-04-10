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

        findViewById(R.id.button_signup_yap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup_yap();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void login_yap() {

    }

    private void signup_yap() {
        EditText editText_username = findViewById(R.id.editText_username);
        EditText editText_password = findViewById(R.id.editText_password);
        String kullaniciAdiSignup = editText_username.getText().toString();
        String sifreSignup = editText_password.getText().toString();

        TextView textView_signup_username = findViewById(R.id.textView_username);
        TextView textView_signup_password = findViewById(R.id.textView_password);

        textView_signup_username.setText(getString(R.string.username_signup_textview) + " " + kullaniciAdiSignup);
        textView_signup_password.setText(getString(R.string.password_signup_textview) + " " + sifreSignup);

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", kullaniciAdiSignup);
        editor.putString("password", sifreSignup);
        editor.apply();
    }

}