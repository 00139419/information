package com.dm420.counterpeople2.counter_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.convertTo
import androidx.fragment.app.Fragment
import com.dm420.counterpeople2.R

class counterFragment : Fragment(){

    private  var caption_option: String = "Entrada"
    private  var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            with(it){
                caption_option = getString("CAPTION_OPTION").toString()
                counter = getInt("COUNTER")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.counter_fragment, container, false).apply {
            findViewById<TextView>(R.id.textInput_counter).text = caption_option
            var counterTextView = findViewById<TextView>(R.id.score)
            counterTextView.text = counter.toString()

        }

        return view
    }
}