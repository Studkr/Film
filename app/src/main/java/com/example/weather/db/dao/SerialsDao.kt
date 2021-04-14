package com.example.weather.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.weather.db.entity.FavoriteSerialsEntity
import com.example.weather.db.entity.WeatherEntity

@Dao
interface SerialsDao {
    @Insert
    suspend fun insert(weather: FavoriteSerialsEntity)

    @Delete
    suspend fun delete(weather: FavoriteSerialsEntity)

    @Query("SELECT * FROM  fav_serials")
    fun getSerialsList(): List<FavoriteSerialsEntity>

}