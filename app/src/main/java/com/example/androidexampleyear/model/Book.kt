package com.example.androidexampleyear.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey val id : Int,
    val name : String,
    val type : String,
    val content : String,
    @ColumnInfo(name = "user_id")
    val userId : Int
)
