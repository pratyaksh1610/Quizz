package com.pratyaksh_khurana.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratyaksh_khurana.quizz.Adapter.HistoryAdapter

import com.pratyaksh_khurana.quizz.History.HistoryViewModel
import com.pratyaksh_khurana.quizz.databinding.ActivityHistoryBinding

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

        //now show history
        binding.username.text = intent.getStringExtra("username").toString()
        binding.overallPoints.text =
            viewModel.getTotalPointsOfUser(intent.getStringExtra("username").toString()).toString()

        viewModel.getDataOfUser(binding.username.text.toString()).observe(this) {

//            TODO : bind data in recycler view
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = HistoryAdapter(this, it)

        }

    }
}