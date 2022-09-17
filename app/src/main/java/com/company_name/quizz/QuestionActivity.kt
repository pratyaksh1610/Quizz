package com.company_name.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.company_name.quizz.Questions.QuestionEntity
import com.company_name.quizz.Questions.QuestionViewModel
import com.company_name.quizz.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    private lateinit var subjectChosen: String

    private var i = 0
    private var correct = 0
    private var incorrect = 0
    private var points = 0


    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subjectChosen = intent.getStringExtra("subject").toString()

        //set subject chosen
        binding.subject.text = getString(R.string.chosenSubject, subjectChosen)

        when (subjectChosen) {
            "Math" -> {
                getMathQues()
            }
            "Geography" -> {
                getGeographyQues()
            }
            "Literature" -> {
                getLiteratureQues()
            }
        }


        //on press back button return to subject chosen activity
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    //render questions on screen
    private fun renderQuesOnScreen(question: List<QuestionEntity>, index: Int) {

        //all questions over
        //head to finish result activity
        // as of now it heads to subject activity
        if (i > 4) {
            Toast.makeText(
                this,
                "correct = $correct, wrong $incorrect, points $points   ",
                Toast.LENGTH_LONG
            ).show()
            startActivity(Intent(this, SubjectActivity::class.java))
        }

        //reset all options to default state
        binding.op1.isChecked = false
        binding.op2.isChecked = false
        binding.op3.isChecked = false
        binding.op4.isChecked = false

        val idx = (index + 1)
        idx.toString()
        binding.questionNumber.text = getString(R.string.questionNumber, idx)
        binding.questionText.text = question[index].question
        binding.op1.text = question[index].op1
        binding.op2.text = question[index].op2
        binding.op3.text = question[index].op3
        binding.op4.text = question[index].op4

        binding.nextBtn.setOnClickListener {

            if (binding.op1.isChecked || binding.op2.isChecked || binding.op3.isChecked || binding.op4.isChecked) {

                //calculate points and number of right and wrong answers
                if (binding.op1.isChecked) {
                    if (binding.op1.text.toString() == question[index].answer) {
                        //correct answer
                        correct()
                    } else {
                        //wrong answer
                        incorrect()
                    }
                } else if (binding.op2.isChecked) {
                    if (binding.op2.text.toString() == question[index].answer) {
                        correct()
                    } else {
                        incorrect()
                    }
                } else if (binding.op3.isChecked) {
                    if (binding.op3.text.toString() == question[index].answer) {
                        correct()
                    } else {
                        incorrect()
                    }
                } else if (binding.op4.isChecked) {
                    if (binding.op4.text.toString() == question[index].answer) {
                        correct()
                    } else {
                        incorrect()
                    }
                }

                i++
                renderQuesOnScreen(question, i)

            } else {
                Toast.makeText(this, "Select an answer", Toast.LENGTH_LONG).show()
            }

        }
    }

    //correct answer
    private fun correct() {
        correct++
        points += 5
    }

    //incorrect answer
    private fun incorrect() {
        incorrect++
        points -= 5
    }

    //get all question of particular subject
    private fun getMathQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("math")
        renderQuesOnScreen(l, 0)
    }

    private fun getLiteratureQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("literature")
        renderQuesOnScreen(l, 0)
    }

    private fun getGeographyQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("geography")
        renderQuesOnScreen(l, 0)
    }

}