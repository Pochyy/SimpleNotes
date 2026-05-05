package com.example.simplenotes.screens.login_screen

import com.example.simplenotes.app.CustomApp

class LoginModel (val app: CustomApp) {
    fun validateCredentials(savedEmail: String, savedPassword: String, email: String, password: String): Boolean {
        return email == savedEmail && password == savedPassword
    }

}