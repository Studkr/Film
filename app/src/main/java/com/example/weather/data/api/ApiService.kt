package com.example.weather.data.api


import com.example.weather.data.model.MovieDetailsResponceModel
import com.example.weather.data.model.MovieModelResponce
import com.example.weather.data.model.SerialsModelResponce
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
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