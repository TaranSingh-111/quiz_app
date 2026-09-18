package com.example.quizapp.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants
import androidx.core.graphics.toColorInt

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var questionTextView: TextView
    private lateinit var flagImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var progressTextView: TextView

    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView

    private lateinit var checkButton: Button

    private lateinit var questionsList: MutableList<Question>
    private val currentPosition = 1

    private var selectedOptionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        questionTextView = findViewById(R.id.question_textview)
        flagImage = findViewById(R.id.question_image)
        progressBar = findViewById(R.id.progress_bar)
        progressTextView = findViewById(R.id.progress_text)

        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        checkButton = findViewById(R.id.checkButton)

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        Log.d("QuestionSize", "${questionsList.size}")

        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        val question = questionsList[currentPosition -1]

        questionTextView.text = question.question
        flagImage.setImageResource(question.image)
        progressBar.progress = currentPosition
        progressTextView.text = "$currentPosition/${progressBar.max}"

        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4

        if(currentPosition == questionsList.size){
            checkButton.text == "FINISH"
        }else{
            checkButton.text == "CHECK"
        }

    }

    private fun resetOption(){
        val options = mutableListOf<TextView>()

        options.add(option1)
        options.add(option2)
        options.add(option3)
        options.add(option4)

        for(option in options){
            option.setTextColor("#6A6A6A".toColorInt())
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_bg
            )
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun selectOption(textView: TextView, selectedOptionNumber: Int){
        resetOption()

        selectedOptionPosition = selectedOptionNumber

        textView.setTextColor(ContextCompat.getColor(
            this,
            R.color.darkGrey)
        )
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1 -> {
                selectOption(option1, 1)
            }
            R.id.option2 -> {
                selectOption(option2, 2)
            }
            R.id.option3 -> {
                selectOption(option3, 3)
            }
            R.id.option4 -> {
                selectOption(option4, 4)
            }
        }
    }
}