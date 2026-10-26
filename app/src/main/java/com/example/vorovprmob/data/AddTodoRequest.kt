package com.example.vorovprmob.data

data class AddTodoRequest(
    val todo: String,
    val completed: Boolean,
    val userId: Int
)