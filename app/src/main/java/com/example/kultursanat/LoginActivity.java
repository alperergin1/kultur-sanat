package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        EditText editText_username = findViewById(R.id.editText_username);
        EditText editText_password = findViewById(R.id.editText_password);
        String kullaniciAdi = editText_username.getText().toString();
        String sifre = editText_password.getText().toString();

        TextView textView_username = findViewById(R.id.textView_username);
        TextView textView_password = findViewById(R.id.textView_password);
        textView_username.setText("Kullanıcı Adı: " + kullaniciAdi);
        textView_password.setText("Şifre: " + sifre);
    }

}