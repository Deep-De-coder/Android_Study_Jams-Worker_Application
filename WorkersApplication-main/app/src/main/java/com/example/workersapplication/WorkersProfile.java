package com.example.workersapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class WorkersProfile extends AppCompatActivity {

    String wname,wlocation,wprice,wage,wexperience;

    TextView nametv,locationtv,pricetv,agetv,experiencetv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.homered));
        setContentView(R.layout.activity_worker_profile);


        wname = getIntent().getStringExtra("wname");
        wlocation = getIntent().getStringExtra("waddress");
        wprice = getIntent().getStringExtra("wprice");
        wage = getIntent().getStringExtra("wage");
        wexperience = getIntent().getStringExtra("wexp");

        nametv = findViewById(R.id.nametv);
        locationtv = findViewById(R.id.locationtv);
        pricetv = findViewById(R.id.pricetv);
        agetv = findViewById(R.id.agetv);
        experiencetv = findViewById(R.id.experiencetv);

        nametv.setText(wname);
        locationtv.setText(wlocation);
        pricetv.setText(wprice);
        agetv.setText(wage);
        experiencetv.setText(wexperience);

    }
}