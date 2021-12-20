package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


/**
 * Author: Lauren Casey
 */
class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        //we can use this to set any about or information for the user in the settings
        val setText: TextView = findViewById(R.id.settingtext)

        val bundle = intent.getExtras();
        val db: Database? = bundle?.getParcelable("db")
        val username: String? = bundle?.getString("passedValue")
        val user: User? = db?.getUser(username)


        setText.text = "Roomie consists of different features to perfectly match you to a roommate at UW-Eau Claire. Any information filled out in your profile may be displayed in your roommate profile for the public to see. Any information filled in your roommate preferences will stay private from the public eye, but will be used in the matching algorithm. You may reset your profile or roommate preferences, which clears all information back to the default. You may delete your account. Deleting your account is irreversible and you will lose all information tied to your account. Roomie does not track data, and does not ask for any permissions outside the app. We simply take your information for a matching algorith and profile to find you an ideal roommate. Thanks for using Roomie!"

        findViewById<Button>(R.id.back).setOnClickListener{
            startActivity(Intent(this, Profile::class.java))

        }

        findViewById<Button>(R.id.resetProf).setOnClickListener{
            //save all information to database
            if (user != null) {
                if (db != null) {
                    db.getUser(username)?.resetRoommatePreferences()
                };
            }

            Toast.makeText(applicationContext, "Roommate Preferences reset", Toast.LENGTH_SHORT).show()

        }

        findViewById<Button>(R.id.resetRoom).setOnClickListener{
            //save all information to database
            if (user != null) {
                if (db != null) {
                    db.getUser(username)?.clear()
                };
            }

            Toast.makeText(applicationContext, "Roommate Preferences reset", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.delAcc).setOnClickListener{
            if (user != null) {
                db?.removeUser( user)
                startActivity(Intent(this, MainActivity::class.java))
            };
            Toast.makeText(applicationContext, "Account Successfully Deleted", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.Logout).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}