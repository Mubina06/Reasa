package com.example.reasa.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reasa.ItemList
import com.example.reasa.R

class itemAdapter(val list: Array<ItemList>): RecyclerView.Adapter<itemAdapter.MyHolder>() {

    var onItemClick : ((ItemList) -> Unit)? = null
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var photo = itemView.findViewById<ImageView>(R.id.photo)
        var star = itemView.findViewById<TextView>(R.id.star)
        var namee = itemView.findViewById<TextView>(R.id.namee)
        var city = itemView.findViewById<TextView>(R.id.city)
        var price = itemView.findViewById<TextView>(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.featured_item, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item = list.get(position)
        holder.photo.setImageResource(item.photo)
        holder.star.setText(item.star)
        holder.namee.setText(item.namee)
        holder.city.setText(item.city)
        holder.price.setText(item.price)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}