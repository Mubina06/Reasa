package com.example.reasa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reasa.ExploreeFragment
import com.example.reasa.ItemList
import com.example.reasa.R
import com.example.reasa.recitems

class ItemExpAdapter(val listexprec: MutableList<recitems>, exploreeFragment: ExploreeFragment): RecyclerView.Adapter<ItemExpAdapter.MyHolder>() {

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
        var expitemrec = listexprec.get(position)
        holder.photo.setImageResource(expitemrec.mainphoto)
        holder.star.setText(expitemrec.rstar)
        holder.namee.setText(expitemrec.rtv14)
        holder.city.setText(expitemrec.rtv15)
        holder.price.setText(expitemrec.rprice)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(expitemrec)
        }
    }

    override fun getItemCount(): Int {
        return listexprec.size
    }

}