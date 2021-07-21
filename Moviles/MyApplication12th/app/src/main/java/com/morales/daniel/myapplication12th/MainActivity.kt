package com.morales.daniel.myapplication12th

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.morales.daniel.myapplication12th.databinding.ActivityMainBinding
import com.morales.daniel.myapplication12th.ui.DictionaryViewModel
import com.morales.daniel.myapplication12th.ui.DictionaryViewModelFactory

class MainActivity : AppCompatActivity() {

    private val dicApp by lazy {
        application as DictionaryApplication
    }

    val DictionaryViewModelFactory:DictionaryViewModelFactory by lazy {
    DictionaryViewModelFactory(dicApp.termRepository)
    }

    val DictionaryViewModel: DictionaryViewModel by viewModels {
        DictionaryViewModelFactory
    }

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewmodel = DictionaryViewModel
            lifecycleOwner = this@MainActivity
        }

    }

}