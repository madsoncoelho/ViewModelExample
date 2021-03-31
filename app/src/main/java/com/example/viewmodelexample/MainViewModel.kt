package com.example.viewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var mldCounter = MutableLiveData<String>().apply { value = counter.toString() }
    private var counter: Int = 0

    private fun setCounter() {
        mldCounter.value = counter.toString()
    }

    private fun validateCounter() {
        counter++
        if (counter > 5) {
            counter = 0
        }

        setCounter()
    }

    fun incrementCounter() {
        validateCounter()
    }
}