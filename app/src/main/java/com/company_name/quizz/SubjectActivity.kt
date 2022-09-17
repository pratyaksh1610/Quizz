package com.company_name.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company_name.quizz.databinding.ActivitySubjectBinding

class SubjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        binding.Geography.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("subject", "Geography")
            startActivity(intent)
        }

        binding.math.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("subject", "Math")
            startActivity(intent)
        }

        binding.literature.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("subject", "Literature")
            startActivity(intent)
        }


    }
}