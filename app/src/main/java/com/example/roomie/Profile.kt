package com.example.roomie


import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts



/**
 * Author: Lauren Casey
 */
class Profile: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        /**
         * Variables used
         */
        //NEED THIS TO PASS USER TO OTHER ACTIVITIES
        val user: User? = intent.getParcelableExtra("passedValue")
        val db: Database? = intent.getParcelableExtra("db")//not sure if this is needed but added anyway
        db as Database                                          // Reasoning being I already added a user to the database in signup so by passing the
                                                                // user here it should already be available in the database
        val disclaimerText: TextView = findViewById(R.id.disclaimer)

        // profile information to save to database
        val genderUser = findViewById<Spinner>(R.id.Gender)
        val cleanDirty = findViewById<Spinner>(R.id.cleanordirty)
        val birdOwl = findViewById<Spinner>(R.id.birdorowl)
        val ie = findViewById<Spinner>(R.id.extrointro)
        val pets = findViewById<Spinner>(R.id.pets)
        val drinks = findViewById<Spinner>(R.id.drinks)
        val smokes = findViewById<Spinner>(R.id.smokes)
        val lgbt = findViewById<Spinner>(R.id.lgbtProf)
        val dorm1 = findViewById<Spinner>(R.id.dorms)
        val dorm2 = findViewById<Spinner>(R.id.dorms2)
        val dorm3 = findViewById<Spinner>(R.id.dorms3)

        disclaimerText.text =
            "Welcome to your profile. Here you can choose to provide us with any information to be shown in your profile to potential roommates. Any information not filled in will not be used in the matching algorithm, but the more information provided, the better results. "
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * Set profile's set values to it's default show values
         */







        /**
         * Sets profile setting and saves to db if "save" button is pressed
         */
        //sets users full name
        findViewById<TextView>(R.id.name).setOnClickListener {
            user?.setusername(findViewById<TextView>(R.id.name).text.toString())
        }


        /**
         * Pick profile picture from gallery and save to profile and load up initially
         */

        var profilePicker = findViewById<ImageView>(R.id.imageInput)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                profilePicker.setImageURI(result.data?.data)
                user?.setprofilepic(result.data?.data)
            }
        }
        fun openYourActivity() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            resultLauncher.launch(intent)
        }

        profilePicker?.setOnClickListener{
            openYourActivity()
        }

        /**
         * saveProfInfo: saves all inputted information to database to keep as users stored information
         */
        findViewById<Button>(R.id.saveprof).setOnClickListener {

            user?.setgender(genderUser.selectedItem.toString())

            //picture working???
            user?.setprofilepic((Uri.parse(profilePicker.toString())))
            user?.setclean(cleanDirty.selectedItem.toString())
            user?.setwake(birdOwl.selectedItem.toString())
            user?.setintrovert(ie.selectedItem.toString())
            user?.setpets(pets.selectedItem.toString())
            user?.setalco(drinks.selectedItem.toString())
            user?.setsmoke(smokes.selectedItem.toString())
            user?.setlgbt(lgbt.selectedItem.toString())
            user?.setdormone(dorm1.selectedItem.toString())
            user?.setdormtwo(dorm2.selectedItem.toString())
            user?.setdormthree(dorm3.selectedItem.toString())
            Toast.makeText(applicationContext, "Profile Saved", Toast.LENGTH_SHORT).show()

        }


        /**
         * setRoommate : if the set roommate preferences button is pressed
         * takes the user to the roommate preferences information input activity
         */
        findViewById<Button>(R.id.roomiePref).setOnClickListener {
            val intent = Intent(this, RoommatePref::class.java)
            val bundle = Bundle()
            bundle.putParcelable("passedValue", user)
            intent.putExtra("passed", bundle)
            startActivity(intent)
        }


        /**
         * settings: if "..." button is selected, bring user to settings activity
         */
        findViewById<Button>(R.id.settings).setOnClickListener {
            //passing user info into settings for deletion and things
            val intent = Intent(this, Settings::class.java)
            val bundle = Bundle()
            bundle.putParcelable("passedValue", user)
            intent.putExtra("passed", bundle)
            startActivity(intent)
        }


    }
}
