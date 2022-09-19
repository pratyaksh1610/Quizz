package com.company_name.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope

import com.company_name.quizz.History.HistoryViewModel
import com.company_name.quizz.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        Toast.makeText(this, intent.getStringExtra("username").toString(), Toast.LENGTH_LONG).show()
        //now show history
        binding.username.text = intent.getStringExtra("username").toString()
        viewModel.getDataOfUser(binding.username.text.toString()).observe(this) {

//            TODO : bind data in recycler view


        }

    }
}