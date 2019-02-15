package com.jaffa.hardy.im.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaffa.hardy.im.R

class ContactListAdapter(val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(patent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_contact_item,patent,false)

        return ContactListItemViewHolder(view)
    }

    override fun getItemCount(): Int = 30

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class ContactListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}