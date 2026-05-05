package com.example.simplenotes.screens.main_screen

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.simplenotes.R
import com.example.simplenotes.screens.login_screen.LoginScreen
import com.example.simplenotes.screens.splash_screen.SplashScreen
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

                    val sharedPref = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                    val editor = sharedPref.edit()

                    editor.clear()
                    editor.apply()

                    startActivity(Intent(this, LoginScreen::class.java))
                    finish()
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