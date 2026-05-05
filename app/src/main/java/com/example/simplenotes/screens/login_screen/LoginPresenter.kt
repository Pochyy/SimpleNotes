package com.example.simplenotes.screens.login_screen

import android.content.Intent
import com.example.simplenotes.screens.main_screen.MainScreen

class LoginPresenter(
    var view: LoginContract.View,
    val model: LoginModel
): LoginContract.Presenter {

    override fun login(email: String, password: String, savedEmail: String, savedPassword: String) {
            val isValid = model.validateCredentials(email,password,savedEmail,savedPassword)

        if (isValid) {
            view.navigateToMain(email)
        } else {
            view.showInvalidCredentialsMessage()
        }
    }


}