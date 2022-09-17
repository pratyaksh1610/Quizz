package com.company_name.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company_name.quizz.Fragments.LoginFragment
import com.company_name.quizz.Fragments.SignUpFragment
import com.company_name.quizz.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //for Hello, user-name
        val username = intent.getStringExtra("username").toString()
        val password = intent.getStringExtra("password").toString()
        val id = intent.getStringExtra("id").toString()
        binding.helloUserName.text = getString(R.string.hello_user_name, username)

        binding.logout.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.editPassword.setOnClickListener {
            val intent = Intent(this, EditPasswordActivity::class.java)
            intent.putExtra("password", password)
            intent.putExtra("username", username)
            intent.putExtra("id", id)
            startActivity(intent)
        }

        binding.rules.setOnClickListener {
            startActivity(Intent(this, RulesActivity::class.java))
        }
        binding.startQuiz.setOnClickListener {
            startActivity(Intent(this, SubjectActivity::class.java))
        }

    }

    override fun onBackPressed() {

    }

    //when activity is visible and the user interacts with it then this is called
    //to set the username
    override fun onResume() {
        val username = intent.getStringExtra("username").toString()
        binding.helloUserName.text = getString(R.string.hello_user_name, username)
        super.onResume()
    }
}