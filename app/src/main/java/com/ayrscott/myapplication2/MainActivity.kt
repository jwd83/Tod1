package com.ayrscott.myapplication2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var formula: String = "1 + 1"
    var correctAnswer: Int = 0
    var correctAnswerSpot: Int = 0
    var score: Int = 0
    var streak: Int = 0
    var longestStreak: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBoard()

        button.setOnClickListener({takeAnswer(1)})
        button2.setOnClickListener({takeAnswer(2)})
        button3.setOnClickListener({takeAnswer(3)})
        button4.setOnClickListener({takeAnswer(4)})
    }

    fun setupBoard() {
        correctAnswer = Random.nextInt(1,10)
        var added: Int = Random.nextInt(0,correctAnswer)
        var base: Int = correctAnswer - added

        correctAnswerSpot = Random.nextInt(1,5)

        formula = "$base + $added = ?"

        textView.text = formula
        textView2.text = "Score : $score, Streak: $streak, Longest: $longestStreak"

        if(correctAnswerSpot == 1){

            button.text = correctAnswer.toString()
            button2.text = (correctAnswer+1).toString()
            button3.text = (correctAnswer+2).toString()
            button4.text = (correctAnswer+3).toString()
        }
        if(correctAnswerSpot == 2){

            button.text = (correctAnswer+1).toString()
            button2.text = correctAnswer.toString()
            button3.text = (correctAnswer+2).toString()
            button4.text = (correctAnswer+3).toString()
        }
        if(correctAnswerSpot == 3){

            button.text = (correctAnswer+2).toString()
            button2.text = (correctAnswer+1).toString()
            button3.text = correctAnswer.toString()
            button4.text = (correctAnswer+3).toString()
        }
        if(correctAnswerSpot == 4){

            button.text = (correctAnswer+3).toString()
            button2.text = (correctAnswer+1).toString()
            button3.text = (correctAnswer+2).toString()
            button4.text = correctAnswer.toString()
        }

    }

    fun takeAnswer(id: Int) {
        if (id == correctAnswerSpot) {
            score += 1
            streak += 1
            if(streak > longestStreak) longestStreak = streak

        } else {
            score -= 1
            streak = 0
        }
        setupBoard()
    }

}
