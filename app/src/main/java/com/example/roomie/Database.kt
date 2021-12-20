package com.example.roomie

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Database(val pointlessVariable: Int, val usrs: ArrayList<User>) : Parcelable {
    var allUsers: ArrayList<User> = ArrayList()

    init {
        allUsers = usrs;
    }
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
        newUser.setfullname("Meikayla Bates")
        newUser.setgender(1)
        newUser.setlgbt(1)
        newUser.setclean(1)
        newUser.setwake(1)
        newUser.setintrovert(1)
        newUser.setpets(1)
        newUser.setalco(1)
        newUser.setsmoke(1)
        newUser.setdormone(1)
        newUser.setdormtwo(2)
        newUser.setdormthree(3)
        newUser.setRClean(1)
        newUser.setRDrinks(1)
        newUser.setRGender(1)
        newUser.setRIE(1)
        newUser.setRLgbt(1)
        newUser.setRPets(1)
        newUser.setRSmokes(1)
        newUser.setRWaketime(1)
        addToDB(newUser)

        val newUser1 = User(usrname = "Temp2")
        newUser1.setpassword("987")
        newUser1.setusername("Temp2")
        newUser1.setfullname("John Smith")
        newUser1.setgender(0)
        newUser1.setlgbt(1)
        newUser1.setclean(1)
        newUser1.setwake(1)
        newUser1.setintrovert(1)
        newUser1.setpets(1)
        newUser1.setalco(1)
        newUser1.setsmoke(1)
        newUser1.setdormone(1)
        newUser1.setdormtwo(2)
        newUser1.setdormthree(3)
        newUser1.setRClean(1)
        newUser1.setRDrinks(1)
        newUser1.setRGender(1)
        newUser1.setRIE(1)
        newUser1.setRLgbt(1)
        newUser1.setRPets(1)
        newUser1.setRSmokes(1)
        newUser1.setRWaketime(1)
        addToDB(newUser1)

        val newUser3 = User(usrname = "Test2")
        newUser3.setpassword("1235")
        newUser3.setusername("Test2")
        newUser3.setfullname("Jill Doe")
        newUser1.setgender(1)
        newUser1.setlgbt(1)
        newUser1.setclean(1)
        newUser1.setwake(1)
        newUser1.setintrovert(1)
        newUser1.setpets(1)
        newUser1.setalco(1)
        newUser1.setsmoke(1)
        newUser1.setdormone(1)
        newUser1.setdormtwo(2)
        newUser1.setdormthree(3)
        newUser1.setRClean(1)
        newUser1.setRDrinks(1)
        newUser1.setRGender(1)
        newUser1.setRIE(1)
        newUser1.setRLgbt(1)
        newUser1.setRPets(1)
        newUser1.setRSmokes(1)
        newUser1.setRWaketime(1)
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


    companion object : Parceler<Database> {

        override fun Database.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(-1)
            parcel.writeTypedList(allUsers)
        }

        override fun create(parcel: Parcel): Database {
            val point = parcel.readInt()
            var allUsers: ArrayList<User> = ArrayList()
            parcel.readTypedList(allUsers, User.CREATOR)
            return Database(point, allUsers)

        }
    }


}
