package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import androidx.fragment.app.Fragment

/**
 * Author: Lauren Casey
 */


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //verify with database here

        val signUpB = findViewById<Button>(R.id.signup)
        val logInB = findViewById<Button>(R.id.login)
        val forgotPwdB = findViewById<Button>(R.id.forgotpwd)
        val usrInput= findViewById<TextView>(R.id.usrname)
        val pwdInput = findViewById<TextView>(R.id.pwd)


       findViewById<Button>(R.id.signup).setOnClickListener{
           startActivity(Intent(this, SignUp::class.java))
       }
        findViewById<Button>(R.id.login).setOnClickListener{
            startActivity(Intent(this, Profile::class.java))
        }

        findViewById<Button>(R.id.forgotpwd).setOnClickListener{
            startActivity(Intent(this, ForgotPassword::class.java))
        }
    }
}