package com.example.roomie

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup




class ProfileHolder: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_holder, container, false)
    }


    fun setValues(pic : Uri, usersName : String,  usersAge : String,  usersGender : String,  usersLgbt : String,  usersBio : String,  usersSmoke:String,  usersDrink : String,  usersPets: String,  usersClean : String,  dormOne : String,  dormTwo : String,  dormThree:String) {
//        view?.findViewById<ImageView>(R.id.imageView2)?.setImageURI(pic)!!
//        view?.findViewById<TextView>(R.id.textView6)?.text = usersName!!
//        view?.findViewById<TextView>(R.id.ageProfile)?.text = usersAge!!
//        view?.findViewById<TextView>(R.id.genderProfile)?.text = usersGender!!
//        view?.findViewById<TextView>(R.id.lgbtProfile)?.text = usersLgbt!!
//        view?.findViewById<TextView>(R.id.bioProfile)?.text = usersBio!!
//        view?.findViewById<TextView>(R.id.textView14)?.text = usersSmoke!!
//        view?.findViewById<TextView>(R.id.textView15)?.text = usersDrink!!
//        view?.findViewById<TextView>(R.id.textView16)?.text = usersPets!!
//        view?.findViewById<TextView>(R.id.textView5)?.text = usersClean!!
//        view?.findViewById<TextView>(R.id.textView8)?.text = dormOne!!
//        view?.findViewById<TextView>(R.id.textView9)?.text = dormTwo!!
//        view?.findViewById<TextView>(R.id.textView10)?.text = dormThree!!
    }

}