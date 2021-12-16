package com.example.roomie

import android.content.Intent
import android.widget.Toast
import com.google.firebase.database.*

class findInDB {
    val db  = FirebaseDatabase.getInstance().reference


    fun getAllUsers(): List<String>{
        return listOf<String>(db.orderByChild("roomie-e4120-default-rtdb").toString())
    }

    fun getUser(username : String): Query {
        return db.startAt(username)
    }
}