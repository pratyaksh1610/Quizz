package com.pratyaksh_khurana.quizz.History

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

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