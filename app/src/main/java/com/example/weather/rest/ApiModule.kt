package com.example.weather.rest

import com.example.weather.rest.repository.api.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(
    includes = [
        RetrofitModule::class
    ]
)
class ApiModule {

    @Provides
    fun provideApi (retrofit: Retrofit) = retrofit.create(Api::class.java)

}