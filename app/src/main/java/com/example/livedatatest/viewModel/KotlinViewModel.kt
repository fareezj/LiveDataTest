package com.example.livedatatest.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KotlinViewModel: ViewModel() {

    private val _secretNumber = MutableLiveData<String>()
    val secretNumber = _secretNumber as LiveData<String>

    var num = 1
    var numFinal = 0

    init {
        _secretNumber.value = "0"
    }

    fun addNum(view: View) {
        numFinal = num++
        _secretNumber.value = numFinal.toString()
        Log.i("LIVE", _secretNumber.value.toString())
    }

}