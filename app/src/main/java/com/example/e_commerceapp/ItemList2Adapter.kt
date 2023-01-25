package com.example.e_commerceapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemList2Adapter(private var list:List<item2ScroollDataClass>): RecyclerView.Adapter<ItemList2Adapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout_2,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item2Scrooll=list[position]
        holder.img.setImageResource(item2Scrooll.image)
        holder.txt.text=item2Scrooll.itemText
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var img:ImageView=itemView.findViewById(R.id.img_id)
        var txt:TextView=itemView.findViewById(R.id.textView_id)
    }
}
