package com.example.roomie

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.FirebaseDatabase

/**
 * Author : Lauren Casey
 */
data class User(val usrname: String) : Parcelable{
    var gender = ""
    var password = ""
    var username = usrname
    var email = ""
    var profilePic :Uri? = Uri.EMPTY
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
    var matches : List<String> = emptyList()
    var listOfYes : List<String> = emptyList()
    var listOfNo : List<String> = emptyList()



    val db = FirebaseDatabase.getInstance().getReference("/" + usrname)

    constructor(parcel: Parcel) : this(parcel.readString().toString()) {
        gender = parcel.readString().toString()
        username = parcel.readString().toString()
        password = parcel.readString().toString()
        //profilePic = writeToParcel(parcel, 0)
        email = parcel.readString().toString()
        dormOne = parcel.readString().toString()
        dormTwo = parcel.readString().toString()
        dormThree = parcel.readString().toString()
        major = parcel.readString().toString()
        bio = parcel.readString().toString()
        clean = parcel.readString().toString()
        waketime = parcel.readString().toString()
        pets = parcel.readString().toString()
        alcohol = parcel.readString().toString()
        smoking = parcel.readString().toString()
        introverted = parcel.readString().toString()
        fullname = parcel.readString().toString()
        lgbt = parcel.readString().toString()
    }


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
    fun setprofilepic(setProfPic : Uri?){
        profilePic = setProfPic
        db.child("profilepicture").setValue(setProfPic)

    }
    fun getprofilepic():Uri? {
        return profilePic
    }

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
    fun setintrovert(introvertedOrNot : String){
        introverted = introvertedOrNot
        db.child("introverted").setValue(introvertedOrNot)
        }
        fun getintrovert():String{
            return introverted
        }


    //search through matches
    fun foundInYes(username: String):Boolean{
        var found = false;
        if(listOfYes.contains(username)){
            found = true
        }
        return found
    }
    fun foundInNo(username: String):Boolean{
        var found = false;
        if(listOfNo.contains(username)){
            found = true
        }
        return found
    }

    //add to those lists
    fun addToYes(username: String){
        listOfYes.plusElement(username)
    }
    fun addToNo(username: String){
        listOfNo.plusElement(username)
    }

    //list of matches


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(usrname)
        parcel.writeString(gender)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(email)
        parcel.writeString(dormOne)
        parcel.writeString(dormTwo)
        parcel.writeString(dormThree)
        parcel.writeString(major)
        parcel.writeString(bio)
        parcel.writeString(clean)
        parcel.writeString(waketime)
        parcel.writeString(pets)
        parcel.writeString(alcohol)
        parcel.writeString(smoking)
        parcel.writeString(introverted)
        parcel.writeString(fullname)
        parcel.writeString(lgbt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}


