package com.example.vorovprmob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vorovprmob.data.before18pr.Todo
import com.example.vorovprmob.viewmodel.PostViewModelPR14
import com.example.vorovprmob.viewmodel.TodoViewModelPR15
import com.example.vorovprmob.viewmodel.ProductViewModelPR16And17
import com.example.vorovprmob.viewmodel.RecipeViewModelPR18
import com.example.vorovprmob.viewmodel.TokenViewModelPR19

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val postVm: PostViewModelPR14 = viewModel()
            val todoVm: TodoViewModelPR15 = viewModel()
            val productVm: ProductViewModelPR16And17 = viewModel()
            val recipeVm: RecipeViewModelPR18 = viewModel()
            val tokenVm: TokenViewModelPR19 = viewModel()

            LaunchedEffect(Unit) {
                // PR14
                postVm.fetchPosts()
                // PR15
                val todo = Todo(todo = "Пропылесосить ковер", completed = false, userId = 31)
                todoVm.addTodo(todo)
                // PR16-PR17
                productVm.taskProduct()
                productVm.deleteProduct()
                // PR18-19
                tokenVm.getOrCreateToken(
                    identity = "featytuk@mail.com",
                    password = "123456780"
                ) { token ->
                    recipeVm.fetchRecipes(token)
                }
            }
        }
    }
}