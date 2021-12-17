package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import androidx.fragment.app.Fragment
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
        val forgotPwdB = findViewById<Button>(R.id.forgotpwd)
        val usrInput= findViewById<TextView>(R.id.usrname)
        val pwdInput = findViewById<TextView>(R.id.pwd)

        val DB = Database(0)

       findViewById<Button>(R.id.signup).setOnClickListener{
           //HAVE TO PASS USER
           val intent = Intent(this, SignUp::class.java)
           val bundle = Bundle()
           val user = User(usrInput.text.toString())
           bundle.putParcelable("passedValue", user)
           bundle.putParcelable("db", DB)
           intent.putExtra("passed", bundle)
           startActivity(intent)
       }
        findViewById<Button>(R.id.login).setOnClickListener{

                startActivity(Intent(this, Profile::class.java))
        }

        findViewById<Button>(R.id.forgotpwd).setOnClickListener{
            startActivity(Intent(this, ForgotPassword::class.java))
        }
    }
}