package com.company_name.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.company_name.quizz.databinding.ActivityHomeScreenBinding
import com.company_name.quizz.databinding.ActivityMainBinding

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //for Hello, user-name
        val username = intent.getStringExtra("username").toString()
        binding.helloUserName.text = getString(R.string.hello_user_name, username)


        binding.logout.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
    }
}