package com.example.roomie


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import android.graphics.BitmapFactory
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


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
        val imageSelect: ImageButton = findViewById(R.id.imageButton)
        val GET_FROM_GALLERY = 1;

        //fragment for NavBar




        //save prof
        val saveProfInfo : Button = findViewById(R.id.saveprof)
        disclaimerText.text = "Welcome to your profile. Here you can choose to provide us with any information to be shown in your profile to potential roommates. Any information not filled in will not be used in the matching algorithm, but the more information provided, the better results. "
        /**
         * setRoommate : if the set roommate preferences button is pressed
         * takes the user to the roommate preferences information input activity
         */
        findViewById<Button>(R.id.roomiePref).setOnClickListener{
            startActivity(Intent(this, RoommatePref::class.java))
        }

        /**
         * settings: if "..." button is selected, bring user to settings activity
         */
        findViewById<Button>(R.id.settings).setOnClickListener{
            startActivity(Intent(this, Settings::class.java))
        }

        /**
         * ImageSelect : brings user to android gallery to choose profile image
         */

//        @Override
//        fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent){
//            super.onActivityResult(requestCode, resultCode, data)
//            if(resultCode == GET_FROM_GALLERY && resultCode == RESULT_OK && null != data){
//                val selectedImage: Uri = data.data!!
//                val filePathColumn: Array<String> = arrayOf(MediaStore.Images.Media.DATA)
//                val cursor = contentResolver.query(
//                    selectedImage,
//                    filePathColumn, null, null, null
//                )
//                cursor!!.moveToFirst()
//                val columnIndex = cursor!!.getColumnIndex(filePathColumn[0])
//                val picturePath = cursor!!.getString(columnIndex)
//                cursor!!.close()
//                val imageV = findViewById<ImageView>(R.id.imageButton)
//                imageV.setImageBitmap(BitmapFactory.decodeFile(picturePath))
//
//            }
//        }

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