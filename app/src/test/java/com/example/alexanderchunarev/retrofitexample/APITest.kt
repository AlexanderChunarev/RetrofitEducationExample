package com.example.alexanderchunarev.retrofitexample

import com.example.alexanderchunarev.retrofitexample.builders.ServiceBuilder
import com.example.alexanderchunarev.retrofitexample.repositories.DeezerRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class APITest {
    private lateinit var serviceBuilder: ServiceBuilder
    private lateinit var repository: DeezerRepository

    companion object {
        private const val ID =           302127
        private const val ALBUM_SIZE = 14
        private const val ALBUM_TITLE = "Discovery"
    }

    @Before
    fun init() {
        serviceBuilder = ServiceBuilder.getInstance()
        repository = DeezerRepository()
    }

    @Test
    fun fetch_albums_from_api_test() {
        runBlocking {
            val album = repository.fetchAlbumById(ID.toLong())
            show(album.data.tracks) // show all tracks

            Assert.assertEquals(ID.toLong(), "")
            Assert.assertEquals(ALBUM_TITLE, album.title)
            Assert.assertEquals(ALBUM_SIZE, album.data.tracks.size)
        }
    }

    private fun <T> show(list: List<T>) {
        list.forEach {
            println(it)
        }
    }
}