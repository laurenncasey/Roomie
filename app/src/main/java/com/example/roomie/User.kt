package com.example.roomie

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

/**
 * Author : Lauren Casey
 */
data class User(val usrname: String?) : Parcelable{
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
    var roommateGender = ""
    var roommatelgbt = ""
    var roommatesmoke = ""
    var roommatedrink = ""
    var roommateclean = ""
    var roommateie = ""
    var roommatepets = ""
    var roommatewaketime = ""

    constructor(parcel: Parcel) : this(parcel.readString()) {
        gender = parcel.readString().toString()
        password = parcel.readString().toString()
        username = parcel.readString().toString()
        email = parcel.readString().toString()
        profilePic = parcel.readParcelable(Uri::class.java.classLoader)
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
        matches = parcel.createStringArrayList()!!
        listOfYes = parcel.createStringArrayList()!!
        listOfNo = parcel.createStringArrayList()!!
        roommateGender = parcel.readString().toString()
        roommatelgbt = parcel.readString().toString()
        roommatesmoke = parcel.readString().toString()
        roommatedrink = parcel.readString().toString()
        roommateclean = parcel.readString().toString()
        roommateie = parcel.readString().toString()
        roommatepets = parcel.readString().toString()
        roommatewaketime = parcel.readString().toString()
    }

    /**
     * The following are getters and setters for the users profile
     */
    //fullname
    fun setfullname(FullName : String){
        fullname = FullName
    }
    fun getfullname():String{
        return fullname
    }

    //username
    fun setusername(setUsername : String){
        username = setUsername
    }
    fun getusername():String?{
        return username
    }

    //PROFILE PICTURE
    fun setprofilepic(setProfPic : Uri?){
        profilePic = setProfPic

    }
    fun getprofilepic():Uri? {
        return profilePic
    }

    //password
    fun setpassword(setPassword : String){
        password = setPassword

    }
    fun getpassword():String{
        return gender
    }

    //email
    fun setemail(setEmail : String){
        email = setEmail

    }
    fun getemail():String{
        return email
    }

    //gender
    fun setgender(Gndr : String){
        gender = Gndr

    }
    fun getgender():String{
        return gender
    }

    //LGBT
    fun setlgbt(LGBT:String){
        lgbt = LGBT

    }
    fun getlgbt():String{
        return lgbt
    }

    //dorms
    fun setdormone(dorm:String){
        dormOne = dorm
    }
    fun getdormone():String{
        return dormOne
    }
    fun setdormtwo(dorm:String){
        dormTwo = dorm
    }
    fun getdormtwo():String{
        return dormTwo
    }
    fun setdormthree(dorm:String){
        dormThree = dorm
    }
    fun getdormthree():String{
        return dormThree
    }

    //major
    fun setmajor(majorinput:String){
        major = majorinput
    }
    fun getmajor():String{
        return major
    }

    //bio
    fun setbio(biography:String){
        bio = biography
    }
    fun getbio():String{
        return bio
    }

    //clean or dirty
    fun setclean(cleanType :String){
        clean = cleanType
    }
    fun getclean():String{
        return clean
    }

    //waketime
    fun setwake(wakey :String){
        waketime = wakey
    }
    fun getwake():String{
        return waketime
    }

    //pets
    fun setpets(hasPets :String){
            pets = hasPets
        }
        fun getpets():String{
            return pets
        }

    //alcohol
    fun setalco(drinks :String){
        alcohol = drinks
    }
    fun getalco():String{
        return alcohol
    }

    //smokes
    fun setsmoke(doesSmokes :String) {
        smoking = doesSmokes
    }
    fun getsmoke():String{
        return smoking
    }

    //introverted
    fun setintrovert(introvertedOrNot : String){
        introverted = introvertedOrNot
        }
    fun getintrovert():String{
            return introverted
        }




    //ROOMMATE PREFS
    fun setRGender(gender : String){
        roommateGender = gender
    }
    fun getRGender():String{
        return roommateGender
    }

    fun setRLgbt(lgbt:String) {
        roommatelgbt = lgbt
    }
    fun getRLgbt():String{
        return roommatelgbt
    }

    fun setRSmokes(smoke:String){
        roommatesmoke = smoke
    }
    fun getRSmokes():String{
        return roommatesmoke
    }

    fun setRDrinks(drink:String){
        roommatedrink = drink
    }
    fun getRDrinks():String{
        return roommatedrink
    }

    fun setRClean(clean:String){
        roommateclean = clean
    }
    fun getRClean():String{
        return roommateclean
    }

    fun setRIE(ie:String){
        roommateie = ie
    }
    fun getRIE():String{
        return roommateie
    }

    fun setRPets(pets:String){
        roommatepets = pets
    }
    fun getRPets():String{
        return roommatepets
    }

    fun setRWaketime(waketime:String){
        roommatewaketime = waketime
    }
    fun getRWaketime():String{
        return roommatewaketime
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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(usrname)
        parcel.writeString(gender)
        parcel.writeString(password)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeParcelable(profilePic, flags)
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
        parcel.writeStringList(matches)
        parcel.writeStringList(listOfYes)
        parcel.writeStringList(listOfNo)
        parcel.writeString(roommateGender)
        parcel.writeString(roommatelgbt)
        parcel.writeString(roommatesmoke)
        parcel.writeString(roommatedrink)
        parcel.writeString(roommateclean)
        parcel.writeString(roommateie)
        parcel.writeString(roommatepets)
        parcel.writeString(roommatewaketime)
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


