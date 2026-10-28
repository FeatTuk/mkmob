package com.example.vorovprmob.service

import com.example.vorovprmob.data.PostsResponse
import com.example.vorovprmob.data.Product
import com.example.vorovprmob.data.Todo
import com.example.vorovprmob.data.UpdateProductRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostsInterface {
    @GET("posts")
    suspend fun getPosts(): PostsResponse

    @POST("todos/add")
    suspend fun addTodo(@Body request: Todo): Todo

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product

    @PUT("products/{id}")
    suspend fun updateProduct(
        @Path("id") id: Int,
        @Body request: UpdateProductRequest
    ): Product
}