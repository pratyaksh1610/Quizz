package com.company_name.quizz.Questions

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDao {

    //inserts questions
    @Insert
    fun insert(questionEntity: QuestionEntity)

    //returns questions of a particular subject
    @Query("select * from question_table where subject = :subject")
    fun getAllQuestions(subject: String): List<QuestionEntity>

    @Query("delete from question_table")
    fun delete()

}