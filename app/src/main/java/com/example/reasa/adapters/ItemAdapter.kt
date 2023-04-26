package com.example.reasa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reasa.HomeFragment
import com.example.reasa.ItemList
import com.example.reasa.R

class ItemAdapter(val listrec: MutableList<ItemList>, homeFragment: HomeFragment): RecyclerView.Adapter<ItemAdapter.MyHolder>() {

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
        var itemrec = listrec.get(position)
        holder.photo.setImageResource(itemrec.photo)
        holder.star.setText(itemrec.star)
        holder.namee.setText(itemrec.namee)
        holder.city.setText(itemrec.city)
        holder.price.setText(itemrec.price)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(itemrec)
        }

    }

    override fun getItemCount(): Int {
        return listrec.size
    }

}