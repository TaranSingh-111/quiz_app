package com.example.quizapp.ui

import android.annotation.SuppressLint
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
    private var currentQuestionNumber = 1
    private lateinit var  currentQuestion: Question
    private var selectedOption = 0
    private var answered = false

    private var score = 0

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

    //for setting up the question
    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        //removes the selection for the previous question
        selectedOption = 0
        //sets all the options to normal
        resetOption()
        //makes the question unanswered
        answered = false

        //setting the quesiton ui
        val question = questionsList[currentQuestionNumber -1]

        questionTextView.text = question.question
        flagImage.setImageResource(question.image)
        progressBar.progress = currentQuestionNumber
        progressTextView.text = "$currentQuestionNumber/${progressBar.max}"

        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4

        //making the options clickable
        option1.isClickable = true
        option2.isClickable = true
        option3.isClickable = true
        option4.isClickable = true

        if(currentQuestionNumber < questionsList.size){
            checkButton.text = "CHECK"
            currentQuestion = question
        }else{
            checkButton.text = "FINISH"
            // TODO: final screen 
        }

        //moves on to the next question when for the next method call
        currentQuestionNumber++
    }

    //changes the options textview to normal
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

    //calls resetOption to make all normal then changes the style of the selected option.
    @SuppressLint("ResourceAsColor")
    private fun selectOption(textView: TextView, selectedOptionNumber: Int){
        resetOption()

        selectedOption = selectedOptionNumber

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

    //checks the answer
    //if correct makes it green
    //else makes it red and makes the correct option green
    private fun checkAnswer(){
        answered = true

        //make the options unclickable
        option1.isClickable = false
        option2.isClickable = false
        option3.isClickable = false
        option4.isClickable = false

        if(currentQuestion.answer == selectedOption){
            score++

            when(selectedOption){
                1 ->{
                    option1.background = ContextCompat.getDrawable(
                        this, R.drawable.correct_option_bg
                    )
                }
                2 ->{
                    option2.background = ContextCompat.getDrawable(
                        this, R.drawable.correct_option_bg
                    )
                }
                3 ->{
                    option3.background = ContextCompat.getDrawable(
                        this, R.drawable.correct_option_bg
                    )
                }
                4 ->{
                    option4.background = ContextCompat.getDrawable(
                        this, R.drawable.correct_option_bg
                    )
                }
            }
        }else{
            when(selectedOption){
                1 ->{
                    option1.background = ContextCompat.getDrawable(
                        this, R.drawable.wrong_option_bg
                    )
                }
                2 ->{
                    option2.background = ContextCompat.getDrawable(
                        this, R.drawable.wrong_option_bg
                    )
                }
                3 ->{
                    option3.background = ContextCompat.getDrawable(
                        this, R.drawable.wrong_option_bg
                    )
                }
                4 ->{
                    option4.background = ContextCompat.getDrawable(
                        this, R.drawable.wrong_option_bg
                    )
                }
            }
            //also show the correct option
            showCorrectAnswer()
        }
    }

    private fun showCorrectAnswer(){
        when(currentQuestion.answer){
            1 ->{
                option1.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_bg
                )
            }
            2 ->{
                option2.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_bg
                )
            }
            3 ->{
                option3.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_bg
                )
            }
            4 ->{
                option4.background = ContextCompat.getDrawable(
                    this, R.drawable.correct_option_bg
                )
            }
        }
    }

    @SuppressLint("SetTextI18n")
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
            R.id.checkButton -> {
                //if the question is answered move on to next question
                if(answered){
                    setQuestion()
                } else{
                    //only check if the option is selected
                    if(selectedOption != 0){
                        //if unanswered checks the answer and makes the button say next
                        //checkAnswer makes sure that if condition is executed next
                        checkAnswer()
                        if(currentQuestionNumber < questionsList.size){
                            checkButton.text = "NEXT"
                        }
                    }
                }
            }
        }
    }
}