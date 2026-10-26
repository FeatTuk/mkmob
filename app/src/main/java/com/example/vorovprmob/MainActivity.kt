package com.example.vorovprmob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vorovprmob.viewmodel.PostViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: PostViewModel = viewModel()

            LaunchedEffect(Unit) {
                viewModel.fetchPosts()
                viewModel.addTodo()
            }

            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Text(text = "\nЗадание 15: ${viewModel.addedTodo.value}")

                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(viewModel.postsList) { post ->
                        Text(text = "\n\ntitle:${post.title}\n \nbody:${post.body}\n \nreactions:${post.reactions}")
                    }
                }
            }
        }
    }
}