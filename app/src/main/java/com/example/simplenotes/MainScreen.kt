package com.example.simplenotes

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView
import android.widget.LinearLayout;
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_screen) //holds the UI

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val menuIcon = findViewById<ImageView>(R.id.menuIcon)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        val username = intent.getStringExtra("username_key")
        Toast.makeText(this, "Hello $username", Toast.LENGTH_SHORT).show()



        navigationView.setNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.logout_navigation -> {
                    startActivity(Intent(this, LoginScreen::class.java))
                }

                R.id.splash_screen -> {
                    startActivity(Intent(this, SplashScreen::class.java))
                    finish()
                }
            }

            true
        }

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.END)
        }



    }
}