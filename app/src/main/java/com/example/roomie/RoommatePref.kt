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

        val bundle = intent.extras;
        val db: Database? = bundle?.getParcelable("db")
        val username: String? = bundle?.getString("passedValue")
        val user: User? = db?.getUser(username)

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
        if (user != null) {
            genderR.setSelection(user.getgender())
            lgbtR.setSelection(user.getclean())
            smokesR.setSelection(user.getwake())
            drinksR.setSelection(user.getintrovert())
            cleanR.setSelection(user.getpets())
            ieR.setSelection(user.getalco())
            petsR.setSelection(user.getsmoke())
            nightR.setSelection(user.getlgbt())
        }
        /**
         * set Roommate preferences
         */
        findViewById<Button>(R.id.save).setOnClickListener{
            user?.setRGender(genderR.selectedItemPosition)
            user?.setRLgbt(lgbtR.selectedItemPosition)
            user?.setRSmokes(smokesR.selectedItemPosition)
            user?.setRDrinks(drinksR.selectedItemPosition)
            user?.setRClean(cleanR.selectedItemPosition)
            user?.setRIE(ieR.selectedItemPosition)
            user?.setRPets(petsR.selectedItemPosition)
            user?.setRWaketime(nightR.selectedItemPosition)
        }

        findViewById<Button>(R.id.backInR).setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            val bundle2 = Bundle()
            bundle2.putString("passedValue", username)
            bundle2.putParcelable("db", db)
            intent.putExtra("Hello", username)
            intent.putExtras(bundle2)
            startActivity(intent)
            startActivity(intent)
        }
    }
}