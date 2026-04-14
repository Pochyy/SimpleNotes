package com.example.simplenotes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)

        val bckToLoginbtn = findViewById<TextView>(R.id.backToLogin)
        val rgsterbtn = findViewById<Button>(R.id.registerButton)

        rgsterbtn.setOnClickListener{
            startActivity(Intent(this,LoginScreen::class.java))
        }

        bckToLoginbtn.setOnClickListener{
            startActivity(Intent(this,LoginScreen::class.java))
        }
    }
}