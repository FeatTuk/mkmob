package com.example.vorovprmob.data

data class RecipesResponse(
    val items: List<items>,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int
)