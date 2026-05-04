package com.app.kasoone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gotoSignUp(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
        finish();
    }

    public void gotoProducts(View view){

        EditText username = findViewById(R.id.editTextText);
        EditText password = findViewById(R.id.editTextText2);

        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(user.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Empty fields or Invalid fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if(user.contains(" ")){
            Toast.makeText(this, "Empty fields or Invalid fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if(user.equals("Admin") && pass.equals("UVTAB321")){
            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Products.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
        }
    }
}