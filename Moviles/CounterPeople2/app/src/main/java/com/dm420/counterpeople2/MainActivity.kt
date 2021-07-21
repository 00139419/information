package com.dm420.counterpeople2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dm420.counterpeople2.counter_fragment.counterFragment

class MainActivity : AppCompatActivity(){

    val in_counter_fragment = counterFragment()
    val out_counter_fragment = counterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.counter_in, in_counter_fragment)
            .replace(R.id.counter_out, out_counter_fragment)
            .addToBackStack(null)
            .commit()

    }


}