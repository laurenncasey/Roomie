package com.example.roomie


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase


/**
 * Author: Lauren Casey
 */
 class Swipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)
        val db = FirebaseDatabase.getInstance().reference
        val frag = Fragment(R.layout.fragment_profile_holder)


        fun nextFrag(){

        }
        val accept = findViewById<FloatingActionButton>(R.id.yes)
        val decline = findViewById<FloatingActionButton>(R.id.no)

        accept?.setOnClickListener {
            //add person to yes's and move on
            nextFrag()
        }
        decline?.setOnClickListener {
            //add person to no's and move on
            nextFrag()
        }

         //Toast.makeText(applicationContext, "Username set.", Toast.LENGTH_SHORT).show()
   }

}




