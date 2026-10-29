package com.example.vorovprmob.service

import com.example.vorovprmob.data.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsInterface {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}