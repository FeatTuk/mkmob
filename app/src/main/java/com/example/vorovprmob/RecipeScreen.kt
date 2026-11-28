package com.example.vorovprmob

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vorovprmob.ui.PR20.RecipeCard
import com.example.vorovprmob.viewmodel.RecipeViewModelPR18

@Composable
fun RecipeScreen(viewModel: RecipeViewModelPR18) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(viewModel.recipesList) { recipe ->
            RecipeCard(recipe = recipe)
        }
    }
}