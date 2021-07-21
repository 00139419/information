package com.morales.recuperacion.my6thapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.observe

class MainActivity : AppCompatActivity() {

    private val view_model_object: MainViewModel by viewModels()

    private lateinit var input_edit_text: EditText
    private lateinit var text_view_original: TextView
    private lateinit var text_view_mayusculas: TextView
    private lateinit var text_view_minusculas: TextView
    private lateinit var text_view_reemplazar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        input_edit_text.setText(view_model_object.message.value)
        input_edit_text.doAfterTextChanged {
            view_model_object.setMessage(it.toString())
        }

        view_model_object.message.observe(this){
            text_view_original.text = it
        }



    }

    private fun bind(){
        input_edit_text = findViewById(R.id.input_edit_text)
        text_view_original = findViewById(R.id.textView_original)
        text_view_mayusculas = findViewById(R.id.textView_mayusculas)
        text_view_minusculas = findViewById(R.id.textView_minusculas)
        text_view_reemplazar = findViewById(R.id.textView_reemplazar)
    }
}