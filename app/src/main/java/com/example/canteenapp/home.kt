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
    private lateinit var auth: FirebaseAuth
    // private var allSelectedItems: HashMap<String, List<String>> = hashMapOf()
    // private var allSelectedItems = mutableMapOf<String,Int>()
    private var allSelectedItems: HashMap<String, Int> = hashMapOf()

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
                val key = findViewById<TextView>(R.id.friedRiceText).text.toString();
                allSelectedItems[key] = (allSelectedItems[key] ?: 0) + 1
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
                val key = findViewById<TextView>(R.id.friedRiceText).text.toString();
                allSelectedItems[key] = (allSelectedItems[key] ?: 0) - 1
            }
            // Toast.makeText(baseContext, "$num", Toast.LENGTH_SHORT).show()
            viewQuantity.text=num.toString()
            cartTotalItems.text=cartNum.toString()
        }

        //----------------------------------
        val addBiryaniButton = findViewById<Button>(R.id.biryaniAdd)
        addBiryaniButton.setOnClickListener() {
            var viewQuantity = findViewById<TextView>(R.id.biryaniQuantity)
            var cartTotalItems = findViewById<TextView>(R.id.cart)
            var num=viewQuantity.text.toString().toInt()
            var cartNum = cartTotalItems.text.toString().toInt()

            if(num<4){
                num++;
                cartNum++;
                val key = findViewById<TextView>(R.id.biryaniText).text.toString();
                allSelectedItems[key] = (allSelectedItems[key] ?: 0) + 1
            }
            // Toast.makeText(baseContext, "$num", Toast.LENGTH_SHORT).show()
            viewQuantity.text=num.toString()
            cartTotalItems.text=cartNum.toString()
        }

        val removeBiryaniButton = findViewById<Button>(R.id.biryaniRemove)
        removeBiryaniButton.setOnClickListener() {
            var viewQuantity = findViewById<TextView>(R.id.biryaniQuantity)
            var cartTotalItems = findViewById<TextView>(R.id.cart)
            var num=viewQuantity.text.toString().toInt()
            var cartNum = cartTotalItems.text.toString().toInt()

            if(num>0){
                num--;
                cartNum--;
                val key = findViewById<TextView>(R.id.biryaniText).text.toString();
                allSelectedItems[key] = (allSelectedItems[key] ?: 0) - 1
            }
            // Toast.makeText(baseContext, "$num", Toast.LENGTH_SHORT).show()
            viewQuantity.text=num.toString()
            cartTotalItems.text=cartNum.toString()
        }

        val cart=findViewById<Button>(R.id.cart)
        cart.setOnClickListener(){
            val I = Intent(this, CartActivity::class.java)
            I.putExtra("allSelectedItems",allSelectedItems)
            startActivity(I)
        }
    }

}
