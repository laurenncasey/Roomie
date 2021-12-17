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




       val user: User? = activity?.intent?.getParcelableExtra("passedValue")





        mesBut?.setOnClickListener{
            val intent = Intent(activity?.applicationContext, Matches::class.java)
            val bundle = Bundle()
           bundle.putParcelable("passedValue", user)
            intent.putExtra("passed", bundle)
            startActivity(intent)
        }
        profBut?.setOnClickListener{
            val intent = Intent(activity?.applicationContext, Profile::class.java)
            val bundle = Bundle()
           bundle.putParcelable("passedValue", user)
            intent.putExtra("passed", bundle)
            startActivity(intent)
        }
        matchBut?.setOnClickListener{
            val intent = Intent(activity?.applicationContext, Swipe::class.java)
            val bundle = Bundle()
           bundle.putParcelable("passedValue", user)
            intent.putExtra("passed", bundle)
            startActivity(intent)
        }

        return view
    }

}