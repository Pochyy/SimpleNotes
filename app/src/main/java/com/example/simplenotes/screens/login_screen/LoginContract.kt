package com.example.simplenotes.screens.login_screen

class LoginContract {
    interface View{
        fun showInvalidCredentialsMessage()
        fun navigateToMain(email: String)
    }

    interface Presenter{
        fun login(email:String ,password: String,savedEmail :String , savedPassword : String)
    }

}