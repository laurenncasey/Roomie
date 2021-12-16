package com.example.roomie


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts



/**
 * Author: Lauren Casey
 */
class Profile: AppCompatActivity() {


    //TO DO:
    //  if user doesn't answer a question, keep default as editable in profile but for the roommate preview,
    //  only show answered questions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        /**
         * Variables used
         */
        //NEED THIS TO PASS USER TO OTHER ACTIVITIES
        val user: User? = intent.getParcelableExtra("passedValue")

        val disclaimerText: TextView = findViewById(R.id.disclaimer)

        // profile information to save to database
        val genderUser = findViewById<Spinner>(R.id.Gender).selectedItem.toString()
        val cleanDirty = findViewById<Spinner>(R.id.cleanordirty).selectedItem.toString()
        val birdOwl = findViewById<Spinner>(R.id.birdorowl).selectedItem.toString()
        val ie = findViewById<Spinner>(R.id.extrointro).selectedItem.toString()
        val pets = findViewById<Spinner>(R.id.pets).selectedItem.toString()
        val drinks = findViewById<Spinner>(R.id.drinks).selectedItem.toString()
        val smokes = findViewById<Spinner>(R.id.smokes).selectedItem.toString()
        val lgbt = findViewById<Spinner>(R.id.lgbtProf).selectedItem.toString()
        val dorm1 = findViewById<Spinner>(R.id.dorms).selectedItem.toString()
        val dorm2 = findViewById<Spinner>(R.id.dorms2).selectedItem.toString()
        val dorm3 = findViewById<Spinner>(R.id.dorms3).selectedItem.toString()

        disclaimerText.text =
            "Welcome to your profile. Here you can choose to provide us with any information to be shown in your profile to potential roommates. Any information not filled in will not be used in the matching algorithm, but the more information provided, the better results. "
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * Set profile's set values to it's default show values
         */

//        findViewById<Spinner>(R.id.Gender).set
//        fun ifNotNull(item : View, selected: String){
//            if(item != null){
//                item.set
//            }
//        }







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

        val profilePicker = findViewById<ImageView>(R.id.imageInput)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                profilePicker.setImageURI(result.data?.data)
                //SAVE PROFILE PIC AS URI IN DATABASE
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

            user?.setgender(genderUser)
            user?.setclean(cleanDirty)
            user?.setwake(birdOwl)
            user?.setintrovert(ie)
            user?.setpets(pets)
            user?.setalco(drinks)
            user?.setsmoke(smokes)
            user?.setlgbt(lgbt)
            user?.setdormone(dorm1)
            user?.setdormtwo(dorm2)
            user?.setdormthree(dorm3)
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