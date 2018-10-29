package com.nurawwabys.tayangterkini.API

import com.nurawwabys.tayangterkini.Entity.ResponseMovies;

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApiService {

    @GET("3/discover/movie")
    fun getAllMovies(@Query("api_key") api_key: String,
                     @Query("language") language: String,
                     @Query("sort_by") sort_by: String,
                     @Query("include_adult") include_adult: String,
                     @Query("page") page: String): Call<ResponseMovies>

    @GET("/3/search/movie")
    fun getSearchMovie(@Query("api_key") api_key: String,
                       @Query("language") language: String,
                       @Query("query") query: String,
                       @Query("page") page: String,
                       @Query("include_adult") include_adult: String): Call<ResponseMovies>



}