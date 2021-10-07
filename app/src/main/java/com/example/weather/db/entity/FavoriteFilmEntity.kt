package com.example.weather.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_films")
data class FavoriteFilmEntity (
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    @ColumnInfo(name = "show_name")
    val showName:String,
    @ColumnInfo(name = "image")
    val image:String,
    @ColumnInfo(name = "reith")
    val reith:Double
    )

