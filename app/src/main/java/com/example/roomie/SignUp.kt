package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

/**
 * Author: Lauren Casey
 */
class SignUp : AppCompatActivity() {

    val username = findViewById<TextView>(R.id.setusr1)
    val setpwd = findViewById<TextView>(R.id.setpwd)
    val confirmPwd = findViewById<TextView>(R.id.setpwd2)
    val email = findViewById<TextView>(R.id.inputemail)
    val signUpButton = findViewById<Button>(R.id.confirmsignUp)
    val errorSignUp = findViewById<TextView>(R.id.error1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpButton?.setOnClickListener{
            if((username != null) and (setpwd != null) and (confirmPwd != null) and (email != null)){
                startActivity(Intent(this, Matches::class.java))
            }else{
                errorSignUp.visibility = View.VISIBLE
                }
            }
        }
    }
