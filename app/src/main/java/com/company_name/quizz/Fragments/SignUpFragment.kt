package com.company_name.quizz.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.company_name.quizz.Login.LoginCredentials
import com.company_name.quizz.Login.LoginViewModel
import com.company_name.quizz.R
import com.company_name.quizz.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        binding.createBtn.setOnClickListener {
            if (binding.username.text.toString().isNotEmpty() &&
                binding.password.text.toString().isNotEmpty() &&
                binding.email.text.toString().isNotEmpty()
            ) {
                viewModel.insert(
                    LoginCredentials(
                        id = null,
                        username = binding.username.text.toString(),
                        password = binding.password.text.toString(),
                        email = binding.email.text.toString()
                    )
                )
                Toast.makeText(requireContext(), "User inserted", Toast.LENGTH_SHORT).show()
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragmentContainer, LoginFragment())
                        .commit()
                }
            } else {
                Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_LONG).show()
            }
        }

        binding.backBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer, LoginFragment())
                    .commit()
            }
        }

        return binding.root
    }


}