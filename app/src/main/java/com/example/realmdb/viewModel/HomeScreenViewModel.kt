package com.example.realmdb.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {

    var color by mutableStateOf(Color.Green)
        private set


    fun changeBackground() {
        color = Color.Blue
    }

}