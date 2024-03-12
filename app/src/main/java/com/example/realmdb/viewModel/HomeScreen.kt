package com.example.realmdb.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen() {
    val viewModel = viewModel<HomeScreenViewModel>()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = viewModel.color),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { viewModel.changeBackground() }) {
            Text(text = "Change background")
        }
    }
}