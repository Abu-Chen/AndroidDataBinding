package com.abu.androiddatabinding.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel


class MainViewModel() : ViewModel() {
    val data = ObservableField("Input...")

    val content = ObservableField("Input...")
}