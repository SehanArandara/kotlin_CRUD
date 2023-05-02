package com.example.login.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.login.R

class MainActivity : AppCompatActivity() {

    private lateinit var insertBtn : Button
    private lateinit var fetchBtn : Button
    private lateinit var heheBtn :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertBtn = findViewById(R.id.insertBtn)
        fetchBtn  = findViewById(R.id.fetchBtn)
        heheBtn = findViewById(R.id.hehe)

        insertBtn.setOnClickListener {
            var intent = Intent(this, Insert::class.java)
            startActivity(intent)
        }

        fetchBtn.setOnClickListener {
            var intent = Intent(this, fetch::class.java)
            startActivity(intent)
        }

        heheBtn.setOnClickListener {
            var intent = Intent(this,employeeDetail::class.java)
            startActivity(intent)
        }






    }
}