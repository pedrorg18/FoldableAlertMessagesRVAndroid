package com.pedroroig.example.foldablemenutest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AlertMessagesAdapter(private var dataSet: List<String>): RecyclerView.Adapter<AlertMessagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewRoot: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewRoot.context)
            .inflate(R.layout.alert_message_row_item, viewRoot, false))
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        with(vh) {
            messageTextView.text = dataSet[position]
            if(position == 0) {
                val oldPaddingInPx = messageTextView.paddingLeft
                messageTextView.setPadding(oldPaddingInPx, 0, oldPaddingInPx, oldPaddingInPx)
            }
        }
    }

    class ViewHolder(viewRoot: View) :
        RecyclerView.ViewHolder(viewRoot) {
        val messageTextView: TextView = viewRoot.findViewById(R.id.messageTextView)
    }
}