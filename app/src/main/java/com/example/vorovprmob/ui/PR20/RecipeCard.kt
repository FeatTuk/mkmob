package com.example.vorovprmob.ui.PR20

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vorovprmob.data.afterpr18.Recipe

@Composable
fun RecipeCard(recipe: Recipe) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            ) {
            RecipeRow(label = "Product:", value = recipe.name)
            RecipeRow(label = "Difficulty:", value = recipe.difficulty)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF3F4F6, widthDp = 350)
@Composable
fun RecipeCardPreview() {
    val fakeRecipe = Recipe(
        id = "1",
        name = "Mambo",
        difficulty = "Easy",
        created = "",
        updated = ""
    )
    RecipeCard(recipe = fakeRecipe)
}