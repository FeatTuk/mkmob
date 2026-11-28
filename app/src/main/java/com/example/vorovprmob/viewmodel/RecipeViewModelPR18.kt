package com.example.vorovprmob.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.afterpr18.RecipesResponse
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModelPR18 : ViewModel() {

    fun fetchRecipes(token: String) {
        viewModelScope.launch {
            try {
                val response: RecipesResponse = RetrofitClient.recipesAPI.getRecipes("Bearer $token")
                Log.d("RecipesViewModel", "\npage: ${response.page} \nperPage: ${response.perPage} \ntotalItems: ${response.totalItems} \ntotalPages: ${response.totalPages}\n")

                response.items.forEach { item ->
                    Log.d("RecipesViewModel", "\ndifficulty: ${item.difficulty}   ///   name: ${item.name}")
                }
            } catch (e: Exception) {
                Log.e("RecipesDebug", "ОШИБКА: ${e.message}", e)
            }
        }
    }
}