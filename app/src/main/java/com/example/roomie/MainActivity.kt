package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * Author: Lauren Casey
 */


class MainActivity : AppCompatActivity() {

    val usrInput= findViewById<TextView>(R.id.usrname)
    val pwdInput = findViewById<TextView>(R.id.pwd)
    //verify with database here

    val signUpB = findViewById<Button>(R.id.signup)
    val logInB = findViewById<Button>(R.id.login)
    val forgotPwdB = findViewById<Button>(R.id.forgotpwd)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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