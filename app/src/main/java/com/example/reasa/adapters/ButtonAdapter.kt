package com.example.reasa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reasa.ButtonItem
import com.example.reasa.HomeFragment
import com.example.reasa.R

class ButtonAdapter(val listbutton: MutableList<ButtonItem>, homeFragment: HomeFragment): RecyclerView.Adapter<ButtonAdapter.MyHolder>() {

    var onItemClick : ((ButtonItem) -> Unit)? = null
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var nameb: TextView = itemView.findViewById<TextView>(R.id.nameb)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonAdapter.MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.button_item, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item = listbutton[position]
        holder.nameb.text = item.text

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return listbutton.size
    }

}