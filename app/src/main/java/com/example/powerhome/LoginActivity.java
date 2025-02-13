package com.example.powerhome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        // Récupération des données envoyées par Intent
        Intent intent = getIntent();
        if (intent != null) {
            String email = intent.getStringExtra("email");
            String password = intent.getStringExtra("password");

            if (email != null) editTextEmail.setText(email);
            if (password != null) editTextPassword.setText(password);
        }
        Button b = (Button) findViewById(R.id.btn_login);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LoginActivity.this, HomeActivity.class);
                if (!editTextEmail.getText().toString().equals(intent.getStringExtra("email")) || !editTextPassword.getText().toString().equals(intent.getStringExtra("password")) ) {
                    editTextEmail.setText("");
                    editTextPassword.setText("");

                }else{
                    String email = editTextEmail.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();
                    intent2.putExtra("email",email);
                    intent2.putExtra("password",password);
                    startActivity(intent2);
                }
            }
        });




    }
}