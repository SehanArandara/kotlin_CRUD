package com.example.login.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.login.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val registerText : TextView = findViewById(R.id.textView2_login)

        registerText.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        val loginBtn : Button = findViewById(R.id.logIn_btn)
        loginBtn.setOnClickListener {
            performLog()
        }
    }

    private fun performLog(){
       val Email : EditText = findViewById(R.id.editTextTextPersonName4)
       val PassWord : EditText = findViewById(R.id.editTextTextPersonName2)

        if (Email.text.isEmpty() || PassWord.text.isEmpty()){
            Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT)
                .show()
            return
        }

        val emailInput = Email.text.toString()
        val passWordInput = PassWord.text.toString()

        auth.signInWithEmailAndPassword(emailInput,passWordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, and navigate to the main activity

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        baseContext,
                        "Success .",
                        Toast.LENGTH_SHORT,
                    ).show()

                } else {
                    // If sign in fails, display a message to the user.
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)


                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(
                    baseContext,
                    "Authentication failed.${it.localizedMessage}",
                    Toast.LENGTH_SHORT,
                ).show()
            }


    }
}