package com.example.vorovprmob.service

import com.example.vorovprmob.data.Todo
import retrofit2.http.Body
import retrofit2.http.POST

interface TodosInterface {
    @POST("todos/add")
    suspend fun addTodo(@Body request: Todo): Todo
}