package com.example.vorovprmob.service

import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RecipesInterface {
    @POST("api/collections/users/auth-with-password")
    suspend fun auth(@Body body: Map<String, String>): ResponseBody

    @GET("api/collections/recipes/records")
    suspend fun getRecipesRaw(@Header("Authorization") token: String): ResponseBody
}