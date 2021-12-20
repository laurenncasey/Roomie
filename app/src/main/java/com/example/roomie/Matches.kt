package com.example.roomie

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Author: Zach Terry
 */
class Matches : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)

        val recyclerView = findViewById<RecyclerView>(R.id.MatchesRecycler)

        recyclerView.layoutManager = LinearLayoutManager(this)

        //pass in user & db
        val bundle = intent.extras;
        val db: Database? = bundle?.getParcelable("db")
        val username: String? = bundle?.getString("passedValue")
        val user: User? = db?.getUser(username)

        //list to be passed into view
        val matches = ArrayList<ItemsViewModel>()

//        if (user != null) {
//
//            //list of yes list
//            val userYesList = user.getYesList()
//
//            //for all users in yes list, check if they are a match. If so, add to matches list
//            for (i in userYesList) {
//
//                if (i.foundInYes(user)) {
//
//                    val matchName = i.fullname
//
//                    matches.add(ItemsViewModel(matchName))
//
//                }
//            }
//        }

        matches.add(ItemsViewModel("John Smith"))
        matches.add(ItemsViewModel("Jill Doe"))
        matches.add(ItemsViewModel("Jack Daniels"))
        matches.add(ItemsViewModel("Jeffrey"))
        matches.add(ItemsViewModel("Jeffrey 2"))
        matches.add(ItemsViewModel("Spider Man"))
        matches.add(ItemsViewModel("Bat Man"))
        matches.add(ItemsViewModel("Iron Man"))
        matches.add(ItemsViewModel("Jeffrey 3"))
        matches.add(ItemsViewModel("Zach Terry"))
        matches.add(ItemsViewModel("Jeffrey 4"))
        matches.add(ItemsViewModel("Jeff"))
        matches.add(ItemsViewModel("Jeffrey 6"))


        // create adapter with matches list & on click listener to message activity
        val intent = Intent(this, Message::class.java)
        val adapter = MatchesAdapter(matches) {itemsViewModel -> startActivity(intent) }

        //set adpadter for recycler view
        recyclerView.adapter = adapter

    }
}

//data class for individual items
data class ItemsViewModel(val name: String) {

}

//custom adapter class for recycler view
class MatchesAdapter(private val matchesList: List<ItemsViewModel>, private val listener: (ItemsViewModel) -> Unit) :RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.matches_view_design, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = matchesList[position]

//        holder.pictureView.setImageResource(ItemsViewModel.image)

        holder.textView.text = itemsViewModel.name

        holder.itemView.setOnClickListener{listener(itemsViewModel)}

    }

    override fun getItemCount(): Int {
        return matchesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        //        val pictureView = itemView.findViewById<ImageView>(R.id.PictureView)
        val textView = itemView.findViewById<TextView>(R.id.NameView)

    }

}