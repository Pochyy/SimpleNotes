package com.example.simplenotes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        val registerBtn = findViewById<TextView>(R.id.loginToRegister)
        val loginBtn = findViewById<Button>(R.id.loginButton)
        val userNameEditText = findViewById<EditText>(R.id.username)

        loginBtn.setOnClickListener {

            val username = userNameEditText.text.toString()



            val intent = Intent(this, MainScreen::class.java)
            intent.putExtra("username_key", username)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }

        registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterScreen::class.java))
        }
    }
}