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


        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)




        loginBtn.setOnClickListener {

            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            val sharedPref = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)

            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)

            if (email == savedEmail && password == savedPassword) {

                val intent = Intent(this, MainScreen::class.java)
                intent.putExtra("username_key", email)

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)

            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }





        }

        registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterScreen::class.java))
        }
    }
}