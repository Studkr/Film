package com.example.weather.db

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.weather.db.dao.MovieDao
import com.example.weather.db.dao.SerialsDao
import com.example.weather.db.dao.WeatherDao
import com.example.weather.db.entity.FavoriteFilmEntity
import com.example.weather.db.entity.FavoriteSerialsEntity
import com.example.weather.db.entity.WeatherEntity

@Database(entities = [
    FavoriteFilmEntity::class,
    FavoriteSerialsEntity::class
],version = 3)
abstract class DataBase : RoomDatabase() {
        abstract fun serialsDao():SerialsDao
        abstract fun movieDao():MovieDao

        companion object {
            @VisibleForTesting
            val MIGRATION_2_3 = object : Migration(2, 3) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE 'fav_films' ADD COLUMN 'reith' DOUBLE NOT NULL DEFAULT 0.0")
                }
            }

            operator fun invoke(context: Context) = Room.databaseBuilder(
                context,
                DataBase::class.java,
                "db"
            ).addMigrations(
                MIGRATION_2_3
            )
                .fallbackToDestructiveMigration()
                .build()
        }
}