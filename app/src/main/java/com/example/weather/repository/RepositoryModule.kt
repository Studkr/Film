package com.example.weather.repository

import com.example.weather.repository.db.DataBaseRepository
import com.example.weather.repository.impl.DataBaseRepositoryImpl
import com.example.weather.rest.ApiModule
import com.example.weather.rest.repository.MovieRepository
import com.example.weather.rest.repository.impl.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class RepositoryModule {

    @Provides
    fun provideHeroRepository(impl: MovieRepositoryImpl): MovieRepository = impl

    @Singleton
    @Provides
    fun provideDataBaseModule(repository: DataBaseRepositoryImpl): DataBaseRepository = repository
}