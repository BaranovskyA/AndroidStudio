package com.example.education

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    var questions: Map<Int, String>? = null
    var answers: Map<Int, String>? = null
    private var currentQuestionID: Int = 1
    private var currentAnswerID: Int = 1
    private var countCorrectAnswers = 0
    private var currentAnswerText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        initializeQuestions()
        initializeAnswers()

        button_activity_test_answer1.setOnClickListener {
            currentAnswerText = button_activity_test_answer1.text.toString()
            checkAnswer()
        }
        button_activity_test_answer2.setOnClickListener {
            currentAnswerText = button_activity_test_answer2.text.toString()
            checkAnswer()
        }
        button_activity_test_answer3.setOnClickListener {
            currentAnswerText = button_activity_test_answer3.text.toString()
            checkAnswer()
        }
        button_activity_test_answer4.setOnClickListener {
            currentAnswerText = button_activity_test_answer4.text.toString()
            checkAnswer()
        }

        nextQuestion()
    }

    fun initializeQuestions() {
        questions = mapOf(1 to "4 * 4 = ?", 2 to "2 + 2 * 2 = ?", 3 to "42 - 31 = ?")
    }

    fun initializeAnswers() {
        answers = mapOf(1 to "12", 2 to "42", 3 to "16", 4 to "18", 5 to "6", 6 to "10", 7 to "8", 8 to "4", 9 to "6", 10 to "17", 11 to "33", 12 to "11")
    }

    fun checkAnswer() {
        when(currentQuestionID) {
            2 -> {
                if(currentAnswerText == "16") countCorrectAnswers++
            }
            3 -> {
                if(currentAnswerText == "6") countCorrectAnswers++
            }
            4 -> {
                if(currentAnswerText == "11") countCorrectAnswers++
            }
        }
        nextQuestion()
    }

    fun nextQuestion() {
        if(currentQuestionID <= 3) {
            textview_activity_test_question.text = questions?.getValue(currentQuestionID) ?: ""
            currentQuestionID++

            button_activity_test_answer1.text = answers?.getValue(currentAnswerID) ?: ""
            currentAnswerID++
            button_activity_test_answer2.text = answers?.getValue(currentAnswerID) ?: ""
            currentAnswerID++
            button_activity_test_answer3.text = answers?.getValue(currentAnswerID) ?: ""
            currentAnswerID++
            button_activity_test_answer4.text = answers?.getValue(currentAnswerID) ?: ""
            currentAnswerID++
        } else {
            displayResult()
        }
    }

    @SuppressLint("SetTextI18n")
    fun displayResult() {
        textview_activity_test_question.text = ""
        button_activity_test_answer1.visibility = View.INVISIBLE
        button_activity_test_answer2.visibility = View.INVISIBLE
        button_activity_test_answer3.visibility = View.INVISIBLE
        button_activity_test_answer4.visibility = View.INVISIBLE

        textview_activity_test_result.text = "Правильных ответов: $countCorrectAnswers/3"
    }
}