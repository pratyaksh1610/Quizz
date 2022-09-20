package com.company_name.quizz.History

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

class HistoryRepository(private val dao: HistoryDao) {


    fun insert(historyEntity: HistoryEntity) {
        dao.insert(historyEntity)
    }

    fun getDataOfUser(user: String): LiveData<List<HistoryEntity>> {
        return dao.getDataOfUser(user)
    }

    fun getTotalPointsOfUser(user: String): Int{
        return dao.getTotalPointsOfUser(user)
    }



}