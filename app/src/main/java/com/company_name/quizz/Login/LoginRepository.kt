package com.company_name.quizz.Login

import android.util.Log
import androidx.lifecycle.LiveData
import com.company_name.quizz.Questions.QuestionDao

class LoginRepository(private val dao: LoginDao) {

    fun insert(login: LoginCredentials) {
        dao.insert(login)
    }

    fun checkIfUserIsRegistered(
        username: String,
        password: String
    ): LiveData<List<LoginCredentials>> {
        return dao.checkIfUserIsRegistered(username, password)
    }

    fun checkUsernameExists(username: String): LiveData<List<LoginCredentials>> {
        return dao.checkUsernameExists(username)
    }

    fun update(password: String, username:String) {
        dao.update(password, username)
    }


}