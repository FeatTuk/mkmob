package com.example.vorovprmob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
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

                viewModel.deleteProduct()

                viewModel.fetchPosts()

                viewModel.saveToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2xsZWN0aW9uSWQiOiJfcGJfdXNlcnNfYXV0aF8iLCJleHAiOjE3OTYzODM3MjYsImlkIjoiMXFtdWsxbHQxa3VqaDQzIiwicmVmcmVzaGFibGUiOnRydWUsInR5cGUiOiJhdXRoIn0.T4ly-Z--i8cmIeEjfXM897-RPVNK1pxLQJPWTHjChE8")

                viewModel.loadToken()


                viewModel.fetchRecipes()
            }

        }
    }
}