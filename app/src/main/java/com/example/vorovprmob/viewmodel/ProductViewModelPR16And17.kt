package com.example.vorovprmob.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.before18pr.Product
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModelPR16And17 : ViewModel() {

    fun taskProduct() {
        viewModelScope.launch {
            var original = RetrofitClient.productsAPI.getProductById(48)
            Log.d("ProductsViewModel", "pr16 до: \nid:${original.id} \ntitle:${original.title} \ndescription:${original.description} \ncategory:${original.category} \ntags:${original.tags}")

            original = RetrofitClient.productsAPI.updateProduct(
                48,
                Product(
                    title = "Беспроводные наушники SoundWave Pro",
                    description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                    category = "Аудиотехника",
                    tags = listOf("Наушники", "bluetooth", "шумоподавление", "беспроводные наушники", "гаджеты")
                )
            )
            Log.d("ProductsViewModel", "pr16 после: \nid:${original.id} \ntitle:${original.title} \ndescription:${original.description} \ncategory:${original.category} \ntags:${original.tags}")
        }
    }
    fun deleteProduct() {
        viewModelScope.launch {
            val deleted = RetrofitClient.productsAPI.delProduct(25)
            Log.d("ProductsViewModel", "pr17 статус удаления=${deleted.isDeleted}")
        }
    }
}