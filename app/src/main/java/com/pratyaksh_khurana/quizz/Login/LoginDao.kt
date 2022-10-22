package com.pratyaksh_khurana.quizz.Login

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LoginDao {


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(login: LoginCredentials)

    //return list of all users having same username and password
    @Query("SELECT * FROM login_table WHERE username LIKE :username AND " + "password LIKE :password")
    fun checkIfUserIsRegistered(
        username: String,
        password: String
    ): LiveData<List<LoginCredentials>>

    @Query("SELECT * FROM login_table WHERE username LIKE :username")
    fun checkUsernameExists(username: String): LiveData<List<LoginCredentials>>

    //update password
    @Query("UPDATE login_table SET password = :password WHERE username= :username")
    fun update(password: String, username: String)

}