package com.example.vorovprmob.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.vorovprmob.data.AuthRequest
import com.example.vorovprmob.data.TokenDataStore
import com.example.vorovprmob.service.RetrofitClient
import kotlinx.coroutines.launch

class TokenViewModelPR19(application: Application) : AndroidViewModel(application) {
    private val tokenStore = TokenDataStore(application)
    fun getOrCreateToken(identity: String, password: String, onTokenReady: (String) -> Unit) {
        viewModelScope.launch {
            var token = tokenStore.getToken()

            if (token.isNullOrEmpty()) {
                val authResponse = RetrofitClient.recipesAPI.auth(
                    AuthRequest(identity = identity, password = password)
                )
                token = authResponse.token
                tokenStore.saveToken(token)
                Log.d("Token", "Токен получен через авторизацию и сохранен")
            } else {
                Log.d("Token", "Использован сохраненный токен")
            }

            onTokenReady(token)
        }
    }
}