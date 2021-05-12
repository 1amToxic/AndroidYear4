package com.example.androidexampleyear.database

import androidx.room.*
import com.example.androidexampleyear.model.Book

@Dao
interface BookDao {
    @Query("select * from book where user_id = :id")
    suspend fun getAllBook(id : Int) : List<Book>
    @Insert
    fun insertBook(book: Book)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateBook(book: Book)
    @Delete
    fun deleteBook(book: Book)
    @Query("select * from book where name like :na")
    suspend fun searchBook(na : String) : List<Book>
}