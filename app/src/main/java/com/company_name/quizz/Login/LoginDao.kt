package com.company_name.quizz.Login

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoginDao {


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(login: LoginCredentials)

    //return list of all users having same username and password
    @Query("SELECT * FROM login_table WHERE username LIKE :username AND " + "password LIKE :password")
    fun check(username:String,password:String): LiveData<List<LoginCredentials>>


}