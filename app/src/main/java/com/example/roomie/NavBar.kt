package com.example.roomie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
//Author: Lauren
/**
 * LEAVE COMMENTED STUFF ON HERE FOR NOW UNTIL I KNOW FOR SURE THAT WE WILL NOT NEED IT FOR FINAL PRODUCT
 */
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavBar.newInstance] factory method to
 * create an instance of this fragment.
 */
open class NavBar : Fragment(){
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nav_bar, container, false)
        val mesBut = view.findViewById<Button>(R.id.messageNav)
        val profBut = view.findViewById<Button>(R.id.profileNav)
        val matchBut = view.findViewById<Button>(R.id.findMatch)

        mesBut?.setOnClickListener{
            startActivity(Intent(activity, Message::class.java))
        }
        profBut?.setOnClickListener{
            startActivity(Intent(activity, Profile::class.java))
        }
        matchBut?.setOnClickListener{
            startActivity(Intent(activity, Swipe::class.java))
        }

        return view
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment NavBar.
//         */
//        @JvmStatic
//        fun newInstance() =
//            NavBar().apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }


}