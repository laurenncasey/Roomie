package com.example.roomie

data class Database(val user: User){
    var allUsers = emptyList<User>()

    fun addToDB(user: User){
        allUsers.plusElement(user)
    }
    fun getUser(username: String): User?{
        var count = 0
        while(count < allUsers.size){
            if(allUsers[count].getusername() == username){
                return allUsers[count]
            }
            count+=1
        }
        return null
    }

    //add remove from user and things for Jacobs settings

}
