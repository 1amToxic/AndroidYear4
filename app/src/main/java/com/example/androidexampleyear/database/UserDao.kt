package com.example.androidexampleyear.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidexampleyear.model.User

@Dao
interface UserDao {
    @Query("select * from user where username = :un and password = :pw")
    suspend fun checkLogin(un : String,pw : String) : User?
    @Insert
    fun insertUser(user : User)
}