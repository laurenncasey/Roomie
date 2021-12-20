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
        val bundle = intent.extras;
        val db: Database? = bundle?.getParcelable("db")
        val username: String? = bundle?.getString("passedValue")
        val user: User? = db?.getUser(username)

        val frag = ProfileHolder()
        val initFrag = supportFragmentManager.beginTransaction()
        var counter = 0

        val listOfMatches = user?.let { db.getMatchesList(it) }
        if (listOfMatches != null) {
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

}




