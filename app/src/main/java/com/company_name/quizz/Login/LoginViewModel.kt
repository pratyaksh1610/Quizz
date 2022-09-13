package com.company_name.quizz.Login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: LoginRepository

    init {
        val dao = LoginDatabase.getDatabase(application).loginDao()
        repository = LoginRepository(dao)
    }

    fun insert(login: LoginCredentials) {
        repository.insert(login)
    }

    fun check(username:String,password:String): LiveData<List<LoginCredentials>>{
        return repository.check(username,password)
    }


}