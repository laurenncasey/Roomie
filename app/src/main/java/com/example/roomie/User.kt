package com.example.roomie

import android.location.GnssNavigationMessage
import com.google.firebase.database.FirebaseDatabase

data class User(val userID : Int){
    //var profilePic : Array<ByteArray> = null
    var gender = ""
    var username = ""
    var password = ""
    var email = ""
    var lgbt = ""
    val db = FirebaseDatabase.getInstance().getReference("/user" + userID)


    fun setusername(setUsername : String){
        username = setUsername
        db.child("username").setValue(setUsername)
    }
    fun getusername():String{
        return username
    }
    fun setpassword(setPassword : String){
        password = setPassword
    }

    fun setemail(setEmail : String){
        email = setEmail
    }
    fun getemail():String{
        return email
    }

    fun getpassword():String{
        return gender
    }
    fun setgender(Gndr : String){
        gender = Gndr
    }
    fun getgender():String{
        return gender
    }

    fun setlgbt(LGBT:String){
        lgbt = LGBT
    }
    fun getlgbt():String{
        return lgbt
    }

}
