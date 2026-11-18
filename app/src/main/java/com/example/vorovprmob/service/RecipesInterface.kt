package com.example.vorovprmob.service

import com.example.vorovprmob.data.RecipesResponse
import retrofit2.http.GET

interface RecipesInterface {
    @GET("api/collections/recipes/records")
    suspend fun getRecipes(): RecipesResponse
}