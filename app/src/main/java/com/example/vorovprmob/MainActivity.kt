package com.example.vorovprmob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vorovprmob.data.Todo
import com.example.vorovprmob.viewmodel.PostViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: PostViewModel = viewModel()

            LaunchedEffect(Unit) {
                viewModel.fetchPosts()
                val todo = Todo(
                        todo = "Пропылесосить ковер",
                completed = false,
                userId = 31
                )
                viewModel.addTodo(todo)

                viewModel.taskProduct()
            }
        }
    }
}