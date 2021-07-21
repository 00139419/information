package com.morales.recuperacion.my4thapplication

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), score_fragment.onClickListeners{


    private var score_team_a: Int = 0
    private var score_team_b: Int = 0

    val input_score = score_fragment.newInstance("Equipo A", score_team_a)
    val output_score = score_fragment.newInstance("Equipo B", score_team_b)

    companion object{
        const val TEAM_A = "TEAM_A"
        const val TEAM_B = "TEAM_B"
        val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            score_team_a = it.getInt(TEAM_A, 0)
            score_team_b = it.getInt(TEAM_B, 0)
        }

        supporFragmentManager()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(TEAM_A, score_team_a)
        outState.putInt(TEAM_B, score_team_b)
        Log.d(TAG, "onSaveInstanceState")
    }

    private fun supporFragmentManager(){
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.input_layout, input_score)
        .replace(R.id.output_layout, output_score)
        .addToBackStack(null)
        .commit()

    }

    override fun add_score(team_name: String, new_score: Int) {
        when(team_name){
            "Equipo A" -> score_team_a = new_score
            "Equipo B" -> score_team_b = new_score
        }
    }

}//final
