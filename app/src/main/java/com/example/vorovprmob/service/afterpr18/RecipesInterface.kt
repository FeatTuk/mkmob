package com.example.vorovprmob.service.afterpr18

import com.example.vorovprmob.data.AuthRequest
import com.example.vorovprmob.data.AuthResponse
import com.example.vorovprmob.data.afterpr18.RecipesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RecipesInterface {
    @POST("api/collections/users/auth-with-password")
    suspend fun auth(@Body body: AuthRequest): AuthResponse

    @GET("api/collections/recipes/records")
    suspend fun getRecipes(@Header("Authorization") auth: String): RecipesResponse
}