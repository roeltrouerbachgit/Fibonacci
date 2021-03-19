package com.example.fibonacci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    private lateinit var tvDisplayQuiz: TextView
    private lateinit var etNumber: EditText
    private lateinit var btnSubmit: Button
    private lateinit var ivFeedback: ImageView

    private val fibonacciSeq = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181)
    private var displayString = mutableListOf(0, 1, 1)
    private var currentIndex: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        tvDisplayQuiz = findViewById(R.id.tvDisplayQuiz)
        etNumber = findViewById(R.id.etNumber)
        btnSubmit = findViewById(R.id.btnSubmit)
        ivFeedback = findViewById(R.id.ivFeedback)

        btnSubmit.setOnClickListener { submitAnswer() }

    }

    private fun submitAnswer() {
        checkAnswer()
    }

    private fun nextNumber() {
        displayString.add(fibonacciSeq[currentIndex])
        tvDisplayQuiz.text = displayString.toString().replace("[", "").replace("]", "")
        currentIndex += 1
    }

    private fun checkAnswer() {

        var input: Int = 0

        try{
            input = etNumber.text.toString().toInt()
        } catch(ex: NumberFormatException) {
            Log.i("Input", ex.toString())
        }

        if(input == fibonacciSeq[currentIndex]) {
            if(currentIndex == fibonacciSeq.size - 1) {
                val intent: Intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            } else {
                ivFeedback.setImageResource(R.drawable.check)
                nextNumber()
            }
        } else {
            ivFeedback.setImageResource(R.drawable.remove)
        }

        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                ivFeedback.visibility = View.VISIBLE
            }
            override fun onFinish() {
                ivFeedback.visibility = View.INVISIBLE
            }
        }
        timer.start()

    }
}