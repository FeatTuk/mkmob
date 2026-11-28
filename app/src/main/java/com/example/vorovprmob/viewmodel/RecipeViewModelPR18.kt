package com.example.vorovprmob.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.afterpr18.Recipe
import com.example.vorovprmob.data.afterpr18.RecipesResponse
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModelPR18 : ViewModel() {

    val recipesList = mutableStateListOf<Recipe>()

    fun fetchRecipes(token: String) {
        viewModelScope.launch {
            try {
                val response: RecipesResponse = RetrofitClient.recipesAPI.getRecipes("Bearer $token")

                recipesList.clear()
                recipesList.addAll(response.items)

                Log.d("RecipesViewModel", "Загружено рецептов: ${response.totalItems}")
            } catch (e: Exception) {
                Log.e("RecipesDebug", "ОШИБКА: ${e.message}", e)
            }
        }
    }
}