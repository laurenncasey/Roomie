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
    var age = ""
    var smoking = ""
    var introverted = ""
    var fullname = ""
    var lgbt = ""
    var matches : List<String> = emptyList()
    var listOfYes : List<User> = emptyList()
    var listOfNo : List<User> = emptyList()
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
        username = parcel.readString()
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
        age = parcel.readString().toString()
        smoking = parcel.readString().toString()
        introverted = parcel.readString().toString()
        fullname = parcel.readString().toString()
        lgbt = parcel.readString().toString()
        matches = parcel.createStringArrayList()!!
        listOfYes = parcel.createTypedArrayList(CREATOR)!!
        listOfNo = parcel.createTypedArrayList(CREATOR)!!
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

    //age
    fun setage(userAge: String){
        age = userAge
    }

    fun getage():String{
        return age
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
    fun foundInYes(user:User):Boolean{
        var found = false;
        if(listOfYes.contains(user)){
            found = true
        }
        return found
    }
    fun foundInNo(userr:User):Boolean{
        var found = false;
        if(listOfNo.contains(userr)){
            found = true
        }
        return found
    }

    //add to those lists
    fun addToYes(userr:User){
        listOfYes.plusElement(userr)
    }
    fun addToNo(userr: User){
        listOfNo.plusElement(userr)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(usrname)
        p0?.writeString(gender)
        p0?.writeString(password)
        p0?.writeString(username)
        p0?.writeString(email)
        p0?.writeParcelable(profilePic, p1)
        p0?.writeString(dormOne)
        p0?.writeString(dormTwo)
        p0?.writeString(dormThree)
        p0?.writeString(major)
        p0?.writeString(bio)
        p0?.writeString(clean)
        p0?.writeString(waketime)
        p0?.writeString(pets)
        p0?.writeString(alcohol)
        p0?.writeString(age)
        p0?.writeString(smoking)
        p0?.writeString(introverted)
        p0?.writeString(fullname)
        p0?.writeString(lgbt)
        p0?.writeStringList(matches)
        p0?.writeTypedList(listOfYes)
        p0?.writeTypedList(listOfNo)
        p0?.writeString(roommateGender)
        p0?.writeString(roommatelgbt)
        p0?.writeString(roommatesmoke)
        p0?.writeString(roommatedrink)
        p0?.writeString(roommateclean)
        p0?.writeString(roommateie)
        p0?.writeString(roommatepets)
        p0?.writeString(roommatewaketime)
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


