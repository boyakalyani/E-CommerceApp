package com.example.e_commerceapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CoolAdapter(private val userList: ArrayList<CoolDataClass>) : RecyclerView.Adapter<CoolAdapter.ViewHolder>() {
    private lateinit var context: Context

//    var onItemClick:((User) ->Unit)?=null

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val img=itemView.findViewById<ImageView>(R.id.imageView)
        val name=itemView.findViewById<TextView>(R.id.textView)
        val id=itemView.findViewById<TextView>(R.id.textView3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context=parent.context
        val view=LayoutInflater.from(context).inflate(R.layout.cool_drink_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user=userList[position]

        Glide.with(context).load(user.strDrinkThumb).into(holder.img)
        holder.name.text=user.strDrink+user.idDrink
        holder.id.text=user.idDrink

//        holder.itemView.setOnClickListener(){
//            onItemClick?.invoke(user)
//        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}




//
//class CoolAdapter(var context: Context):RecyclerView.Adapter<CoolAdapter.CoolViewHolder>() {
//     val list= ArrayList<CoolDataClass>()
//
//    class CoolViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
//        var image:ImageView=itemView.findViewById(R.id.imageView)
//        var drinkName:TextView=itemView.findViewById(R.id.textView)
//        var drinkId:TextView=itemView.findViewById(R.id.textView3)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoolViewHolder {
//        val view=LayoutInflater.from(parent.context).inflate(R.layout.cool_drink_item,parent,false)
//        return CoolViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CoolViewHolder, position: Int) {
//        val data=list[position]
//        holder.drinkName.text=data.strDrink
//        holder.drinkId.text=data.idDrink
//        Glide.with(context).load(data.strDrinkThumb).into(holder.image)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}