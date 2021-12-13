package com.example.roomie


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


/**
 * Author: Lauren Casey
 */
 class Swipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)
        val db = FirebaseDatabase.getInstance().reference
        //val db = FirebaseDatabase.getInstance()
//        //check this reference
        val frag = Fragment(R.layout.fragment_profile_holder)
        val testing = findViewById<Button>(R.id.tempButtonForTest)

        val testUser = User(1)

        testing?.setOnClickListener{
            ///in main, on login, make a new user and set ID

            db.push().setValue(testUser)

            Toast.makeText(applicationContext, "Username set.", Toast.LENGTH_SHORT).show()

        }
   }

}




