package com.example.roomie

import android.os.Parcel
import android.os.Parcelable

data class Database(val pointlessVariable: Int):Parcelable{
    var allUsers = emptyList<User>()

    constructor(parcel: Parcel) : this(parcel.readInt()) {
        allUsers = parcel.createTypedArrayList(User)!!
    }


    fun getMatchesList(user:User):List<User>{
        var count = 0
        var listOfMatches = emptyList<User>()
        while(count < allUsers.size){
            while(user.foundInNo(allUsers[count]) && user.foundInYes(allUsers[count]) && allUsers[count] != user) {
                var tally = 0
                if (allUsers[count].getclean() == user.getRClean()) {
                    tally += 1
                }
                if (allUsers[count].getgender() == user.getRGender()) {
                    tally += 1
                }
                if (allUsers[count].getlgbt() == user.getRLgbt()) {
                    tally += 1
                }
                if (allUsers[count].getsmoke() == user.getRSmokes()) {
                    tally += 1
                }
                if (allUsers[count].getalco() == user.getRDrinks()) {
                    tally += 1
                }
                if (allUsers[count].getpets() == user.getRPets()) {
                    tally += 1
                }
                if (allUsers[count].getwake() == user.getRWaketime()) {
                    tally += 1
                }
                if (allUsers[count].getintrovert() == user.getRIE()) {
                    tally += 1
                }


                if (tally >= 5) {
                    listOfMatches.plusElement(allUsers[count])
                }
            }
        }
        return listOfMatches
    }

    fun findUser(username: String, password: String): User? {


        for(i in 0..allUsers.size){
            if(allUsers[i].getusername() == username && allUsers[i].getpassword() == password){
                return allUsers[i]
            }
        }
        return null
    }


    fun addToDB(user: User){
        allUsers.plusElement(user)
    }

    //is there a point to this 'getUser' method?
    fun getUser(user: User): User?{
        var count = 0
        while(count < allUsers.size){
            if (allUsers[count] == user){
                return allUsers[count]
            }
            count+=1
        }
        return null
    }

    fun removeUser(user: User){
        allUsers.drop(allUsers.indexOf(user))
    }

    fun resetRoommatePreferences(user:User){
        val deletePref : User = allUsers.get(allUsers.indexOf(user))
        //reset everything
    }

    fun resetProfile(user: User){
        val resetProf = allUsers.get(allUsers.indexOf(user))
        //reset everything
    }







    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(pointlessVariable)
        parcel.writeTypedList(allUsers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Database> {
        override fun createFromParcel(parcel: Parcel): Database {
            return Database(parcel)
        }

        override fun newArray(size: Int): Array<Database?> {
            return arrayOfNulls(size)
        }
    }
}
