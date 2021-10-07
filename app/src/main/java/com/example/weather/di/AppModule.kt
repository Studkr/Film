package com.example.weather.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule() {
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}

@InstallIn(SingletonComponent::class)
@Module
class CoroutineContextModule {
    @Provides
    @Singleton
    @Named("COROUTINES")
    fun providesCoroutineContext() = SupervisorJob() + Dispatchers.IO
}