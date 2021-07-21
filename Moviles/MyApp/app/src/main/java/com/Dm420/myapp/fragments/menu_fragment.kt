package com.Dm420.myapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.Dm420.myapp.R
import java.lang.Exception

class menu_fragment : Fragment(){

    lateinit var tools: onClickHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is onClickHandler){
            tools = context
        }else{
            throw Exception("required an implementation of onClickHandel")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        view.findViewById<Button>(R.id.Action_btn).setOnClickListener {
            tools.onClickConteinerBtn()
        }

        return view
    }

    interface  onClickHandler {
        fun onClickConteinerBtn()
    }

}
