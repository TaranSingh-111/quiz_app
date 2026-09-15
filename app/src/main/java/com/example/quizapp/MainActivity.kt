package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.ui.QuestionsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton : Button = findViewById(R.id.start_button)
        val editTextName : EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if(editTextName.text.isNotEmpty()){
                Intent(this@MainActivity, QuestionsActivity::class.java).also{
                    startActivity(it)
                    finish()
                }
            }else{
                Toast.makeText(this@MainActivity, "Enter a name", Toast.LENGTH_LONG).show()
            }
        }

    }
}