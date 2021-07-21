package com.morales.recuperacion.my6thapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class MainViewModel : ViewModel() {

    private var _message = MutableLiveData<String>("")

    val message: LiveData<String>
        get() = _message

    fun setMessage(messsage: String){
        _message.value = messsage
    }


    init {
        _message.value = ""
    }


}