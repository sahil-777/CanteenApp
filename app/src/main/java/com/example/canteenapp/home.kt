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
import android.view.View

class HomeActivity : AppCompatActivity() {
    private
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        auth = Firebase.auth

        // Toast.makeText(baseContext, "Home page", Toast.LENGTH_SHORT).show()

        val addButton = findViewById<Button>(R.id.friedRiceAdd)
        addButton.setOnClickListener() {
            var viewQuantity = findViewById<TextView>(R.id.friedRiceQuantity)
            var cartTotalItems = findViewById<TextView>(R.id.cart)
            var num=viewQuantity.text.toString().toInt()
            var cartNum = cartTotalItems.text.toString().toInt()

            if(num<4){
                num++;
                cartNum++;
            }
            // Toast.makeText(baseContext, "$num", Toast.LENGTH_SHORT).show()
            viewQuantity.text=num.toString()
            cartTotalItems.text=cartNum.toString()
        }

        val removeButton = findViewById<Button>(R.id.friedRiceRemove)
        removeButton.setOnClickListener() {
            var viewQuantity = findViewById<TextView>(R.id.friedRiceQuantity)
            var cartTotalItems = findViewById<TextView>(R.id.cart)
            var num=viewQuantity.text.toString().toInt()
            var cartNum = cartTotalItems.text.toString().toInt()

            if(num>0){
                num--;
                cartNum--;
            }
            // Toast.makeText(baseContext, "$num", Toast.LENGTH_SHORT).show()
            viewQuantity.text=num.toString()
            cartTotalItems.text=cartNum.toString()
        }
    }
}