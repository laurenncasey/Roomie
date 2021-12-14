package com.example.roomie

import android.content.Intent
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class findInDB {
    val db  = FirebaseDatabase.getInstance().getReference("/roomie-e4120-default-rtdb")

    fun returnFalse(): Boolean{
        return false
    }

    fun returnTrue(): Boolean{
        return true
    }


    fun findUser(username: String, password: String){
        db.equalTo(username).addListenerForSingleValueEvent(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //not sure if this works
                val foundUser : User = snapshot.value as User
                if(foundUser.getpassword() == password){
                    returnTrue()
                }else{
                    returnFalse()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                returnFalse()
            }

        })

    }

    fun findValue(category: String, value: String){
        //search for value
    }
}