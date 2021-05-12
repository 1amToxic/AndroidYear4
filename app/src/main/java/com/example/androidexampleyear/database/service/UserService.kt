package com.example.androidexampleyear.database.service

import android.content.Context
import androidx.room.Insert
import androidx.room.Query
import com.example.androidexampleyear.database.AppDatabase
import com.example.androidexampleyear.database.UserDao
import com.example.androidexampleyear.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserService(private val context: Context) {
    var userDao: UserDao = AppDatabase.getDatabase(context).userDao()
    suspend fun checkLogin(un : String, pw : String) : User?{
        return userDao.checkLogin(un,pw)
    }
    fun insertUser(user : User){
        GlobalScope.launch(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }
}