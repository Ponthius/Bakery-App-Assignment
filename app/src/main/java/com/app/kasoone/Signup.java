package com.app.kasoone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static String savedUsername = "";
    public static String savedPassword = "";

    public void createAccount(View view){

        EditText username = findViewById(R.id.etUsername);
        EditText password = findViewById(R.id.etPassword);
        EditText confirmPassword = findViewById(R.id.etConfirmPassword);

        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String confirm = confirmPassword.getText().toString().trim();

        if(user.isEmpty() || pass.isEmpty() || confirm.isEmpty()){
            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!pass.equals(confirm)){
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if(user.equals(savedUsername)){
            Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
            return;
        }

        savedUsername = user;
        savedPassword = pass;

        Toast.makeText(this, "Account successfully created", Toast.LENGTH_SHORT).show();
    }

    public void gotoLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}