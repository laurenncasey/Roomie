package com.example.roomie
//
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import android.view.View
import android.widget.Button
import android.widget.TextView


class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val username = findViewById<TextView>(R.id.setusr1)
        val setpwd = findViewById<TextView>(R.id.setpwd)
        val confirmPwd = findViewById<TextView>(R.id.setpwd2)
        val email = findViewById<TextView>(R.id.inputemail)
        val errorSignUp = findViewById<TextView>(R.id.error1)

    //generate id

        var numOfUsers = 0


        findViewById<Button>(R.id.signupBack).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<Button>(R.id.confirmsignUp).setOnClickListener {
            Log.e("A", "Enter Confirm Sign up");
            //signing up creates a new user
            if(setpwd.text.toString() == confirmPwd.text.toString()) {//verify confirm and set pw are the same
                val newUser = User(usrname = username.text.toString())
                newUser.setusername(username.text.toString())
                newUser.setpassword(confirmPwd.text.toString())
                newUser.setemail(email.text.toString())
                numOfUsers += 1
                //access object to add user to
                val tempDB :Database?= intent.getParcelableExtra("db")
                tempDB as Database
                tempDB.addToDB(newUser)
                val bundle = Bundle()
                bundle.putParcelable("passedValue", newUser)
                bundle.putParcelable("db", tempDB)
                //Profile needs this user to add other preferences into their profile
                startActivity(Intent(this, Profile::class.java))
            }

        }
    }
}


