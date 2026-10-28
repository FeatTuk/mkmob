package com.example.vorovprmob.data

data class Todo(
    val id: Int? = null,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)