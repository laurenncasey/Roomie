package com.example.roomie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TextView

/**
 * Author: Lauren Casey
 */
class RoommatePref : AppCompatActivity() {
    val discl = findViewById<TextView>(R.id.roomieDisc)
    val saveRoomie = findViewById<Button>(R.id.save)

    //roomie preferences to save
    val genderR : Spinner = findViewById(R.id.genderRoom)
    val lgbtR : Spinner = findViewById(R.id.lgbtRoom)
    val smokesR: Spinner = findViewById(R.id.smokesRoom)
    val drinksR: Spinner = findViewById(R.id.drinksRoom)
    val cleanR: Spinner = findViewById(R.id.cleanRoom)
    val ieR: Spinner = findViewById(R.id.introextroRoom)
    val petsR: Spinner = findViewById(R.id.petsRoom)
    val nightR: Spinner = findViewById(R.id.nightRoom)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roommate_pref)
        discl.text = "Tell us your roommate preferences! These will be kept private but used in your matching algorithm to find potential roommates! You do not have to answer every one, but keep in mind, the more you fill out the better matches you will get!"

        saveRoomie?.setOnClickListener{
            //save all information to database
        }
    }
}