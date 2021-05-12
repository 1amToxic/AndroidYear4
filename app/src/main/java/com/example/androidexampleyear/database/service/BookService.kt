package com.example.androidexampleyear.database.service

import android.content.Context
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidexampleyear.database.AppDatabase
import com.example.androidexampleyear.database.BookDao
import com.example.androidexampleyear.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookService(private val context : Context) {
    private var bookDao: BookDao = AppDatabase.getDatabase(context).bookDao()
    suspend fun getAllBook(id :Int) : List<Book> {
        return bookDao.getAllBook(id)
    }
    fun insertBook(book: Book){
        GlobalScope.launch(Dispatchers.IO) {
            bookDao.insertBook(book)
        }
    }
    fun updateBook(book: Book){
        GlobalScope.launch(Dispatchers.IO) {
            bookDao.updateBook(book)
        }
    }
    fun deleteBook(book: Book){
        GlobalScope.launch(Dispatchers.IO) {
            bookDao.deleteBook(book)
        }
    }
    fun searchBook(na : String) : List<Book>{
        var list : List<Book>? = null
        GlobalScope.launch(Dispatchers.IO) {
            list = bookDao.searchBook(na)
        }
        return list!!
    }
}