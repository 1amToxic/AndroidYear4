package com.example.androidexampleyear.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidexampleyear.model.Book
import com.example.androidexampleyear.model.User

@Database(entities = [User::class, Book::class], version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao()  : UserDao
    abstract fun bookDao() : BookDao
    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null
        fun getDatabase(context : Context) : AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "book"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}