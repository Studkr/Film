package com.example.weather.rest

import com.example.weather.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module(
    includes = [
        RetrofitModule::class
    ]
)
class ApiModule {

    @Provides
    fun provideApi (retrofit: Retrofit) = retrofit.create(ApiService::class.java)

}