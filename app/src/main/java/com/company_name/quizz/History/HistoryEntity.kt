package com.company_name.quizz.History

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    var username: String,
    var subject: String,
    var earned: Int,
//    val totalEarned: Int,
    val date: String,
    var time: String


)
