package com.example.roomie
//
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase


class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val numUsers = countOfUsers()
        val username = findViewById<TextView>(R.id.setusr1)
        val setpwd = findViewById<TextView>(R.id.setpwd)
        val confirmPwd = findViewById<TextView>(R.id.setpwd2)
        val email = findViewById<TextView>(R.id.inputemail)
        val errorSignUp = findViewById<TextView>(R.id.error1)

    //generate id

    findViewById<Button>(R.id.login)?.setOnClickListener{
            startActivity(Intent(this, Profile::class.java))
        }
        findViewById<Button>(R.id.signupBack).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<Button>(R.id.confirmsignUp).setOnClickListener {
            val newUser = User(numUsers.getUserCount())
            numUsers.increment()
            newUser.setusername(username.text.toString())

            //HOW TO SEND USER TO OTHER ACTIVITIES
            val intent = Intent(this, Profile::class.java)
            val bundle = Bundle()
            bundle.putParcelable("passedValue", newUser)
            intent.putExtra("passed", bundle)
            startActivity(intent)
            //


        }
    }
}

class countOfUsers(){
    var counter = 0;
    fun getUserCount():Int{
        return counter ++
    }
    fun increment(){
        counter++
    }
}


