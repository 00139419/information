package com.morales.recuperacion.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var dolares = MutableLiveData<Double>(0.0)
    var yuanes = 0.0
    private val tasa_de_convercion = 0.15

    fun dolares_to_yuanes(){
        yuanes = dolares.value?.times(tasa_de_convercion)?: yuanes
    }
}