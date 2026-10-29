package com.example.vorovprmob.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val httpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val postsAPI: PostsInterface = retrofit.create(PostsInterface::class.java)
    val todosAPI: TodosInterface = retrofit.create(TodosInterface::class.java)
    val productsAPI: ProductsInterface = retrofit.create(ProductsInterface::class.java)
}