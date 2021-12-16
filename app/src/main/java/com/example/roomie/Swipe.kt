package com.example.roomie


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


        val frag = ProfileHolder()
        val initFrag = supportFragmentManager.beginTransaction()


        val listOfPeople = emptyList<String>()



        var counter = 0

        while(counter<listOfPeople.size) {
            //i is find that user in DB
            val i = null
            initFrag.add(R.id.profileHandlerFrag, frag)
            initFrag.commit()


            accept?.setOnClickListener {
                //add person to yes's and move on

                user?.addToYes(i.toString())
                counter += 1

            }
            decline?.setOnClickListener {
                //add person to no's and move on
                user?.addToNo(i.toString())
                counter += 1
            }
        }

         //Toast.makeText(applicationContext, "Username set.", Toast.LENGTH_SHORT).show()
   }

}




