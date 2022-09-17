package com.company_name.quizz.Questions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class QuestionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: QuestionRepository

    init {
        val dao = QuestionDatabase.getDatabase(application).questionDao()
        repository = QuestionRepository(dao)
    }

    fun insert(questionEntity: QuestionEntity) {
        repository.insert(questionEntity)
    }

    fun getAllQuestions(subject: String): List<QuestionEntity> {
        return repository.getAllQuestions(subject)
    }

    fun delete() {
        repository.delete()
    }

}