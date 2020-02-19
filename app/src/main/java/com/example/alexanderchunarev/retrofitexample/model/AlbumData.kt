package com.example.alexanderchunarev.retrofitexample.model

import com.squareup.moshi.Json

data class AlbumData(
    @Json(name = "data")
    val tracks: List<Track>
)