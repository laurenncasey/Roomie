package com.example.roomie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

/**
 * Author: Zach Terry
 */
class Message : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewChat)
        val matchName = findViewById<TextView>(R.id.UsernameDisplay)

        val messages = ArrayList<MessageItem>()

        matchName.text = "John Smith"

        //temp hardcode
        messages.add(MessageItem.SendMessageItem("Hey buddy"))
        messages.add(MessageItem.ReceiveMessageItem("hey what is up"))
        messages.add(MessageItem.SendMessageItem("Nothing much, how about you"))
        messages.add(MessageItem.ReceiveMessageItem("Just getting ready to go bowling, you wanna come with?"))

        val adapter = MessageAdapter(messages)

        recyclerView.adapter = adapter

        findViewById<Button>(R.id.SendMessageButton).setOnClickListener{
            //get text from text box
            var messageText = findViewById<TextView>(R.id.EditMessage)
            //add message as an item
            if (!messageText.text.toString().isEmpty()) {

            }
            messages.add(MessageItem.SendMessageItem(messageText.text.toString()))
            //notify adapter of change
            adapter.notifyItemRangeInserted(messages.size -1, 1)
            //clear text box
            messageText.text = ""

        }

    }
}

//sealed class with either send or receive classes
sealed class MessageItem {
    data class SendMessageItem(val message: String):MessageItem(){
    }

    data class ReceiveMessageItem(val message: String):MessageItem() {
    }
}

class MessageAdapter(private val messageList: List<MessageItem>) :RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = when (viewType) {
            //send message view type
            0 -> R.layout.chat_row_right
            //receive message view type
            1 -> R.layout.chat_row_left
            //do not be here please
            else -> throw IllegalArgumentException("Invalid type")
        }

        //inflate view with either send or receive layouts
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return ViewHolder(view)

    }

    //bind item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(messageList[position])

    }

    //determine if item is a sent or received message
    override fun getItemViewType(position: Int): Int {
        return when (messageList[position]) {
            is MessageItem.SendMessageItem -> 0
            is MessageItem.ReceiveMessageItem -> 1
            else -> 2
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //bind receive messages
        private fun bindReceiveMessage(item: MessageItem.ReceiveMessageItem) {

            val textView = itemView.findViewById<TextView>(R.id.matchMessage)

            textView.text = item.message


        }

        //bind send messages
        private fun bindSendMessage(item: MessageItem.SendMessageItem) {

            val textView = itemView.findViewById<TextView>(R.id.userMessage)

            textView.text = item.message

        }

        //bind goes to either bind send or receive messages
        fun bind(messageItem: MessageItem) {

            when (messageItem) {
                is MessageItem.ReceiveMessageItem -> bindReceiveMessage(messageItem)
                is MessageItem.SendMessageItem -> bindSendMessage(messageItem)
            }

        }

    }

}

