package com.example.roomie


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Author: Lauren Casey
 */
 class Swipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)
        //val db = FirebaseDatabase.getInstance().reference
        val accept = findViewById<FloatingActionButton>(R.id.yes)
        val decline = findViewById<FloatingActionButton>(R.id.no)


        //grab user passed
        val user: User? = intent.getParcelableExtra("passedValue")
        user as User
        val tempDB :Database?= intent.getParcelableExtra("db")
        tempDB as Database

        val frag = ProfileHolder()
        val initFrag = supportFragmentManager.beginTransaction()
        var counter = 0

        val listOfMatches = tempDB.getMatchesList(user)
        while(counter< listOfMatches.size) {
            //i is find that user in DB
            val i = listOfMatches[counter]
            //set frag data as this user
            frag.setValues(i.getprofilepic() as Uri, i.getusername().toString(), i.getage(), i.getgender(), i.getlgbt(), i.getbio(), i.getsmoke(), i.getalco(), i.getpets(), i.getclean(), i.getdormone(), i.getdormtwo(), i.getdormthree())
            initFrag.add(R.id.profileHandlerFrag, frag)
            initFrag.commit()


            accept?.setOnClickListener {
                //add person to yes's and move on

                user.addToYes(listOfMatches[counter])
                counter += 1

            }
            decline?.setOnClickListener {
                //add person to no's and move on
                user.addToNo(listOfMatches[counter])
                counter += 1
            }
        }
    }

}




