package com.company_name.quizz.Login

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_table")
data class LoginCredentials(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val username: String,
    val password: String,
    val email: String
)