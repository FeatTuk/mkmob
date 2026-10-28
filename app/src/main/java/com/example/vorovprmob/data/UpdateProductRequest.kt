package com.example.vorovprmob.data

data class UpdateProductRequest(
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>
)