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

        val messages = ArrayList<MessageItem>()

        messages.add(MessageItem.SendMessageItem("hi gamer"))
        messages.add(MessageItem.ReceiveMessageItem("e"))
        messages.add(MessageItem.SendMessageItem("hi gamer"))
        messages.add(MessageItem.ReceiveMessageItem("e"))
        messages.add(MessageItem.SendMessageItem("hi gamer"))
        messages.add(MessageItem.ReceiveMessageItem("e"))
        messages.add(MessageItem.SendMessageItem("hi gamer"))
        messages.add(MessageItem.ReceiveMessageItem("e"))
        messages.add(MessageItem.SendMessageItem("hi gamer"))
        messages.add(MessageItem.ReceiveMessageItem("e"))

        val adapter = MessageAdapter(messages)

        recyclerView.adapter = adapter

        findViewById<Button>(R.id.SendMessageButton).setOnClickListener{
            //get text from text box
            var messageText = findViewById<TextView>(R.id.EditMessage)
            //add message as an item
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(messageList[position])

    }

    override fun getItemViewType(position: Int): Int {
        return when (messageList[position]) {
            is MessageItem.SendMessageItem -> 0
            is MessageItem.ReceiveMessageItem -> 1
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private fun bindReceiveMessage(item: MessageItem.ReceiveMessageItem) {

            val textView = itemView.findViewById<TextView>(R.id.matchMessage)

            textView.text = item.message


        }

        private fun bindSendMessage(item: MessageItem.SendMessageItem) {

            val textView = itemView.findViewById<TextView>(R.id.userMessage)

            textView.text = item.message

        }

        fun bind(messageItem: MessageItem) {

            when (messageItem) {
                is MessageItem.ReceiveMessageItem -> bindReceiveMessage(messageItem)
                is MessageItem.SendMessageItem -> bindSendMessage(messageItem)
            }

        }

    }

}

