package com.example.roomie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
//Author: Lauren
open class NavBar : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nav_bar, container, false)
        val mesBut = view.findViewById<Button>(R.id.messageNav)
        val profBut = view.findViewById<Button>(R.id.profileNav)
        val matchBut = view.findViewById<Button>(R.id.findMatch)

        mesBut?.setOnClickListener{
            startActivity(Intent(activity, Matches::class.java))
        }
        profBut?.setOnClickListener{
            startActivity(Intent(activity, Profile::class.java))
        }
        matchBut?.setOnClickListener{
            startActivity(Intent(activity, Swipe::class.java))
        }

        return view
    }

}