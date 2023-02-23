package com.example.e_commerceapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val userList: ArrayList<User>)
    : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var context: Context


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image_url = itemView.findViewById<ImageView>(R.id.image_url_id)
        val name = itemView.findViewById<TextView>(R.id.name_id)
        val id = itemView.findViewById<TextView>(R.id.id_id)
        val tagline = itemView.findViewById<TextView>(R.id.tagline_id)
        val first_brewed = itemView.findViewById<TextView>(R.id.first_brewed_id)
        val description = itemView.findViewById<TextView>(R.id.description_id)
        val abv = itemView.findViewById<TextView>(R.id.abv_id)
        val ibu = itemView.findViewById<TextView>(R.id.ibu_id)
        val target_fg = itemView.findViewById<TextView>(R.id.target_fg_id)
        val  target_og= itemView.findViewById<TextView>(R.id.target_og_id)
        val  ebc= itemView.findViewById<TextView>(R.id.ebc_id)
        val srm = itemView.findViewById<TextView>(R.id.srm_id)
        val ph = itemView.findViewById<TextView>(R.id.ph_id)
        val  attenuation_level= itemView.findViewById<TextView>(R.id.attenuation_level_id)

//        fun initialize(userList: User, action: OnCarItemClickListener) {
//            name.text = userList.name
//            description.text = userList.description
////            img.setImageResource(userList.strDrinkThumb)
//
//            itemView.setOnClickListener() {
//                action.onItemClick(userList, adapterPosition)
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.iitem_beer, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        Glide.with(context).load(user.image_url).into(holder.image_url)
        holder.name.text = user.name
        holder.id.text = user.id.toString()
        holder.first_brewed.text = user.first_brewed
        holder.tagline.text = user.tagline
        holder.target_fg.text = user.target_fg.toString()
        holder.abv.text = user.abv.toString()
        holder.ibu.text = user.ibu.toString()
        holder.description.text = user.description
        holder.target_og.text = user.target_og.toString()
        holder.ebc.text = user.ebc.toString()
        holder.srm.text = user.srm.toString()
        holder.ph.text = user.ph.toString()
        holder.attenuation_level.text = user.attenuation_level.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

interface OnCarItemClickListener {
    fun onItemClick(item: User,position: Int)
}
