package com.example.vorovprmob.service.before18

import com.example.vorovprmob.data.before18pr.Todo
import retrofit2.http.Body
import retrofit2.http.POST

interface TodosInterface {
    @POST("todos/add")
    suspend fun addTodo(@Body request: Todo): Todo
}