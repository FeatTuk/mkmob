package com.example.vorovprmob.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.before18pr.Todo
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class TodoViewModelPR15 : ViewModel() {
    val addedTodo = mutableStateOf<Todo?>(null)

    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            val response = RetrofitClient.todosAPI.addTodo(todo)
            addedTodo.value = response
            Log.d("TodosViewModel", "\nid:${response.id} \ntodo:${response.todo} \ncompleted:${response.completed} \nuserId:${response.userId}")
        }
    }
}