package com.morales.daniel.myapplication12th.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.morales.daniel.myapplication12th.data.Reposity.TermRepository
import java.lang.Exception

class DictionaryViewModelFactory(private val temRepository: TermRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DictionaryViewModel::class.java)){
            return DictionaryViewModel(temRepository) as T
        }

        throw Exception("unknow viewmodel class")
    }
}