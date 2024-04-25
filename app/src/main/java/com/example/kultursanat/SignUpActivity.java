package com.example.kultursanat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

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

        String nameSurname = editText_nameSurName.getText().toString();
        String username = editText_username.getText().toString();
        String password = editText_password.getText().toString();

        if (!nameSurname.isEmpty() && !username.isEmpty() && !password.isEmpty()) {

            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            String keyNameSurname = "nameSurname_" + username;
            String keyPassword = "password_" + username;

            editor.putString(keyNameSurname, nameSurname);
            editor.putString(keyPassword, password);
            editor.apply();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Kayıt Başarılı");
            builder.setMessage("Kayıt işlemi başarıyla tamamlandı!");
            builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startLoginActivity();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Hata");
            builder.setMessage("Lütfen tüm alanları doldurunuz!");
            builder.setPositiveButton("Tamam", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    private void startLoginActivity() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
