package com.example.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FibonacciNumbersActivity : AppCompatActivity() {

    private val numberRow = mutableListOf(0, 1)

    private lateinit var tvDisplay: TextView
    private lateinit var tvFN: TextView
    private lateinit var tvFN1: TextView
    private lateinit var tvFN2: TextView
    private lateinit var btnNext: Button
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci_numbers)

        tvDisplay = findViewById(R.id.tvDisplay)
        tvFN = findViewById(R.id.tvFN)
        tvFN1 = findViewById(R.id.tvFN1)
        tvFN2 = findViewById(R.id.tvFN2)
        btnNext = findViewById(R.id.btnNext)
        btnHome = findViewById(R.id.btnHome)

        btnNext.setOnClickListener { nextNumber() }
        btnHome.setOnClickListener { navigateToHome() }
    }

    private fun getFibonacci(): Int {
        val lastNumber: Int = numberRow.last()
        val secondToLastNumber: Int = numberRow[numberRow.size - 2]
        return lastNumber + secondToLastNumber
    }

    private fun nextNumber() {
        val newNumber: Int = getFibonacci()
        if(newNumber > 100000000) {
          btnNext.isEnabled = false
            Toast.makeText(this@FibonacciNumbersActivity, "This sequence can go on infinitely! Press Home to return to the Main Menu.", Toast.LENGTH_LONG).show()
            btnHome.visibility = View.VISIBLE
        } else {
            tvFN1.text =  numberRow.last().toString()
            tvFN2.text = numberRow[numberRow.size - 2].toString()
            numberRow.add(newNumber)
            tvFN.text = newNumber.toString()
            tvDisplay.text = numberRow.toString().replace("[", "").replace("]", "")
        }

    }

    private fun navigateToHome() {
      finish()
    }

}