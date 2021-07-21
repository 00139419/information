package com.Dm420.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.Dm420.myapp.fragments.menu_fragment
import com.Dm420.myapp.fragments.message_fragment
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), menu_fragment.onClickHandler {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu_fragment = menu_fragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_menu, menu_fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onClickConteinerBtn() {
        val message_fragment = message_fragment()
        var phone = resources.getBoolean(R.bool.phone)

        if(phone){

        val intent = Intent(this, message_Activity :: class.java)
            startActivity(intent)

        }else{

            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_message, message_fragment)
                    .addToBackStack(null)
                    .commit()
        }
    }

}
