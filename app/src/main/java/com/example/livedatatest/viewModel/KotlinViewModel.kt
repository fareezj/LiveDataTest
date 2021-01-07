package com.example.livedatatest.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.*

class KotlinViewModel: ViewModel() {

    private val _secretNumber = MutableLiveData<String>()
    val secretNumber = _secretNumber as LiveData<String>

    private val _primeNumber = MutableLiveData<String>()
    val primeNumber: LiveData<String> = _primeNumber

    var num = 1
    var numFinal = 0

    init {
        _secretNumber.value = "HELLLO"
        _primeNumber.value = "1"
    }

    val isLoading: LiveData<String> = combinedLiveData(listOf(_secretNumber, _primeNumber))

    private fun combinedLiveData(inputs: List<LiveData<String>>): LiveData<String> {

        val result = MediatorLiveData<String>()

        val doCalculation = Observer<String> {
            result.value = inputs.any { it.value == "HELLLO" }.toString()
        }
        inputs.forEach {
            result.addSource(it, doCalculation)
        }
        return result
    }

    fun addNum(view: View) {
        numFinal = num++
        _secretNumber.value = numFinal.toString()
        Log.i("LIVE", _secretNumber.value.toString())
    }

}