package com.example.e_commerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCatagoresSecond(private var list1:List<DataCategeroes2>): RecyclerView.Adapter<AdapterCatagoresSecond.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.rv3_item,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item2Scrooll=list1[position]
        holder.img3.setImageResource(item2Scrooll.imgList)
        holder.txt3.text=item2Scrooll.textList
        holder.img4.setImageResource(item2Scrooll.imgs2List)
        holder.txt4.text=item2Scrooll.text2List2
    }

    override fun getItemCount(): Int {
        return list1.size
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var img3: ImageView =itemView.findViewById(R.id.imgList2_id)
        var txt3: TextView =itemView.findViewById(R.id.textList_id)
        var img4: ImageView =itemView.findViewById(R.id.img2List2_id)
        var txt4: TextView =itemView.findViewById(R.id.text2List2_id
        )
    }
}
