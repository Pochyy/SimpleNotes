package com.example.simplenotes.app

import android.app.Application
import android.util.Log

class CustomApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.e("CustomApp", "Application started")
    }
}