package com.morales.daniel.myapplication12th.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.morales.daniel.myapplication12th.data.Reposity.TermRepository
import com.morales.daniel.myapplication12th.data.entity.Term
import kotlinx.coroutines.launch

class DictionaryViewModel(private val termRepository: TermRepository): ViewModel() {

    val wordInput = MutableLiveData("")
    val descriptionInput = MutableLiveData("")

    fun onSubmit(){
        viewModelScope.launch {
            if(!wordInput.value.isNullOrEmpty() && !descriptionInput.value.isNullOrEmpty()){
                val new_term = Term(wordInput.value!!, descriptionInput.value!!)
                termRepository.insert_or_replace(new_term)
                wordInput.value = ""
                descriptionInput.value = ""
            }
        }
    }
}