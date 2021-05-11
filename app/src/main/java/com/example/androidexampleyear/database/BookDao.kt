package com.example.androidexampleyear.database

import androidx.room.*
import com.example.androidexampleyear.model.Book

@Dao
interface BookDao {
    @Query("select * from book")
    fun getAllBook() : List<Book>
    @Insert
    fun insertBook(book: Book)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateBook(book: Book)
    @Delete
    fun deleteBook(book: Book)
    @Query("select * from book where name like :na")
    fun searchBook(na : String)
}