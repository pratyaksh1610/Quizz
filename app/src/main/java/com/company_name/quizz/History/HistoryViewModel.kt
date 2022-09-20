package com.company_name.quizz.History

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.company_name.quizz.Login.LoginDatabase
import com.company_name.quizz.Login.LoginRepository

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HistoryRepository

    init {
        val dao = HistoryDatabase.getDatabase(application).historyDao()
        repository = HistoryRepository(dao)
    }


    fun insert(historyEntity: HistoryEntity) {
        repository.insert(historyEntity)
    }

    fun getDataOfUser(user: String): LiveData<List<HistoryEntity>> {
        return repository.getDataOfUser(user)
    }

    fun getTotalPointsOfUser(user: String): Int {
        return repository.getTotalPointsOfUser(user)
    }

}