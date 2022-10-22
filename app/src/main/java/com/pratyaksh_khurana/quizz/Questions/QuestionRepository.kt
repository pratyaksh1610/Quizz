package com.pratyaksh_khurana.quizz.Questions

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