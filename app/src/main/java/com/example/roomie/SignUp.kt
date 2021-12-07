package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import android.widget.Toast
import android.widget.EditText




import android.os.AsyncTask




/**
 * Author: Lauren Casey
 */
class SignUp : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val username = findViewById<TextView>(R.id.setusr1)
        val setpwd = findViewById<TextView>(R.id.setpwd)
        val confirmPwd = findViewById<TextView>(R.id.setpwd2)
        val email = findViewById<TextView>(R.id.inputemail)
        val errorSignUp = findViewById<TextView>(R.id.error1)




        findViewById<Button>(R.id.signupBack).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<Button>(R.id.confirmsignUp).setOnClickListener{

            //ERROR CHECK NEEDS FIXING


            if((username != null) and (setpwd != null) and (confirmPwd != null) and (email != null)){
                signupUser(username, setpwd, confirmPwd, email, errorSignUp)
                startActivity(Intent(this, Profile::class.java))
            }else{
                errorSignUp.visibility = View.VISIBLE
                }
            }
        }
    private fun signupUser(username: TextView, setpwd: TextView, confirmPwd: TextView, email: TextView, errorSignUp: TextView) {
        val sUser: String = username.text.toString().trim()
        val sSetPwd: String = setpwd.text.toString().trim()
        val sConfirmPwd: String = confirmPwd.text.toString().trim()
        val sEmail: String = email.text.toString().trim()
        if (sUser.isEmpty()) {
            errorSignUp.error = "Username required"
            username.requestFocus()
            return
        }
        if (sSetPwd.isEmpty()) {
            errorSignUp.error = "Password Required"
            setpwd.requestFocus()
            return
        }
        if (sConfirmPwd.isEmpty()) {
            errorSignUp.error = "Need to Confirm Password"
            confirmPwd.requestFocus()
            return
        }
        if (sEmail.isEmpty()) {
            errorSignUp.error = "Must enter email address"
            email.requestFocus()
            return
        }
        if (!sConfirmPwd.equals(sSetPwd)) {
            errorSignUp.error = "Confirmed != set pw"//Fix text according to text box size
            setpwd.requestFocus()
            return
        }
        class SignupUser : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg voids: Void): Void? {

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
}

