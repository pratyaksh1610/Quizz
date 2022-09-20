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

    @Query("SELECT * FROM HISTORY_TABLE WHERE username = :user ORDER BY time desc")
    fun getDataOfUser(user: String): LiveData<List<HistoryEntity>>

    @Query("select SUM(earned) from history_table where username = :user")
    fun getTotalPointsOfUser(user: String): Int

}