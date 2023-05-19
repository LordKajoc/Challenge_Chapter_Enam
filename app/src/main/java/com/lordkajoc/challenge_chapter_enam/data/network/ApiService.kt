package com.lordkajoc.challenge_chapter_enam.data.network

import com.lordkajoc.challenge_chapter_enam.model.DetailMovieItem
import com.lordkajoc.challenge_chapter_enam.model.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie/popular?api_key=10082fe9fdfeefb6c73522a0a8d82266&language=en-US&page=1")
    fun getPopularmovie(): Call<PopularMovieResponse>

    @GET("movie/{id}?api_key=10082fe9fdfeefb6c73522a0a8d82266")
    fun getMovieDetail(@Path("id") id: Int): Call<DetailMovieItem>

}