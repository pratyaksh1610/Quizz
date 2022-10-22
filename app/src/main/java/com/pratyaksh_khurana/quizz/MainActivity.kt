package com.pratyaksh_khurana.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pratyaksh_khurana.quizz.Fragments.LoginFragment
import com.pratyaksh_khurana.quizz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enable view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //transition to splash screen fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, LoginFragment())
                .commit()
        }
    }

    override fun onBackPressed() {

    }

}