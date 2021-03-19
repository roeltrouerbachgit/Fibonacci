package com.example.fibonacci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var btnFibonacci: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFibonacci = findViewById(R.id.btnFibonacci)

        btnFibonacci.setOnClickListener {

            val intent: Intent = Intent(this, FibonacciNumbersActivity::class.java)
            startActivity(intent)
        }

    }




}