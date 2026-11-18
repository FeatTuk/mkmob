package com.example.vorovprmob.data

data class RecipesResponse(
    val items: List<Recipe>,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int
)