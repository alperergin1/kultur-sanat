package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.button_maine_git).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
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
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
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
    }
}
