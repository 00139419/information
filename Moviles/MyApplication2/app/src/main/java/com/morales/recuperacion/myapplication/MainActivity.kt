package com.morales.recuperacion.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var dolar_edit_text: EditText
    private lateinit var yuanes_edit_text: EditText
    private lateinit var action_btn_convert: Button
    private lateinit var preview_text_view: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        viewModel.dolares.observe(this){
            newDolares ->
            val dolares = newDolares.toString()
            dolar_edit_text.setText(dolares)
            preview_text_view.text = dolares

        }
        yuanes_edit_text.setText(viewModel.yuanes.toString())
        action_btn_convert.setOnClickListener {
            viewModel.dolares.value = dolar_edit_text.text.toString().toDouble()
            viewModel.dolares_to_yuanes()
            yuanes_edit_text.setText(viewModel.yuanes.toString())
        }
    }

    private fun bind(){
        dolar_edit_text = findViewById(R.id.text_input_dolares)
        yuanes_edit_text = findViewById(R.id.text_input_yuanes)
        action_btn_convert = findViewById(R.id.action_btn_convert)
        preview_text_view = findViewById(R.id.dolares_live)
    }
}