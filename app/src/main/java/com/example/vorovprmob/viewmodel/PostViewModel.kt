package com.example.vorovprmob.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.AddTodoRequest
import com.example.vorovprmob.data.Post
import com.example.vorovprmob.data.Todo
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    val postsList = mutableStateListOf<Post>()
    val addedTodo = mutableStateOf<Todo?>(null)

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.retrofitAPI.getPosts()
                postsList.clear()
                postsList.addAll(response.posts)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addTodo() {
        viewModelScope.launch {
            try {
                val request = AddTodoRequest(
                    todo = "Пропылесосить ковер",
                    completed = false,
                    userId = 31
                )
                addedTodo.value = RetrofitClient.retrofitAPI.addTodo(request)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}