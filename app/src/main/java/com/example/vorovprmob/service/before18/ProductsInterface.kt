package com.example.vorovprmob.service.before18

import com.example.vorovprmob.data.before18pr.Product
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductsInterface {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product

    @PUT("products/{id}")
    suspend fun updateProduct(
        @Path("id") id: Int,
        @Body original: Product
    ): Product

    @DELETE("products/{id}")
    suspend fun delProduct(@Path("id") id: Int,
       ): Product
}