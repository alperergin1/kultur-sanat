package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;


import android.app.AlertDialog;
import android.content.DialogInterface;



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
        EditText editText_nameSurName = findViewById(R.id.editText_nameSurname);
        EditText editText_username = findViewById(R.id.editText_username);
        EditText editText_password = findViewById(R.id.editText_password);

        String adSoyadSignup = editText_nameSurName.getText().toString();
        String kullaniciAdiSignup = editText_username.getText().toString();
        String sifreSignup = editText_password.getText().toString();

        TextView textView_signup_nameSurname = findViewById(R.id.textView_nameSurname);
        TextView textView_signup_username = findViewById(R.id.textView_username);
        TextView textView_signup_password = findViewById(R.id.textView_password);

        textView_signup_nameSurname.setText(getString(R.string.nameSurname_signup_textview) + " " + adSoyadSignup);
        textView_signup_username.setText(getString(R.string.username_signup_textview) + " " + kullaniciAdiSignup);
        textView_signup_password.setText(getString(R.string.password_signup_textview) + " " + sifreSignup);

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nameSurname", adSoyadSignup);
        editor.putString("username", kullaniciAdiSignup);
        editor.putString("password", sifreSignup);
        editor.apply();

        // AlertDialog oluştur
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Kayıt Başarılı");
        builder.setMessage("Kayıt işlemi başarıyla tamamlandı!");
        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Tamam butonuna tıklanınca yapılacak işlemler
                startLoginActivity();
            }
        });

        // AlertDialog'u göster
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void startLoginActivity() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Bu aktiviteyi kapat
    }
}
