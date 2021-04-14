package com.example.weather.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weather.db.dao.MovieDao
import com.example.weather.db.dao.SerialsDao
import com.example.weather.db.dao.WeatherDao
import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.db.entity.FavoriteSerialsEntity
import com.example.weather.db.entity.WeatherEntity

@Database(entities = [
    FavoriteFilmEntity::class,
    FavoriteSerialsEntity::class
],version = 2)
abstract class DataBase : RoomDatabase() {
        abstract fun serialsDao():SerialsDao
        abstract fun movieDao():MovieDao

        companion object {
            operator fun invoke(context: Context) = Room.databaseBuilder(
                context,
                DataBase::class.java,
                "db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
}