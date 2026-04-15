package com.example.simplenotes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)

        val bckToLoginbtn = findViewById<TextView>(R.id.backToLogin)
        val rgsterbtn = findViewById<Button>(R.id.registerButton)

        val fullNameInput = findViewById<EditText>(R.id.fullNameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val confirmPassword = findViewById<EditText>(R.id.confirmPasswordInput)




        rgsterbtn.setOnClickListener{

            val name = fullNameInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val passwordConfirm = confirmPassword.text.toString()


            if(password == passwordConfirm){

                val sharedPref = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                val editor = sharedPref.edit()

                editor.putString("name", name)
                editor.putString("email", email)
                editor.putString("password", password)

                editor.apply()

                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this,LoginScreen::class.java))
                finish()

            } else {
                Toast.makeText(this, "Password mismatch!", Toast.LENGTH_SHORT).show()
            }


        }

        bckToLoginbtn.setOnClickListener{
            startActivity(Intent(this,LoginScreen::class.java))
        }
    }
}