package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class ResultsActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)

        nameTextView = findViewById(R.id.name_tv)
        scoreTextView = findViewById(R.id.score_tv)
        finishButton = findViewById(R.id.finish_btn)

        nameTextView.text = intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        println("Result debug")
        println(nameTextView.text.toString())
        println(score)
        println(totalQuestions)

        scoreTextView.text = "Your score was $score out of $totalQuestions"

        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}