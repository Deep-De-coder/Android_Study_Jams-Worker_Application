package com.example.workersapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT =3000;

    RelativeLayout logo;
    Animation logo_animate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.homered));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.homered));
        setContentView(R.layout.activity_splash_screen);

        logo = findViewById(R.id.logo);

        logo_animate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.middle_animation);
        logo.setAnimation(logo_animate);

        //Splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(logo,"logo_image");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this,pairs);
                startActivity(intent,options.toBundle());

            }
        },SPLASH_TIME_OUT);
    }
}