package com.example.toolyttask.data.remote

import com.example.toolyttask.data.remote.dto.ApiResponse
import com.example.toolyttask.data.remote.dto.Login
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    companion object {
        const val BASE_URL_WALLPAPER = "http://example.com"
    }

    @POST("/api/login")
    suspend fun sendDataToApi(@Body data: Login): ApiResponse
}