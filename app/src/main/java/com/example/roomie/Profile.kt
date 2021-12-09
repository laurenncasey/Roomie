package com.example.roomie


import android.R.attr
import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import android.graphics.BitmapFactory
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.net.URI
import android.R.attr.data
import android.app.Instrumentation
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.os.Parcelable
import com.squareup.picasso.Picasso


/**
 * Author: Lauren Casey
 */
class Profile : AppCompatActivity() {


    //TO DO:
    //  if user doesn't answer a question, keep default as editable in profile but for the roommate preview,
    //  only show answered questions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val disclaimerText: TextView = findViewById(R.id.disclaimer)

        //profile information to save to database
        val gender: Spinner = findViewById(R.id.Gender)
        val cleanDirty: Spinner = findViewById(R.id.cleanordirty)
        val birdOwl: Spinner = findViewById(R.id.birdorowl)
        val nameSet: TextView = findViewById(R.id.name)
        val ie: Spinner = findViewById(R.id.extrointro)
        val pets: Spinner = findViewById(R.id.pets)
        val drinks: Spinner = findViewById(R.id.drinks)
        val smokes: Spinner = findViewById(R.id.smokes)
        val lgbt: Spinner = findViewById(R.id.lgbtProf)
        val dorm1: Spinner = findViewById(R.id.dorms)
        val dorm2: Spinner = findViewById(R.id.dorms2)
        val dorm3: Spinner = findViewById(R.id.dorms3)


        //save prof
        val saveProfInfo: Button = findViewById(R.id.saveprof)
        disclaimerText.text =
            "Welcome to your profile. Here you can choose to provide us with any information to be shown in your profile to potential roommates. Any information not filled in will not be used in the matching algorithm, but the more information provided, the better results. "
        /**
         * setRoommate : if the set roommate preferences button is pressed
         * takes the user to the roommate preferences information input activity
         */
        findViewById<Button>(R.id.roomiePref).setOnClickListener {
            startActivity(Intent(this, RoommatePref::class.java))
        }

        /**
         * settings: if "..." button is selected, bring user to settings activity
         */
        findViewById<Button>(R.id.settings).setOnClickListener {

            startActivity(Intent(this, Settings::class.java))

        }

        /**
         * ImageSelect : brings user to android gallery to choose profile image
         */
        val PICK_PHOTO = 23;
        val profilePicker = findViewById<ImageView>(R.id.imageInput)


        //This needs to be link to database
        //val uri: Uri =
        val uri : Uri = Uri.parse("/Users/laurencasey/AndroidStudioProjects/Roomie2/app/src/main/res/drawable")

        profilePicker?.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            startActivityForResult(intent, PICK_PHOTO)
            //Picasso.with(applicationContext).load().into(profilePicker)

        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == PICK_PHOTO && resultCode == RESULT_OK && data != null) {
                Picasso.with(applicationContext).load(uri).into(profilePicker)
            }
        }
        /**
         * saveProfInfo: saves all inputted information to database to keep as users stored information
         */


        /**
         * Navigation Bar: Consists of 3 button functions.
         * goToProf: brings the user to the profile activity
         * goToMatches: brings the user to their matches activity
         * goToSwipe: brings the user to the swipe activity
         */
    }


}