package com.example.canteenapp
// package com.google.firebase.quickstart.auth.kotlin

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.util.*
import com.google.firebase.database.*

import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class CartActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)

        auth = Firebase.auth
        val currentUser = auth.getCurrentUser();

        var mp = intent.getStringExtra("allSelectedItems")

        val bundle = intent.extras
        val value = bundle!!.getSerializable("allSelectedItems")

        Toast.makeText(baseContext,"cart-page $value" , Toast.LENGTH_SHORT).show()
    }
}