package com.example.vorovprmob.service

import com.example.vorovprmob.service.afterpr18.RecipesInterface
import com.example.vorovprmob.service.before18.PostsInterface
import com.example.vorovprmob.service.before18.ProductsInterface
import com.example.vorovprmob.service.before18.TodosInterface
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val httpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
        .addInterceptor(logging)
        .build()


    val retrofit: Retrofit = Retrofit.Builder()

        .baseUrl("https://dummyjson.com/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val recipesRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.207.106.59:8090/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val postsAPI: PostsInterface = retrofit.create(PostsInterface::class.java)
    val todosAPI: TodosInterface = retrofit.create(TodosInterface::class.java)
    val productsAPI: ProductsInterface = retrofit.create(ProductsInterface::class.java)
    val recipesAPI: RecipesInterface = recipesRetrofit.create(RecipesInterface::class.java)

}