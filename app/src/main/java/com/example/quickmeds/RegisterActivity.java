package com.example.quickmeds;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {

    EditText fullNameInput, emailInput, passwordInput;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullNameInput = findViewById(R.id.fullNameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(v -> {
            String name = fullNameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String entry = name + "," + email + "," + password + "\n";

            try {
                // saves to internal storage
                FileOutputStream fos = openFileOutput("users.txt", MODE_APPEND);
                fos.write(entry.getBytes());
                fos.close();

                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();

            } catch (Exception e) {
                Toast.makeText(this, "Error saving user", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }
}
