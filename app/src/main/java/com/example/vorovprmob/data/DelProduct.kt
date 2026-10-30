package com.example.vorovprmob.data

data class DelProduct(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>,
    val isDeleted: Boolean,
    val deletedOn: String
) {
    companion object {
        lateinit var value: DelProduct
    }
}