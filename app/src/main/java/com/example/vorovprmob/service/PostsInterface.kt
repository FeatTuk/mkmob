package com.example.vorovprmob.service

import com.example.vorovprmob.data.AddTodoRequest
import com.example.vorovprmob.data.PostsResponse
import com.example.vorovprmob.data.Todo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostsInterface {
    @GET("posts")
    suspend fun getPosts(): PostsResponse

    @POST("todos/add")
    suspend fun addTodo(@Body request: AddTodoRequest): Todo
}