package com.example.vorovprmob.service

import com.example.vorovprmob.data.PostsResponse
import retrofit2.http.GET

interface PostsInterface {
    @GET("posts")
    suspend fun getPosts(): PostsResponse
}