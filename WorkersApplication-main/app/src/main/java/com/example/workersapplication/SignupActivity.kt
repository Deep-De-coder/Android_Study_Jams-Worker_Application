package com.example.workersapplication;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.workersapplication.viewmodels.WorkersViewModel

class SignupActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //setupActionBarWithNavController(findNavController(R.id.fragmentContainerViewUser))
    }
}