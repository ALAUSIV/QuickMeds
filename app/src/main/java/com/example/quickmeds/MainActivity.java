package com.example.quickmeds;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIME = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView splashText = findViewById(R.id.splashText);
        splashText.setAlpha(0f);
        splashText.animate().alpha(1f).setDuration(1000).withEndAction(() ->
                new Handler().postDelayed(() -> {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }, 1000)
        ).start();
    }
}
