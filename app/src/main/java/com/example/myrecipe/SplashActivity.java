package com.example.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Delay and navigate to MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After the splash screen, navigate to MainActivity
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish SplashActivity so user can't go back to it
            }
        }, SPLASH_TIME_OUT);
    }
}
