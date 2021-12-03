package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import android.widget.Toast



import android.os.AsyncTask




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
                signupUser()
                startActivity(Intent(this, Matches::class.java))
            }else{
                errorSignUp.visibility = View.VISIBLE
                }
            }
        }
    private fun signupUser() {
        val sUser: String = username.getText().toString().trim()
        val sSetPwd: String = setpwd.getText().toString().trim()
        val sConfirmPwd: String = confirmPwd.getText().toString().trim()
        val sEmail: String = email.getText().toString().trim()
        if (sUser.isEmpty()) {
            errorSignUp.setError("Username required")
            username.requestFocus()
            return
        }
        if (sSetPwd.isEmpty()) {
            errorSignUp.setError("Password Required")
            setpwd.requestFocus()
            return
        }
        if (sConfirmPwd.isEmpty()) {
            errorSignUp.setError("Need to Confirm Password")
            confirmPwd.requestFocus()
            return
        }
        if (sEmail.isEmpty()) {
            errorSignUp.setError("Must enter email address")
            email.requestFocus()
            return
        }
        if (!sConfirmPwd.equals(sSetPwd)) {
            errorSignUp.setError("Confirmed != set pw")//Fix text according to text box size
            setpwd.requestFocus()
            return
        }
        class SignupUser : AsyncTask<Void, Void, Void>() {
            protected override fun doInBackground(vararg voids: Void): Void? {

                //creating a task
                val user: UserEntity = UserEntity()

                user.setUserName(sUser)
                user.setPwd(sConfirmPwd)
                user.setUserEmail(sEmail)


                //adding to database
                DatabaseClient.getInstance(applicationContext)?.getAppDb()
                    ?.userDao()
                    ?.insert(user)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                finish()
                startActivity(Intent(applicationContext, MainActivity::class.java))
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG).show()
            }
        }

        val su = SignupUser()
        su.execute()
    }
    }

