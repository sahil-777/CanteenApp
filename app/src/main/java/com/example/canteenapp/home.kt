package com.example.canteenapp

// package com.google.firebase.quickstart.auth.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.util.*
import com.google.firebase.database.*

import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.Intent

class HomeActivity : AppCompatActivity() {
    private
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        auth = Firebase.auth
        Toast.makeText(baseContext, "Home page", Toast.LENGTH_SHORT).show()
    }
}