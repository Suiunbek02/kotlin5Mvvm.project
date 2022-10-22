package com.example.kotlin5mvvmproject

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val data: MutableLiveData<Int> = MutableLiveData()

    var count: Int = 0
    var color: Int = 0

    fun minus() {
        count--
        data.value = count
    }

    fun plus() {
        count++
        data.value = count
    }
    fun сolor(){
        data.value = color
    }


}