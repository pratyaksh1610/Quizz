package com.company_name.quizz.Fragments

import android.os.Build.VERSION_CODES.M
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.company_name.quizz.R
import com.company_name.quizz.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //enable view binding
        binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)

        //transition to login screen fragment
        Handler(Looper.getMainLooper()).postDelayed({
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer, LoginFragment())
                    .commit()
            }
        }, 1000)

        return binding.root
    }

}