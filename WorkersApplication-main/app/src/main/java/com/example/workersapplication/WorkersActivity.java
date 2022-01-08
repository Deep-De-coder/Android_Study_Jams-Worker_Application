package com.example.workersapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.workersapplication.Adapters.WorkersListAdapter;
import com.example.workersapplication.Models.Workers;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class WorkersActivity extends AppCompatActivity {

    ImageView menu_btn;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    RecyclerView workers_list;
    ArrayList<Workers> list;
    WorkersListAdapter workersListAdapter;
    TextView op1,op2,op3,op4;
    int op_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.homered));
        setContentView(R.layout.activity_workers);

        menu_btn = findViewById(R.id.workers_menubtn);

        drawerLayout = findViewById(R.id.workers_drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        workers_list = findViewById(R.id.workers_list);

        op_select = 1;

        op1 = findViewById(R.id.new_btn);
        op2 = findViewById(R.id.recommended_btn);
        op3 = findViewById(R.id.nearby_btn);
        op4 = findViewById(R.id.toprated_btn);

        op1.setBackgroundResource(R.drawable.workers_category_btn_select);
        op2.setBackgroundResource(R.drawable.workers_category_btn_unselect);
        op3.setBackgroundResource(R.drawable.workers_category_btn_unselect);
        op4.setBackgroundResource(R.drawable.workers_category_btn_unselect);
        op1.setTextColor(Color.WHITE);
        op2.setTextColor(getResources().getColor(R.color.greytext));
        op3.setTextColor(getResources().getColor(R.color.greytext));
        op4.setTextColor(getResources().getColor(R.color.greytext));


        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op_select != 1){
                    op_select = 1;
                    op1.setBackgroundResource(R.drawable.workers_category_btn_select);
                    op2.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op3.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op4.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op1.setTextColor(Color.WHITE);
                    op2.setTextColor(getResources().getColor(R.color.greytext));
                    op3.setTextColor(getResources().getColor(R.color.greytext));
                    op4.setTextColor(getResources().getColor(R.color.greytext));

                }
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op_select != 2){
                    op_select = 2;
                    op1.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op2.setBackgroundResource(R.drawable.workers_category_btn_select);
                    op3.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op4.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op2.setTextColor(Color.WHITE);
                    op1.setTextColor(getResources().getColor(R.color.greytext));
                    op3.setTextColor(getResources().getColor(R.color.greytext));
                    op4.setTextColor(getResources().getColor(R.color.greytext));

                }
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op_select != 3){
                    op_select = 3;
                    op1.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op2.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op3.setBackgroundResource(R.drawable.workers_category_btn_select);
                    op4.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op3.setTextColor(Color.WHITE);
                    op2.setTextColor(getResources().getColor(R.color.greytext));
                    op1.setTextColor(getResources().getColor(R.color.greytext));
                    op4.setTextColor(getResources().getColor(R.color.greytext));

                }
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op_select != 4){
                    op_select = 4;
                    op1.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op2.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op3.setBackgroundResource(R.drawable.workers_category_btn_unselect);
                    op4.setBackgroundResource(R.drawable.workers_category_btn_select);
                    op4.setTextColor(Color.WHITE);
                    op2.setTextColor(getResources().getColor(R.color.greytext));
                    op3.setTextColor(getResources().getColor(R.color.greytext));
                    op1.setTextColor(getResources().getColor(R.color.greytext));

                }
            }
        });

        drawerLayout.closeDrawer(Gravity.LEFT);

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent = new Intent(getApplicationContext(),KotMainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.aboutus:
                        Intent intent1 = new Intent(getApplicationContext(),KotAboutUs.class);
                        startActivity(intent1);
                        break;

                    case R.id.settings:
                        Intent intent2 = new Intent(getApplicationContext(),KotSettingsActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.profile:
                        Intent intent3 = new Intent(getApplicationContext(),KotUserProfileActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

        list = new ArrayList<>();
        list.add(new Workers("Jerome Bell","Dadar, Mumbai","₹ 2500/Mon","4.50",R.drawable.dummy1));
        list.add(new Workers("Jane Copper","Vikhroli, Mumbai","₹ 1200/Mon","3.67",R.drawable.dummy2));
        list.add(new Workers("Austin Moreen","Hazrat, Delhi","₹ 1980/Mon","4.25",R.drawable.dummy3));

        workersListAdapter = new WorkersListAdapter(list);
        workers_list.setAdapter(workersListAdapter);


    }
}