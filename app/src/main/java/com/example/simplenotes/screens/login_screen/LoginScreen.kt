package com.example.simplenotes.screens.login_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simplenotes.screens.main_screen.MainScreen
import com.example.simplenotes.R
import com.example.simplenotes.app.CustomApp
import com.example.simplenotes.screens.register_screen.RegisterScreen

// --- imported KotlinExt from utils package ---
import com.example.simplenotes.utils.getEditTextValue
import com.example.simplenotes.utils.makeToastMessage

class LoginScreen : AppCompatActivity(), LoginContract.View {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        loginPresenter = LoginPresenter(this, LoginModel(application as CustomApp))

        val registerBtn = findViewById<TextView>(R.id.loginToRegister)
        val loginBtn = findViewById<Button>(R.id.loginButton)


        // -- Keep variables for future use---
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)




        loginBtn.setOnClickListener {

            // --- Used the function from utils ---
            val email = getEditTextValue(R.id.emailInput)
            val password = getEditTextValue(R.id.passwordInput)

            val sharedPref = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)

            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)

            loginPresenter.login(email,password,savedEmail?: "",savedPassword?: "")

        }

        registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterScreen::class.java))
        }
    }



    override fun showInvalidCredentialsMessage() {
        makeToastMessage("Invalid credentials")
    }

    override fun navigateToMain(email: String) {
        val intent = Intent(this, MainScreen::class.java)
        intent.putExtra("username_key", email)

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
    }


}