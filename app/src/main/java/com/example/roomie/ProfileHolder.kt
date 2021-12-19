package com.example.roomie

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class ProfileHolder: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_holder, container, false)
    }


    fun setValues(pic : Uri, usersName : String,  usersAge : String,  usersGender : String,  usersLgbt : String,  usersBio : String,  usersSmoke:String,  usersDrink : String,  usersPets: String,  usersClean : String,  dormOne : String,  dormTwo : String,  dormThree:String) {
        view?.findViewById<ImageView>(R.id.imageView7)?.setImageURI(pic)
        view?.findViewById<TextView>(R.id.textView6)?.text = usersName
        view?.findViewById<TextView>(R.id.textView7)?.text = usersAge
        view?.findViewById<TextView>(R.id.textView6)?.text = usersGender
        view?.findViewById<TextView>(R.id.textView5)?.text = usersLgbt
        view?.findViewById<TextView>(R.id.textView8)?.text = usersBio
        view?.findViewById<TextView>(R.id.textView9)?.text = usersSmoke
        view?.findViewById<TextView>(R.id.textView10)?.text = usersDrink
        view?.findViewById<TextView>(R.id.textView11)?.text = usersPets
        view?.findViewById<TextView>(R.id.textView12)?.text = usersClean
        view?.findViewById<TextView>(R.id.textView14)?.text = dormOne
        view?.findViewById<TextView>(R.id.textView13)?.text = dormTwo
        view?.findViewById<TextView>(R.id.textView15)?.text = dormThree
    }

}