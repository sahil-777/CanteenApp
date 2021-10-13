package com.example.canteenapp
// package com.google.firebase.quickstart.auth.kotlin

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.util.*
import com.google.firebase.database.*

import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {
    private
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        auth = Firebase.auth

        // signIn(email,password)

        val loginButton = findViewById<Button>(R.id.login_btn)
        loginButton.setOnClickListener() {
            var email  = findViewById<EditText>(R.id.login_email).text.toString()
            var password  = findViewById<EditText>(R.id.login_password).text.toString()
            if(email.isBlank() || password.isBlank()){
                Toast.makeText(baseContext, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
            else {
                signIn(email, password)
            }
        }
    }


    private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        // Toast.makeText(baseContext, "Data : $email $password", Toast.LENGTH_SHORT).show()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    // Toast.makeText(baseContext, "Successful : $email $password", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    // Toast.makeText(baseContext, "Failed : $email $password", Toast.LENGTH_SHORT).show()
                }
            }
        // [END sign_in_with_email]
    }
}