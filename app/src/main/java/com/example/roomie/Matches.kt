package com.example.roomie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

/**
 * Author: Zach Terry
 */
class Matches : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)

        val recyclerView = findViewById<RecyclerView>(R.id.MatchesRecycler)

        recyclerView.layoutManager = LinearLayoutManager(this)

//        val user: User? = intent.getParcelableExtra("passedValue")

        val matches = ArrayList<ItemsViewModel>()
//        val matchedUsers = user?.getMatchesList()

//        for (i in matchedUsers.orEmpty()) {
//            matches.add(ItemsViewModel(user.profilePic, user.fullname))
//        }

        for (i in 1..20) {
            matches.add(ItemsViewModel("jeffrey"))
        }

        val adapter = MatchesAdapter(matches)

        recyclerView.adapter = adapter

    }
}

//data class ItemsViewModel(val image: Int, val name: String) {
//
//}

data class ItemsViewModel(val name: String) {

}

class MatchesAdapter(private val matchesList: List<ItemsViewModel>) :RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.matches_view_design, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = matchesList[position]

//        holder.pictureView.setImageResource(ItemsViewModel.image)

        holder.textView.text = ItemsViewModel.name

    }

    override fun getItemCount(): Int {
        return matchesList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

//        val pictureView = itemView.findViewById<ImageView>(R.id.PictureView)
        val textView = itemView.findViewById<TextView>(R.id.NameView)

    }

}