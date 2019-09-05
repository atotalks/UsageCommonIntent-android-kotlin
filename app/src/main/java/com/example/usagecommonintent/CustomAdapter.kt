package com.example.usagecommonintent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val context: Context, val listItems: ArrayList<ListItem>):
    RecyclerView.Adapter<CustomAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {

        return listItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder?.bind(listItems[position], context)
        holder?.list_item?.setOnClickListener { v ->
            itemClick?.onClick(v, position)
        }
    }

    interface ItemClick
    {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {


        val list_item = itemView?.findViewById<TextView>(R.id.id_listitem)

        fun bind (listItem: ListItem, context: Context) {

            list_item?.text = listItem.listName


        }
    }
}