package com.example.weather.di

import android.app.Application
import android.content.Context
import com.example.weather.db.DataBaseModule
import com.example.weather.repository.RepositoryModule
import com.example.weather.ui.activity.MainActivityModule
import com.example.weather.ui.splash.SplashActivityModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [
        CoroutineContextModule::class,
        SplashActivityModule::class,
        MainActivityModule::class,
        RepositoryModule::class,
        DataBaseModule::class,
    ]
)
class AppModule(val app: Application) {
    @Provides
    fun contex(): Context = app
}

@Module
class CoroutineContextModule {
    @Provides
    @Singleton
    @Named("COROUTINES")
    fun providesCoroutineContext() = SupervisorJob() + Dispatchers.IO
}