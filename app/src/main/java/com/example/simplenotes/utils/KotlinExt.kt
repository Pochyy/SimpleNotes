package com.example.simplenotes.utils


import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


fun AppCompatActivity.getEditTextValue(id: Int): String{
        return findViewById<EditText>(id).text.toString()
}

fun AppCompatActivity.makeToastMessage(message : String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}