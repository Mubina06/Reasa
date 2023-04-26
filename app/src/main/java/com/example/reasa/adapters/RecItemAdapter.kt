package com.example.reasa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reasa.HomeFragment
import com.example.reasa.R
import com.example.reasa.recitems

class RecItemAdapter(var list: MutableList<recitems>, homeFragment: HomeFragment): RecyclerView.Adapter<RecItemAdapter.MyHolder>() {

    var onItemClick : ((recitems) -> Unit)? = null
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var rphoto: ImageView = itemView.findViewById<ImageView>(R.id.mainPhoto)
        var rstar: TextView = itemView.findViewById<TextView>(R.id.mstar)
        var rnamee: TextView = itemView.findViewById<TextView>(R.id.textView14)
        var rcity: TextView = itemView.findViewById<TextView>(R.id.textView15)
        var rprice: TextView = itemView.findViewById<TextView>(R.id.mprice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.rec_item, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item = list[position]
        holder.rphoto.setImageResource(item.mainphoto)
        holder.rstar.text = item.rstar
        holder.rnamee.text = item.rtv14
        holder.rcity.text = item.rtv15
        holder.rprice.text = item.rprice

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

}