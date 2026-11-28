package com.example.vorovprmob.service.before18

import com.example.vorovprmob.data.before18pr.PostsResponse
import retrofit2.http.GET

interface PostsInterface {
    @GET("posts")
    suspend fun getPosts(): PostsResponse
}