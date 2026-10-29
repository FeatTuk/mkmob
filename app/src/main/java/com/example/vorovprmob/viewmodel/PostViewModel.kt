package com.example.vorovprmob.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.Post
import com.example.vorovprmob.data.Product
import com.example.vorovprmob.data.Todo
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    val postsList = mutableStateListOf<Post>()
    val addedTodo = mutableStateOf<Todo?>(null)
    val originalProduct = mutableStateOf<Product?>(null)
    val updatedProduct = mutableStateOf<Product?>(null)

    fun fetchPosts() {
        viewModelScope.launch {
            val response = RetrofitClient.postsAPI.getPosts()

            response.posts.forEach { post ->
                Log.d(
                    "PostsViewModel",
                    "\ntitle:${post.title} \nbody:${post.body} \nreactions:${post.reactions}\n"
                )
            }
            postsList.clear()
            postsList.addAll(response.posts)
        }
    }

    fun addTodo(
        todo: Todo = Todo(
            todo = "Пропылесосить ковер",
            completed = false,
            userId = 31
        )
    ) {
        viewModelScope.launch {
            val response = RetrofitClient.todosAPI.addTodo(todo)
            addedTodo.value = response
            Log.d(
                "TodosViewModel",
                "\nid:${response.id} \ntodo:${response.todo} \ncompleted:${response.completed} \nuserId:${response.userId}"
            )
        }
    }

    fun taskProduct() {
        viewModelScope.launch {
            val original = RetrofitClient.productsAPI.getProductById(48)
            originalProduct.value = original
            Log.d(
                "ProductsViewModel",
                "ДО: title:${original.title} | description:${original.description} | category:${original.category} | tags:${original.tags}"
            )

            val request = Product(
                title = "Беспроводные наушники SoundWave Pro",
                description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                category = "Аудиотехника",
                tags = listOf(
                    "Наушники",
                    "bluetooth",
                    "шумоподавление",
                    "беспроводные наушники",
                    "гаджеты"
                )
            )
            val updated = RetrofitClient.productsAPI.updateProduct(48, request)
            updatedProduct.value = updated
            Log.d(
                "ProductsViewModel",
                "ПОСЛЕ: title:${updated.title} | description:${updated.description} | category:${updated.category} | tags:${updated.tags}"
            )
        }
    }
}