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

    val signUpB = findViewById<Button>(R.id.signup)
    val logInB = findViewById<Button>(R.id.login)
    val forgotPwdB = findViewById<Button>(R.id.forgotpwd)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signUpB?.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        forgotPwdB?.setOnClickListener {
            startActivity(Intent(this, ResetPassword::class.java))
        }

        logInB?.setOnClickListener {
            //if cannot find usr name or pwd in database, opt red and try forgot password?

            startActivity(Intent(this, Matches::class.java))
        }
    }
}