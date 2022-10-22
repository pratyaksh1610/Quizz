package com.pratyaksh_khurana.quizz.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pratyaksh_khurana.quizz.History.HistoryEntity
import com.pratyaksh_khurana.quizz.HistoryActivity
import com.pratyaksh_khurana.quizz.databinding.HistoryEachUserBinding


class HistoryAdapter(
    private val listener: HistoryActivity, private val listUser: List<HistoryEntity>,
) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(val binding: HistoryEachUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            HistoryEachUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val curr = listUser[position]

        //bind data in recycler view
        holder.binding.date.setText(curr.date)
        holder.binding.earned.setText(curr.earned.toString())
        holder.binding.subject.setText(curr.subject)
        holder.binding.time.setText(curr.time)

    }

    override fun getItemCount(): Int {
        return listUser.size
    }

}