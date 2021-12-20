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


       // val listOfMatches = user?.let { db.getMatchesList(it) }
        var listOfMatches: ArrayList<User> = ArrayList()

        val newUser3 = User(usrname = "Test2")
        newUser3.setpassword("1235")
        newUser3.setusername("Test2")
        newUser3.setfullname("Jill Doe")
        newUser3.setgender(1)
        newUser3.setlgbt(1)
        newUser3.setclean(1)
        newUser3.setwake(1)
        newUser3.setintrovert(1)
        newUser3.setpets(1)
        newUser3.setalco(1)
        newUser3.setsmoke(1)
        newUser3.setdormone(1)
        newUser3.setdormtwo(2)
        newUser3.setdormthree(3)
        newUser3.setRClean(1)
        newUser3.setRDrinks(1)
        newUser3.setRGender(1)
        newUser3.setRIE(1)
        newUser3.setRLgbt(1)
        newUser3.setRPets(1)
        newUser3.setRSmokes(1)
        newUser3.setRWaketime(1)
        //listOfMatches.add(newUser3)

        val newUser = User(usrname = "Temp1")
        newUser.setpassword("1234")
        newUser.setusername("Temp1")
        newUser.setfullname("Meikayla Bates")
        newUser.setgender(1)
        newUser.setlgbt(1)
        newUser.setclean(1)
        newUser.setwake(1)
        newUser.setintrovert(1)
        newUser.setpets(1)
        newUser.setalco(1)
        newUser.setsmoke(1)
        newUser.setdormone(1)
        newUser.setdormtwo(2)
        newUser.setdormthree(3)
        newUser.setRClean(1)
        newUser.setRDrinks(1)
        newUser.setRGender(1)
        newUser.setRIE(1)
        newUser.setRLgbt(1)
        newUser.setRPets(1)
        newUser.setRSmokes(1)
        newUser.setRWaketime(1)
       // listOfMatches.add(newUser)
        if(user!=null) {

           // listOfMatches = db?.getMatchesList(user)
        }


        var stopper = 1
        if (listOfMatches != null) {
            while(counter< listOfMatches.size) {
                //i is find that user in DB
                val i = listOfMatches[counter]
                //set frag data as this user
                if(stopper == 1) {

                    frag.setValues(i.getprofilepic() as Uri, i.getusername().toString(), i.getage(), i.getgender(), i.getlgbt(), i.getbio(), i.getsmoke(), i.getalco(), i.getpets(), i.getclean(), i.getdormone(), i.getdormtwo(), i.getdormthree())
                    initFrag.add(R.id.profileHandlerFrag, frag)
                    initFrag.commit()
                    stopper++
                }



                accept?.setOnClickListener {
                    //add person to yes's and move on

                   /* if (user != null) {
                        user.addToYes(listOfMatches[counter])
                    }*/
                    counter += 1
                    stopper = 1

                }
                decline?.setOnClickListener {
                    //add person to no's and move on
                   /* if (user != null) {
                        user.addToNo(listOfMatches[counter])
                    }*/
                    counter += 1
                    stopper = 1
                }
            }
        }
    }

}




