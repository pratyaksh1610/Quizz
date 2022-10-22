package com.pratyaksh_khurana.quizz.Login

import androidx.lifecycle.LiveData

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