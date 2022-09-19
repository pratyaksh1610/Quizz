package com.company_name.quizz.History

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface HistoryDao {

    @Insert(onConflict = REPLACE)
    fun insert(historyEntity: HistoryEntity)

    @Query("SELECT * FROM HISTORY_TABLE WHERE username = :user")
    fun getDataOfUser(user: String): LiveData<List<HistoryEntity>>


}