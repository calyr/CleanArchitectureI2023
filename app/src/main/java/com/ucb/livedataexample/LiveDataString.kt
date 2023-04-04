package com.ucb.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LiveDataString {

    val model: LiveData<String>
        get() {
            return _model
        }
    private val _model = MutableLiveData<String>()

    fun changeValue(value: String) {
        _model.value = value
    }
}