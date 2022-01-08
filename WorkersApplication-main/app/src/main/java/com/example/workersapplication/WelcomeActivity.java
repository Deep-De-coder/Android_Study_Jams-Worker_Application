package com.example.workersapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class WelcomeActivity extends AppCompatActivity {

    RelativeLayout user_btn,workers_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.homered));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.homered));
        setContentView(R.layout.activity_welcome);

        user_btn = findViewById(R.id.user_btn);
        workers_btn = findViewById(R.id.workers_btn);

        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),KotMainActivity.class);
                startActivity(intent);
            }
        });
        workers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });

    }


}