package com.company_name.quizz.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.company_name.quizz.HomeScreenActivity
import com.company_name.quizz.Login.LoginViewModel
import com.company_name.quizz.R
import com.company_name.quizz.databinding.FragmentLoginBinding
import kotlin.system.exitProcess

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

            //check if user is registered in the app or not
            viewModel.checkIfUserIsRegistered(
                binding.username.text.toString(),
                binding.password.text.toString()
            )
                .observe(viewLifecycleOwner) { loginDetailsList ->
                    //fetch data and returns list of users if registered
                    //check if user already exist in database
                    if (loginDetailsList.isNotEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "User already exists, Login successful",
                            Toast.LENGTH_LONG
                        ).show()
                        //move to home screen of quiz
                        val intent = Intent(requireContext(), HomeScreenActivity::class.java)
                        intent.putExtra("username", binding.username.text.toString())
                        intent.putExtra("password", binding.password.text.toString())
                        intent.putExtra("id", loginDetailsList[0].id.toString())
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "User not found",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

        //sign up user, if does not exist already
        binding.signUp.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer, SignUpFragment())
                    .commit()
            }
        }

        //exit app
        binding.exitBtn.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                exitProcess(0)
            }, 200)
        }

        return binding.root
    }

}