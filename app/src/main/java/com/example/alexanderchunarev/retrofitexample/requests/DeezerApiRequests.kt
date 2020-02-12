package com.example.alexanderchunarev.retrofitexample.requests

import com.example.alexanderchunarev.retrofitexample.model.Album
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DeezerApiRequests {

    @GET("album/{id}")
    fun getAlbumById(@Path("id") id: Long) : Call<Album>
}