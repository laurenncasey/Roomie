package com.example.roomie

import android.os.Parcel
import android.os.Parcelable

data class Database(val pointlessVariable: Int):Parcelable{
    var allUsers = emptyList<User>()

    constructor(parcel: Parcel) : this(parcel.readInt()) {
        allUsers = parcel.createTypedArrayList(User)!!
    }






    fun addToDB(user: User){
        allUsers.plusElement(user)
    }
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
