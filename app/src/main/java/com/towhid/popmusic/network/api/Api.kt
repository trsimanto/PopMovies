package com.chaadride.network.api

import com.towhid.popmusic.network.model.movie_details.response.MovieDetailsRes
import com.towhid.popmusic.network.model.movie_list.response.MovieListRes
import com.towhid.popmusic.network.model.trailer.response.MovieTrailerRes
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("3/movie/popular")
    fun MovieListRes_(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<MovieListRes>

    @GET("3/movie/{movie_id}")
    fun MovieDetailsRes_(
        @Path("movie_id") movie_id: Long,
        @Query("api_key") api_key: String
    ): Call<MovieDetailsRes>

    @GET("3/movie/{movie_id}/videos")
    fun MovieTrailerRes_(
        @Path("movie_id") movie_id: Long,
        @Query("api_key") api_key: String
    ): Call<MovieTrailerRes>

}


