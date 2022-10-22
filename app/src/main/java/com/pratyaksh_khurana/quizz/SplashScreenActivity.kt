package com.pratyaksh_khurana.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.pratyaksh_khurana.quizz.databinding.ActivitySplashScreenBinding
import com.pratyaksh_khurana.quizz.Questions.AllQuestions
import com.pratyaksh_khurana.quizz.Questions.QuestionEntity
import com.pratyaksh_khurana.quizz.Questions.QuestionViewModel

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //refresh questions everytime app opens
        viewModel.delete()
        val list: List<QuestionEntity> = AllQuestions().insertAll()
        for (i in list.indices) {
            viewModel.insert(list[i])
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 200)

    }
}