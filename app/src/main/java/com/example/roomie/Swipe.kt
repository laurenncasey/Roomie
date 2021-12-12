package com.example.roomie


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.*
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


/**
 * Author: Lauren Casey
 */
 class Swipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)
        val db = FirebaseDatabase.getInstance().reference
        //val db = FirebaseDatabase.getInstance()
//        //check this reference
        val frag = Fragment(R.layout.fragment_profile_holder)
        val testing = findViewById<Button>(R.id.tempButtonForTest)

        val testUser = User(1)

        testing?.setOnClickListener{
            ///in main, on login, make a new user and set ID

            db.push().setValue(testUser)

            Toast.makeText(applicationContext, "Username set.", Toast.LENGTH_SHORT).show()

        }
//
//        var db: FirebaseDatabase = FirebaseDatabase.getInstance()
//        var dbRef: DatabaseReference = db.getReference("Data")
//
//        dbRef.addValueEventListener(object :ValueEventListener
//        {
//            override fun onDataChange(snapshot: DataSnapshot) {
//            //gets data from Firebase console with the snapshot.getValue(type.Class)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(applicationContext, "Fail to get data.", Toast.LENGTH_SHORT).show()
//            }
//
//        })
   }

}

//class FragAdap(fragment: Fragment) : FragmentStateAdapter(fragment) {
//    override fun getItemCount(): Int {
//        return 1
//    }
//
//    override fun createFragment(position: Int): Fragment {
//        if(position % 2 == 0){
//            return Fragment(R.layout.fragment_profile_holder)
//        }else{
//            return Fragment(R.layout.fragment_profile_handler_two)
//        }
//    }
//
//
//}




