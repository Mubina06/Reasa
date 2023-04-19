package com.example.reasa.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reasa.ButtonItem
import com.example.reasa.ItemList
import com.example.reasa.R

class buttonAdapter(val list: Array<ButtonItem>): RecyclerView.Adapter<buttonAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameb = itemView.findViewById<TextView>(R.id.nameb)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): buttonAdapter.MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.featured_item, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item = list.get(position)
        holder.nameb.setText(item.text)
        holder.nameb.setBackgroundColor(Color.argb(100, 36, 107, 252));
        holder.nameb.setTextColor(Color.argb(100,36, 107, 252))
    }


    override fun getItemCount(): Int {
        return list.size
    }

}