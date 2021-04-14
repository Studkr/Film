package com.example.weather.rest.repository.api


import com.example.weather.rest.model.MovieDetailsResponceModel
import com.example.weather.rest.model.MovieModelResponce
import com.example.weather.rest.model.SerialsModelResponce
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {
    @GET("/3/trending/movie/week")
     suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
     ): MovieModelResponce

     @GET("/3/tv/popular")
     suspend fun getPopularSerials(
         @Query("api_key") apiKey:String
     ):SerialsModelResponce

     @GET("/3/movie/{movie_id}")
     suspend fun getMovieDetails(
         @Path("movie_id") id: Long,
         @Query("api_key") apiKey:String
     ): MovieDetailsResponceModel

     @GET("/3/movie/{id}/recommendations")
     suspend fun getMovieRecommendation(
         @Path("id")id: Long,
         @Query("api_key") apiKey:String
     )

     @GET("/tv/{tv_id}")
     suspend fun getSerialsDetails(
         @Path("tv_id") id: Long,
         @Query("api_key")apiKey: String
     )
}