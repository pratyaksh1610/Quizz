package com.company_name.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.company_name.quizz.Login.LoginCredentials
import com.company_name.quizz.Login.LoginViewModel
import com.company_name.quizz.databinding.ActivityEditPasswordBinding

class EditPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPasswordBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username").toString()
        //already present in database
        val password = intent.getStringExtra("password").toString()
        val id = intent.getStringExtra("id").toString().toInt()

        binding.changePasswordBtn.setOnClickListener {

            if (binding.newPassword.text.toString()
                    .isEmpty() || binding.oldPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Password is empty", Toast.LENGTH_LONG)
                    .show()
            } else if (binding.newPassword.text.toString() == password) {
                Toast.makeText(this, "Old password is same as New password", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(this, "Password updated", Toast.LENGTH_LONG)
                    .show()

                viewModel.update(binding.newPassword.text.toString(), id)
            }
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}
