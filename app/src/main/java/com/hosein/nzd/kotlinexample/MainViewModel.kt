package com.hosein.nzd.nikestore

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(httpClient: HttpClient) : ViewModel() {
    var value = 0
    fun addToValue() {
        value += 2
        Log.i("MainViewModel", "addToValue: $value")
    }
}