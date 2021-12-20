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


    fun setValues(pic: Uri, usersName: String, usersAge: String, usersGender: Int, usersLgbt: Int, usersBio: String, usersSmoke: Int, usersDrink: Int, usersPets: Int, usersClean: Int, dormOne: Int, dormTwo: Int, dormThree: Int) {
        view?.findViewById<ImageView>(R.id.imageView7)?.setImageURI(pic)
        view?.findViewById<TextView>(R.id.textView6)?.text = usersName
        view?.findViewById<TextView>(R.id.textView7)?.text = usersAge
        view?.findViewById<TextView>(R.id.textView6)?.text = resources.getStringArray(R.array.genderAr)[usersGender]
        view?.findViewById<TextView>(R.id.textView5)?.text = resources.getStringArray(R.array.lgbtAr)[usersLgbt]
        view?.findViewById<TextView>(R.id.textView8)?.text = usersBio
        view?.findViewById<TextView>(R.id.textView9)?.text = resources.getStringArray(R.array.smokesAr)[usersSmoke]
        view?.findViewById<TextView>(R.id.textView10)?.text = resources.getStringArray(R.array.drinksAr)[usersDrink]
        view?.findViewById<TextView>(R.id.textView11)?.text = resources.getStringArray(R.array.petsAr)[usersPets]
        view?.findViewById<TextView>(R.id.textView12)?.text = resources.getStringArray(R.array.cleanDirtyAr)[usersClean]
        view?.findViewById<TextView>(R.id.textView14)?.text = resources.getStringArray(R.array.dorms1)[dormOne]
        view?.findViewById<TextView>(R.id.textView13)?.text = resources.getStringArray(R.array.dorms1)[dormTwo]
        view?.findViewById<TextView>(R.id.textView15)?.text = resources.getStringArray(R.array.dorms1)[dormThree]
    }

}