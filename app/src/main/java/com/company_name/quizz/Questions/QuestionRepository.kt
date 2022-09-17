package com.company_name.quizz.Questions

import androidx.lifecycle.LiveData
import androidx.room.Query

class QuestionRepository(private val dao: QuestionDao) {


    fun insert(questionEntity: QuestionEntity) {
        dao.insert(questionEntity)
    }

    fun getAllQuestions(subject: String): List<QuestionEntity> {
        return dao.getAllQuestions(subject)
    }

    fun delete(){
        dao.delete()
    }



}