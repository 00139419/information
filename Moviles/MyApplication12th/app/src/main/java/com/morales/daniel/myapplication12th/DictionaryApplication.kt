package com.morales.daniel.myapplication12th

import android.app.Application
import com.morales.daniel.myapplication12th.data.DictionaryDataBase
import com.morales.daniel.myapplication12th.data.Reposity.TermRepository

class DictionaryApplication: Application() {

    private val database by lazy {
    DictionaryDataBase.getDataBase(this)
    }

    val termRepository by lazy {
        val termDao = database.termDao()
        TermRepository(termDao)
    }

}