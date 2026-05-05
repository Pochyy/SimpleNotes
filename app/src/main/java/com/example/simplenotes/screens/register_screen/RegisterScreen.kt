package com.example.simplenotes.screens.register_screen

import RegisterModel
import RegisterPresenter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplenotes.screens.login_screen.LoginScreen
import com.example.simplenotes.R
import com.example.simplenotes.app.CustomApp

// --- imported KotlinExt from utils package ---
import com.example.simplenotes.utils.getEditTextValue
import com.example.simplenotes.utils.makeToastMessage

class RegisterScreen : AppCompatActivity(), RegisterContract.View {

    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)

        presenter = RegisterPresenter(this, RegisterModel(application as CustomApp))

        val registerBtn = findViewById<Button>(R.id.registerButton)

        registerBtn.setOnClickListener {

            val name = getEditTextValue(R.id.fullNameInput)
            val email = getEditTextValue(R.id.emailInput)
            val password = getEditTextValue(R.id.passwordInput)
            val confirm = getEditTextValue(R.id.confirmPasswordInput)

            presenter.register(name, email, password, confirm)
        }
    }

    override fun showMessage(message: String) {
        makeToastMessage(message)
    }

    override fun navigateToLogin() {
        startActivity(Intent(this, LoginScreen::class.java))
        finish()
    }
}
