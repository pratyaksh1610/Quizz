package com.company_name.quizz.Login

import android.util.Log
import androidx.lifecycle.LiveData

class LoginRepository (private val dao:LoginDao) {

    fun insert(login: LoginCredentials){
        dao.insert(login)
    }

    fun check(username:String,password:String): LiveData<List<LoginCredentials>> {
        return dao.check(username,password)
    }


}