package com.morales.recuperacion.my4thapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.lang.Exception
import java.time.Instant

class score_fragment : Fragment(){

    private val TITTLE_NAME = "TITTLE_NAME"
    private val SCORE = "SCORE"

    private var Team_name = "Sin no"
    private var Team_score = 0

    private var score_listener: onClickListeners? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is onClickListeners){
            score_listener = context
        }else{
            throw Exception("Se necesita una implementacion de onClickListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            Team_name = it.getString(TITTLE_NAME)?: Team_name
            Team_score = it.getInt(SCORE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.score_fragment, container, false)
        val team_name_text_view = view.findViewById<TextView>(R.id.Team_name_text_view)
        val team_score_text_view = view.findViewById<TextView>(R.id.score_value_text_view)

        team_name_text_view.text = Team_name
        team_score_text_view.text = Team_score.toString()

        val add_one = view.findViewById<Button>(R.id.action_btn_add_one)

        add_one.setOnClickListener {
             Team_score + 1
            team_score_text_view.text = Team_score.toString()
            score_listener?.add_score(Team_name, Team_score)
        }
        return view
    }

companion object{
    fun newInstance(tittle_name:String, score: Int) = score_fragment().apply {
        arguments = Bundle().apply {
            putString(TITTLE_NAME, tittle_name)
            putInt(SCORE,score)
        }
    }
}
    interface onClickListeners{
        fun add_score(team_name: String, new_score: Int)
    }
}