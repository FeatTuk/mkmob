package com.example.vorovprmob.data.before18pr

data class PostsResponse(
    val posts: List<Post>,
    val total: Int,
    val skip: Int,
    val limit: Int
)