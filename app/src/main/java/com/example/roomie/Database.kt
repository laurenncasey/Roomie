package com.example.roomie

import android.os.Parcel
import android.os.Parcelable

data class Database(val pointlessVariable: Int) : Parcelable {
    var allUsers: ArrayList<User> = ArrayList()

    constructor(parcel: Parcel) : this(parcel.readInt())
    fun getMatchesList(user: User): List<User> {
        var count = 0
        var listOfMatches = emptyList<User>()
        while (count < allUsers.size) {
            while (user.foundInNo(allUsers.get(count)) && user.foundInYes(allUsers[count]) && allUsers[count] != user) {
                var tally = 0
                if (allUsers.get(count).getclean() == user.getRClean()) {
                    tally += 1
                }
                if (allUsers.get(count).getgender() == user.getRGender()) {
                    tally += 1
                }
                if (allUsers.get(count).getlgbt() == user.getRLgbt()) {
                    tally += 1
                }
                if (allUsers.get(count).getsmoke() == user.getRSmokes()) {
                    tally += 1
                }
                if (allUsers.get(count).getalco() == user.getRDrinks()) {
                    tally += 1
                }
                if (allUsers.get(count).getpets() == user.getRPets()) {
                    tally += 1
                }
                if (allUsers.get(count).getwake() == user.getRWaketime()) {
                    tally += 1
                }
                if (allUsers.get(count).getintrovert() == user.getRIE()) {
                    tally += 1
                }


                if (tally >= 5) {
                    listOfMatches.plusElement(allUsers.get(count))
                }
            }
        }
        return listOfMatches
    }

    fun findUser(username: String, password: String): User? {
        if (allUsers.size == 0) {
            val newUser = User(usrname = "Test")
            newUser.setpassword("123")
            newUser.setusername("Test")
            addToDB(newUser)

            populateUsers()
        }

        for (i in 0 until (allUsers.size - 1)) {
            if (allUsers[i].getusername().toString().equals(username) && allUsers[i].getpassword()
                    .toString()
                    .equals(password)
            ) {
                return allUsers.get(i)
            }
        }
        return null
    }

    fun populateUsers() {
        val newUser = User(usrname = "Temp1")
        newUser.setpassword("1234")
        newUser.setusername("Temp1")
        addToDB(newUser)

        val newUser1 = User(usrname = "Temp2")
        newUser1.setpassword("987")
        newUser1.setusername("Temp2")
        newUser1.setfullname("John Smith")
        addToDB(newUser1)

        val newUser3 = User(usrname = "Test2")
        newUser3.setpassword("1235")
        newUser3.setusername("Test2")
        addToDB(newUser3)
    }

    fun addToDB(user: User) {
        allUsers.add(user)
    }

    //is there a point to this 'getUser' method?
    fun getUser(user: String?): User? {
        var count = 0
        while (count < allUsers.size) {
            if (allUsers[count].getusername().equals(user)) {
                return allUsers[count]
            }
            count += 1
        }
        return null
    }

    fun removeUser(user: User) {
        allUsers.drop(allUsers.indexOf(user))
    }

    fun resetRoommatePreferences(user: User) {
        val deletePref: User = allUsers.get(allUsers.indexOf(user))
        //reset everything
    }

    fun resetProfile(user: User) {
        val resetProf = allUsers.get(allUsers.indexOf(user))
        //reset everything
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(-1)
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
