package com.example.roomie

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

/**
 * Author : Lauren Casey
 */
data class User(val usrname: String?) : Parcelable{
    var gender = -1
    var password = ""
    var username = usrname
    var email = ""
    var profilePic :Uri? = Uri.EMPTY
    var dormOne = -1
    var dormTwo = -1
    var dormThree = -1
    var major = ""
    var bio = ""
    var clean = -1
    var waketime = -1
    var pets = -1
    var alcohol = -1
    var age = ""
    var smoking = -1
    var introverted = -1
    var fullname = ""
    var lgbt = -1
    var matches : List<String> = emptyList()
    var listOfYes : List<User> = emptyList()
    var listOfNo : List<User> = emptyList()
    var roommateGender = -1
    var roommatelgbt = -1
    var roommatesmoke = -1
    var roommatedrink = -1
    var roommateclean = -1
    var roommateie = -1
    var roommatepets = -1
    var roommatewaketime = -1

    constructor(parcel: Parcel) : this(parcel.readString()) {
        gender = parcel.readInt()
        password = parcel.readString().toString()
        username = parcel.readString()
        email = parcel.readString().toString()
        profilePic = parcel.readParcelable(Uri::class.java.classLoader)
        dormOne = parcel.readInt()
        dormTwo = parcel.readInt()
        dormThree = parcel.readInt()
        major = parcel.readString().toString()
        bio = parcel.readString().toString()
        clean = parcel.readInt()
        waketime = parcel.readInt()
        pets = parcel.readInt()
        alcohol = parcel.readInt()
        age = parcel.readString().toString()
        smoking = parcel.readInt()
        introverted = parcel.readInt()
        fullname = parcel.readString().toString()
        lgbt = parcel.readInt()
        matches = parcel.createStringArrayList()!!
        listOfYes = parcel.createTypedArrayList(CREATOR)!!
        listOfNo = parcel.createTypedArrayList(CREATOR)!!
        roommateGender = parcel.readInt()
        roommatelgbt = parcel.readInt()
        roommatesmoke = parcel.readInt()
        roommatedrink = parcel.readInt()
        roommateclean = parcel.readInt()
        roommateie = parcel.readInt()
        roommatepets = parcel.readInt()
        roommatewaketime = parcel.readInt()
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
    //clear all values
    fun clear(){

        var gender = ""
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
    }

    fun resetRoommatePreferences() {

        var roommateGender = ""
        var roommatelgbt = ""
        var roommatesmoke = ""
        var roommatedrink = ""
        var roommateclean = ""
        var roommateie = ""
        var roommatepets = ""
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
        return password
    }

    //email
    fun setemail(setEmail : String){
        email = setEmail

    }
    fun getemail():String{
        return email
    }

    //gender
    fun setgender(Gndr : Int){
        gender = Gndr

    }
    fun getgender():Int{
        return gender
    }

    //LGBT
    fun setlgbt(LGBT:Int){
        lgbt = LGBT

    }
    fun getlgbt():Int{
        return lgbt
    }

    //dorms
    fun setdormone(dorm:Int){
        dormOne = dorm
    }
    fun getdormone():Int{
        return dormOne
    }
    fun setdormtwo(dorm:Int){
        dormTwo = dorm
    }
    fun getdormtwo():Int{
        return dormTwo
    }
    fun setdormthree(dorm:Int){
        dormThree = dorm
    }
    fun getdormthree():Int{
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
    fun setclean(cleanType :Int){
        clean = cleanType
    }
    fun getclean():Int{
        return clean
    }

    //waketime
    fun setwake(wakey :Int){
        waketime = wakey
    }
    fun getwake():Int{
        return waketime
    }

    //pets
    fun setpets(hasPets :Int){
            pets = hasPets
        }
        fun getpets():Int{
            return pets
        }

    //alcohol
    fun setalco(drinks :Int){
        alcohol = drinks
    }
    fun getalco():Int{
        return alcohol
    }

    //smokes
    fun setsmoke(doesSmokes :Int) {
        smoking = doesSmokes
    }
    fun getsmoke():Int{
        return smoking
    }

    //introverted
    fun setintrovert(introvertedOrNot : Int){
        introverted = introvertedOrNot
        }
    fun getintrovert():Int{
            return introverted
        }




    //ROOMMATE PREFS
    fun setRGender(gender : Int){
        roommateGender = gender
    }
    fun getRGender():Int{
        return roommateGender
    }

    fun setRLgbt(lgbt:Int) {
        roommatelgbt = lgbt
    }
    fun getRLgbt():Int{
        return roommatelgbt
    }

    fun setRSmokes(smoke:Int){
        roommatesmoke = smoke
    }
    fun getRSmokes():Int{
        return roommatesmoke
    }

    fun setRDrinks(drink:Int){
        roommatedrink = drink
    }
    fun getRDrinks():Int{
        return roommatedrink
    }

    fun setRClean(clean:Int){
        roommateclean = clean
    }
    fun getRClean():Int{
        return roommateclean
    }

    fun setRIE(ie:Int){
        roommateie = ie
    }
    fun getRIE():Int{
        return roommateie
    }

    fun setRPets(pets:Int){
        roommatepets = pets
    }
    fun getRPets():Int{
        return roommatepets
    }

    fun setRWaketime(waketime:Int){
        roommatewaketime = waketime
    }
    fun getRWaketime():Int{
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
        p0?.writeInt(gender)
        p0?.writeString(password)
        p0?.writeString(username)
        p0?.writeString(email)
        p0?.writeParcelable(profilePic, p1)
        p0?.writeInt(dormOne)
        p0?.writeInt(dormTwo)
        p0?.writeInt(dormThree)
        p0?.writeString(major)
        p0?.writeString(bio)
        p0?.writeInt(clean)
        p0?.writeInt(waketime)
        p0?.writeInt(pets)
        p0?.writeInt(alcohol)
        p0?.writeString(age)
        p0?.writeInt(smoking)
        p0?.writeInt(introverted)
        p0?.writeString(fullname)
        p0?.writeInt(lgbt)
        p0?.writeStringList(matches)
        p0?.writeTypedList(listOfYes)
        p0?.writeTypedList(listOfNo)
        p0?.writeInt(roommateGender)
        p0?.writeInt(roommatelgbt)
        p0?.writeInt(roommatesmoke)
        p0?.writeInt(roommatedrink)
        p0?.writeInt(roommateclean)
        p0?.writeInt(roommateie)
        p0?.writeInt(roommatepets)
        p0?.writeInt(roommatewaketime)
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


