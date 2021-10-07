package com.example.weather.repository

import com.example.weather.data.repository.db.DataBaseRepository
import com.example.weather.data.repository.db.impl.DataBaseRepositoryImpl
import com.example.weather.rest.ApiModule
import com.example.weather.data.repository.MovieRepository
import com.example.weather.data.repository.impl.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [ApiModule::class])
class RepositoryModule {

    @Provides
    fun provideHeroRepository(impl: MovieRepositoryImpl): MovieRepository = impl

    @Singleton
    @Provides
    fun provideDataBaseModule(repository: DataBaseRepositoryImpl): DataBaseRepository = repository
}