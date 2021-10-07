package com.example.weather.db.dao

import androidx.room.*
import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.db.entity.WeatherEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weather: FavoriteFilmEntity)

    @Delete
    suspend fun delete(weather: FavoriteFilmEntity)

    @Query("SELECT * FROM  fav_films")
    fun getMovieList(): List<FavoriteFilmEntity>

    @Query("SELECT * FROM fav_films WHERE reith >7 ")
    fun returnReith():List<FavoriteFilmEntity>
}