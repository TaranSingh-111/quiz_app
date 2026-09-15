package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {

    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>(

            Question(
                id = 1,
                question = "Which country's flag is this?",
                image = R.drawable.egypt,
                option1 = "Egypt",
                option2 = "Yemen",
                option3 = "Iraq",
                option4 = "Jordan",
                answer = 1
            ),

            Question(
                id = 2,
                question = "Which country's flag is this?",
                image = R.drawable.georgia,
                option1 = "Georgia",
                option2 = "Armenia",
                option3 = "Greece",
                option4 = "Croatia",
                answer = 1
            ),

            Question(
                id = 3,
                question = "Which country's flag is this?",
                image = R.drawable.indonesia,
                option1 = "Poland",
                option2 = "Indonesia",
                option3 = "Monaco",
                option4 = "Singapore",
                answer = 2
            ),

            Question(
                id = 4,
                question = "Which country's flag is this?",
                image = R.drawable.kazakhstan,
                option1 = "Mongolia",
                option2 = "Uzbekistan",
                option3 = "Kazakhstan",
                option4 = "Kyrgyzstan",
                answer = 3
            ),

            Question(
                id = 5,
                question = "Which country's flag is this?",
                image = R.drawable.laos,
                option1 = "Thailand",
                option2 = "Laos",
                option3 = "Cambodia",
                option4 = "Vietnam",
                answer = 2
            ),

            Question(
                id = 6,
                question = "Which country's flag is this?",
                image = R.drawable.nepal,
                option1 = "Bhutan",
                option2 = "Nepal",
                option3 = "India",
                option4 = "Sri Lanka",
                answer = 2
            ),

            Question(
                id = 7,
                question = "Which country's flag is this?",
                image = R.drawable.oman,
                option1 = "Oman",
                option2 = "Qatar",
                option3 = "Bahrain",
                option4 = "Kuwait",
                answer = 1
            ),

            Question(
                id = 8,
                question = "Which country's flag is this?",
                image = R.drawable.thailand,
                option1 = "Costa Rica",
                option2 = "Thailand",
                option3 = "Laos",
                option4 = "Cambodia",
                answer = 2
            ),

            Question(
                id = 9,
                question = "Which country's flag is this?",
                image = R.drawable.timor_leste,
                option1 = "Mozambique",
                option2 = "Angola",
                option3 = "Timor-Leste",
                option4 = "Eritrea",
                answer = 3
            ),

            Question(
                id = 10,
                question = "Which country's flag is this?",
                image = R.drawable.yemen,
                option1 = "Egypt",
                option2 = "Yemen",
                option3 = "Syria",
                option4 = "Iraq",
                answer = 2
            )
        )
        return questions
    }
}