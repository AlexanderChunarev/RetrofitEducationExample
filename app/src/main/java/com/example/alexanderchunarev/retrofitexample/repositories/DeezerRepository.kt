package com.example.alexanderchunarev.retrofitexample.repositories

import com.example.alexanderchunarev.retrofitexample.builders.ServiceBuilder
import com.example.alexanderchunarev.retrofitexample.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeezerRepository {
    private val serviceBuilder by lazy { ServiceBuilder.getInstance() }

    suspend fun fetchAlbumById(id: Long): Album = withContext(Dispatchers.IO) {
        var album: Album
        serviceBuilder.buildService().apply {
            album = getAlbumById(id).execute().body()!!
        }
        album
    }
}