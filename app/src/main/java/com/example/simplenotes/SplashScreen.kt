package com.example.simplenotes

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

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