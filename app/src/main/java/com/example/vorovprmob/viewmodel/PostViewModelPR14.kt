package com.example.vorovprmob.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.before18pr.Post
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModelPR14 : ViewModel() {
    val postsList = mutableStateListOf<Post>()

    fun fetchPosts() {
        viewModelScope.launch {
            val response = RetrofitClient.postsAPI.getPosts()
            response.posts.forEach { post ->
                Log.d("PostsViewModel", "\ntitle:${post.title} \nbody:${post.body} \nreactions:${post.reactions}\n")
            }
            postsList.clear()
            postsList.addAll(response.posts)
        }
    }
}