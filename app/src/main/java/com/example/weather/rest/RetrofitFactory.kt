package com.example.weather.rest

import com.example.weather.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


internal fun createRetrofit(
    baseUrl: String,
    converterFactory: Converter.Factory,
    okHttpClient: OkHttpClient
): Retrofit {

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()
}

fun createOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    val clientBuilder = OkHttpClient.Builder()
    clientBuilder.connectTimeout(15, TimeUnit.SECONDS)
    clientBuilder.writeTimeout(30, TimeUnit.SECONDS)
    clientBuilder.readTimeout(30, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) clientBuilder.addInterceptor(loggingInterceptor)
    return clientBuilder.build()

}




fun getLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

