package com.company_name.quizz.Login

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(LoginCredentials::class), version = 1, exportSchema = false)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: LoginDatabase? = null

        fun getDatabase(context: Context): LoginDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LoginDatabase::class.java,
                    "login_database"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}