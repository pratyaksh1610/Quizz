package com.company_name.quizz.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.company_name.quizz.Login.LoginCredentials
import com.company_name.quizz.Login.LoginViewModel
import com.company_name.quizz.MainActivity2
import com.company_name.quizz.R
import com.company_name.quizz.databinding.FragmentLoginBinding
import kotlin.concurrent.fixedRateTimer

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.loginBtn.setOnClickListener {

            viewModel.check(binding.username.text.toString(), binding.password.text.toString())
                .observe(viewLifecycleOwner) { loginDetailsList ->
                    //check if user already exist in database
                    if (loginDetailsList.isNotEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "User already exists",
                            Toast.LENGTH_LONG
                        ).show()
                        //move to home screen of quiz

                    } else {
                        Toast.makeText(
                            requireContext(),
                            "User not found",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

        binding.signUp.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer, SignUpFragment())
                    .commit()
            }
        }

        return binding.root
    }

}