package com.example.vorovprmob.data

data class Product(
    val id: Int? = null,
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>
)