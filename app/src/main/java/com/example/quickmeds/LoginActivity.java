package com.example.quickmeds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button loginButton;
    TextView registerLink, forgotPasswordLink;
    int failedAttempts = 0;

    private static final String TAG = "LoginDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink);

        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean success = false;

            try {
                FileInputStream fis = openFileInput("users.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String line;

                while ((line = reader.readLine()) != null) {
                    Log.d(TAG, "Read line: " + line);
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String savedEmail = parts[1].trim();
                        String savedPassword = parts[2].trim();
                        if (email.equals(savedEmail) && password.equals(savedPassword)) {
                            success = true;
                            break;
                        }
                    } else {
                        Log.w(TAG, "Skipped malformed line: " + line);
                    }
                }

                reader.close();
                fis.close();

            } catch (Exception e) {
                Log.e(TAG, "File read error: " + e.getMessage());
                e.printStackTrace();
                Toast.makeText(this, "Error reading file", Toast.LENGTH_SHORT).show();
                return;
            }

            if (success) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeHostActivity.class);
                startActivity(intent);
                finish();
            } else {
                failedAttempts++;
                Toast.makeText(this, "Login Failed (" + failedAttempts + ")", Toast.LENGTH_SHORT).show();
                if (failedAttempts >= 3) {
                    forgotPasswordLink.setVisibility(View.VISIBLE);
                }
            }
        });

        registerLink.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        forgotPasswordLink.setOnClickListener(v -> {
            startActivity(new Intent(this, ForgotPasswordActivity.class));
        });
    }
}
