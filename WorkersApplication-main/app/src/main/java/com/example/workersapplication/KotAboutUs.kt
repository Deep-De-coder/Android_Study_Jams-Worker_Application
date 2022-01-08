package com.example.workersapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.RelativeLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class KotAboutUs : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var navView: NavigationView
    private lateinit var menu_btn : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)


        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        menu_btn = findViewById(R.id.home_menu_btn)

        drawerLayout.closeDrawer(Gravity.LEFT);

        menu_btn.setOnClickListener{
            drawerLayout.openDrawer(Gravity.LEFT)
        }




        // Call findViewById on the NavigationView
        navView = findViewById(R.id.nav_view)

        // Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.aboutus -> {
                    drawerLayout.closeDrawer(Gravity.LEFT)
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this@KotAboutUs, KotUserProfileActivity::class.java)
                    intent.putExtra("key", "Kotlin")
                    startActivity(intent)
                    true
                }
                R.id.home -> {
                    val intent = Intent(this@KotAboutUs, KotMainActivity::class.java)
                    intent.putExtra("key", "Kotlin")
                    startActivity(intent)
                    true
                }
                R.id.workers -> {
                    val intent = Intent(this@KotAboutUs, KotWorkersActivity::class.java)
                    intent.putExtra("key", "Kotlin")
                    startActivity(intent)
                    true
                }
                R.id.settings -> {
                    val intent = Intent(this@KotAboutUs, KotSettingsActivity::class.java)
                    intent.putExtra("key", "Kotlin")
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}