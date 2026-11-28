package com.example.vorovprmob

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.vorovprmob.ui.theme.Typography // <-- Импорт
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vorovprmob.ui.AuthScreen
import com.example.vorovprmob.viewmodel.PostViewModelPR14
import com.example.vorovprmob.viewmodel.TodoViewModelPR15
import com.example.vorovprmob.viewmodel.ProductViewModelPR16And17
import com.example.vorovprmob.viewmodel.RecipeViewModelPR18
import com.example.vorovprmob.viewmodel.TokenViewModelPR19

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(typography = Typography) {

                val postVm: PostViewModelPR14 = viewModel()
                val todoVm: TodoViewModelPR15 = viewModel()
                val productVm: ProductViewModelPR16And17 = viewModel()
                val recipeVm: RecipeViewModelPR18 = viewModel()
                val tokenVm: TokenViewModelPR19 = viewModel()
                var isLoggedIn by remember { mutableStateOf(false) }

                if (!isLoggedIn) {
                    AuthScreen(
                        onLoginClick = { email, password ->
                            tokenVm.getOrCreateToken(
                                identity = email,
                                password = password
                            ) { token ->
                                recipeVm.fetchRecipes(token)

                                isLoggedIn = true
                            }
                        }
                    )
                } else {
                    RecipeScreen(viewModel = recipeVm)
                }

            }
        }
    }
}