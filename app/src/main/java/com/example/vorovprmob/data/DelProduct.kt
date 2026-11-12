package com.example.vorovprmob.data

data class DelProduct(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>,
    val isDeleted: Boolean,
) {
    lateinit var value: Product

}