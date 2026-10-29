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
    val taskerProduct = mutableStateOf<Product?>(null)
    //PR14
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
    //PR15
    fun addTodo(
        todo: Todo
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
    //PR16
    fun taskProduct() {
        viewModelScope.launch {
            val original = RetrofitClient.productsAPI.getProductById(48)
            original.value = original
            Log.d(
                "ProductsViewModel",
                "PR16 ДО: \ntitle:${original.title} \ndescription:${original.description} \ncategory:${original.category} \ntags:${original.tags}"
            )

            val request = Product(
                title = "Беспроводные наушники SoundWave Pro",
                description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                category = "Аудиотехника",
                tags = listOf("Наушники", "bluetooth", "шумоподавление", "беспроводные наушники", "гаджеты"
                )
            )
            val updated = RetrofitClient.productsAPI.updateProduct(48, request)
            updated.value = updated
            Log.d(
                "ProductsViewModel",
                "ПОСЛЕ: \ntitle:${updated.title} \ndescription:${updated.description} \ncategory:${updated.category} \ntags:${updated.tags}"
            )




                //pr17
            val original17 = RetrofitClient.productsAPI.getProductById(25)
            original17.value = original
            Log.d(
                "ProductsViewModel",
                "PR17 ДО: \ntitle:${original.title} \ndescription:${original.description} \ncategory:${original.category} \ntags:${original.tags}"
            )
            val delreq = Product(
                title = "",
                description = "",
                category = "",
                tags = listOf(""
                )
            )
            val deleted = RetrofitClient.productsAPI.updateProduct(48, delreq)
            deleted.value = deleted
            Log.d(
                "ProductsViewModel",
                "ПОСЛЕ: \ntitle:${deleted.title} \ndescription:${deleted.description} \ncategory:${deleted.category} \ntags:${deleted.tags}"
            )
        }
    }
}
