package com.example.mcqquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ImageView logo=findViewById(R.id.splash_logo);
        Animation fadeIn= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        logo.startAnimation(fadeIn);
        new Handler().postDelayed(()->{
            Intent i=new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        },3000);
    }
}