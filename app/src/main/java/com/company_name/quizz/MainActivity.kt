package com.company_name.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.company_name.quizz.Fragments.LoginFragment
import com.company_name.quizz.Fragments.SplashScreenFragment
import com.company_name.quizz.Login.LoginDatabase
import com.company_name.quizz.Login.LoginViewModel
import com.company_name.quizz.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enable view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //transition to splash screen fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, SplashScreenFragment())
                .commit()
        }
    }

    override fun onBackPressed() {

    }

}