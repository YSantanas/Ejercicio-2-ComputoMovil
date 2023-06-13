package com.myss.regulus.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bienvenidos a Hogwarts"
    }
    val text: LiveData<String> = _text
}