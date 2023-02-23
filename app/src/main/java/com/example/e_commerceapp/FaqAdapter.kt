package com.example.e_commerceapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FaqAdapter(val context: Context,private val menuList:ArrayList<Pair<String,String>>):RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {


    class FaqViewHolder(menuItem: View):RecyclerView.ViewHolder(menuItem){
        val tvFaqQuestion:TextView=itemView.findViewById(R.id.tvFaqQuestion)
        val tvFaqAnswer:TextView=itemView.findViewById(R.id.tvFaqAnswer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        var k=LayoutInflater.from(parent.context).inflate(R.layout.fag_itemm,parent,false)
        return FaqViewHolder(k)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        holder.tvFaqAnswer.text=menuList[position].second
        holder.tvFaqQuestion.text=menuList[position].first
    }
}