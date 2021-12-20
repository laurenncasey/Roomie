package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TextView
import androidx.room.Room

/**
 * Author: Lauren Casey
 */
class RoommatePref (): AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roommate_pref)

        val discl = findViewById<TextView>(R.id.roomieDisc)

        val user: User? = intent.getParcelableExtra("passedValue")

        //roomie preferences to save
        val genderR : Spinner = findViewById(R.id.genderRoom)
        val lgbtR : Spinner = findViewById(R.id.lgbtRoom)
        val smokesR: Spinner = findViewById(R.id.smokesRoom)
        val drinksR: Spinner = findViewById(R.id.drinksRoom)
        val cleanR: Spinner = findViewById(R.id.cleanRoom)
        val ieR: Spinner = findViewById(R.id.introextroRoom)
        val petsR: Spinner = findViewById(R.id.petsRoom)
        val nightR: Spinner = findViewById(R.id.nightRoom)


        discl.text = "Tell us your roommate preferences! These will be kept private but used in your matching algorithm to find potential roommates! You do not have to answer every one, but keep in mind, the more you fill out the better matches you will get!"

        /**
         * DEFAULT SHOW??
         */









        /**
         * set Roommate preferences
         */
        findViewById<Button>(R.id.save).setOnClickListener{
            user?.setRGender(genderR.selectedItem.toString())
            user?.setRLgbt(lgbtR.selectedItem.toString())
            user?.setRSmokes(smokesR.selectedItem.toString())
            user?.setRDrinks(drinksR.selectedItem.toString())
            user?.setRClean(cleanR.selectedItem.toString())
            user?.setRIE(ieR.selectedItem.toString())
            user?.setRPets(petsR.selectedItem.toString())
            user?.setRWaketime(nightR.selectedItem.toString())
        }

        findViewById<Button>(R.id.backInR).setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            val bundle = Bundle()
            bundle.putParcelable("passedValue", user)
            intent.putExtra("passed", bundle)
            startActivity(intent)
        }
    }
}