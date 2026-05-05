package com.example.simplenotes.screens.splash_screen

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.simplenotes.screens.login_screen.LoginScreen
import com.example.simplenotes.R

class SplashScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_screen) //holds the UI

        val layout = findViewById<LinearLayout>(R.id.splashLayout)  // ID of the whole UI

        layout.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            finish()
        }
    }
}