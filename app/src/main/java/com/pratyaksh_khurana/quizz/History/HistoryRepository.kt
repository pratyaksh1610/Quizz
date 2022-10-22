package com.pratyaksh_khurana.quizz.History

import androidx.lifecycle.LiveData

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