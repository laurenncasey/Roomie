package com.example.roomie

import android.location.GnssNavigationMessage
import com.google.firebase.database.FirebaseDatabase

data class User(val userID : Int){
    //var profilePic : Array<ByteArray> = null
    var gender = ""
    var username = ""
    var password = ""
    var email = ""
    var profilePic : ByteArray? = null
    var dormOne = ""
    var dormTwo = ""
    var dormThree = ""
    var major = ""
    var bio = ""
    var clean = ""
    var waketime = ""
    var pets = ""
    var alcohol = ""
    var smoking = ""
    var introverted = ""
    var fullname = ""
    var lgbt = ""


    val db = FirebaseDatabase.getInstance().getReference("/user" + userID)


    /**
     * The following are getters and setters for the users profile
     */
    //fullname
    fun setfullname(FullName : String){
        fullname = FullName
        db.child("fullname").setValue(FullName)
    }
    fun getfullname():String{
        return fullname
    }

    //username
    fun setusername(setUsername : String){
        username = setUsername
        db.child("username").setValue(setUsername)
    }
    fun getusername():String{
        return username
    }

    //PROFILE PICTURE

//    fun setprofilepic(setProfPic : ByteArray){
//
//    }
//    fun getprofilepic():ByteArray{
//        return null
//    }

    //password
    fun setpassword(setPassword : String){
        password = setPassword
        db.child("password").setValue(setPassword)

    }
    fun getpassword():String{
        return gender
    }

    //email
    fun setemail(setEmail : String){
        email = setEmail
        db.child("email").setValue(setEmail)

    }
    fun getemail():String{
        return email
    }

    //gender
    fun setgender(Gndr : String){
        gender = Gndr
        db.child("gender").setValue(Gndr)

    }
    fun getgender():String{
        return gender
    }

    //LGBT
    fun setlgbt(LGBT:String){
        lgbt = LGBT
        db.child("lgbt").setValue(LGBT)

    }
    fun getlgbt():String{
        return lgbt
    }

    //dorms
    fun setdormone(dorm:String){
        dormOne = dorm
        db.child("dormOne").setValue(dorm)
    }
    fun getdormone():String{
        return dormOne
    }
    fun setdormtwo(dorm:String){
        dormTwo = dorm
        db.child("dormTwo").setValue(dorm)
    }
    fun getdormtwo():String{
        return dormTwo
    }
    fun setdormthree(dorm:String){
        dormThree = dorm
        db.child("dormThree").setValue(dorm)
    }
    fun getdormthree():String{
        return dormThree
    }

    //major
    fun setmajor(majorinput:String){
        major = majorinput
        db.child("major").setValue(majorinput)
    }
    fun getmajor():String{
        return major
    }

    //bio
    fun setbio(biography:String){
        bio = biography
        db.child("bio").setValue(biography)
    }
    fun getbio():String{
        return bio
    }

    //clean or dirty
    fun setclean(cleanType :String){
        clean = cleanType
        db.child("clean").setValue(cleanType)
    }
    fun getclean():String{
        return clean
    }

    //waketime
    fun setwake(wakey :String){
        waketime = wakey
        db.child("waketime").setValue(wakey)
    }
    fun getwake():String{
        return waketime
    }

    //pets
    fun setpets(hasPets :String){
            pets = hasPets
            db.child("pets").setValue(hasPets)
        }
        fun getpets():String{
            return pets
        }

    //alcohol
    fun setalco(drinks :String){
        alcohol = drinks
        db.child("drinks").setValue(drinks)
    }
    fun getalco():String{
        return alcohol
    }

    //smokes
    fun setsmoke(doesSmokes :String){
        smoking = doesSmokes
        db.child("smokes").setValue(doesSmokes)
    }
    fun getsmoke():String{
        return smoking
    }

    //introverted
    fun getintrovert(introvertedOrNot : String){
        introverted = introvertedOrNot
        db.child("introverted").setValue(introvertedOrNot)
        }
        fun getintrovert():String{
            return introverted
        }


    }


