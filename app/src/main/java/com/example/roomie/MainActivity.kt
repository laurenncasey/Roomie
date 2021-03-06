package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

//import com.google.firebase.FirebaseOptions
//import com.google.firebase.auth.FirebaseAuthException
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.ktx.Firebase

/**
 * Author: Lauren Casey
 */


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpB = findViewById<Button>(R.id.signup)
        val logInB = findViewById<Button>(R.id.login)
        val usrInput= findViewById<TextView>(R.id.usrname)
        val pwdInput = findViewById<TextView>(R.id.pwd)
        val bundle = intent.extras;
        val db: Database? = bundle?.getParcelable("db")
        val username: String? = bundle?.getString("passedValue")
        val user: User? = db?.getUser(username)
        val DB: Database
        if(db!=null) {
            DB= db
        }
        else {
            DB = Database(0, ArrayList())
        }

       findViewById<Button>(R.id.signup).setOnClickListener{
           //HAVE TO PASS USER
           val bundle = Bundle()
           bundle.putString("passedValue", "")
           bundle.putParcelable("db", DB)
           intent = Intent(this@MainActivity, SignUp::class.java)
           intent.putExtras(bundle)
           startActivity(intent)
       }
        findViewById<Button>(R.id.login).setOnClickListener{
                //check for a user with the same user name and password, call function in database class
                val tempUsername = usrInput.text.toString()
                val tempPassword = pwdInput.text.toString()
                val user: User? = DB.findUser(tempUsername, tempPassword)

                if(user != null){
                    val bundle = Bundle()
                    bundle.putString("passedValue", user.getusername())
                    bundle.putParcelable("db", DB)
                    intent = Intent(this@MainActivity, Profile::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext, "Could not login, retry username and password", Toast.LENGTH_SHORT).show()
                }

        }

    }
}