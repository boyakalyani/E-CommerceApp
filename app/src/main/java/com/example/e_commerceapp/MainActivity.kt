package com.example.e_commerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var itemList2Adapter: ItemList2Adapter
    private lateinit var list: ArrayList<item2ScroollDataClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    private fun init() {
        val recyclerView = findViewById<RecyclerView>(R.id.main_recycler_id)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        list = ArrayList()
        itemsList()
        itemList2Adapter= ItemList2Adapter(list)
        recyclerView.adapter=itemList2Adapter
    }
    private fun itemsList(){
        list.add(item2ScroollDataClass(R.drawable.img_1,"Mobiles"))
        list.add(item2ScroollDataClass(R.drawable.img_2,"Fashion"))
        list.add(item2ScroollDataClass(R.drawable.img_3,"Electronics"))
        list.add(item2ScroollDataClass(R.drawable.img_4,"Home"))
        list.add(item2ScroollDataClass(R.drawable.img_5,"miniTV"))
        list.add(item2ScroollDataClass(R.drawable.img_6,"Deals"))
        list.add(item2ScroollDataClass(R.drawable.img_8,"Fresh"))
        list.add(item2ScroollDataClass(R.drawable.img_9,"Beauty"))
        list.add(item2ScroollDataClass(R.drawable.img_10,"Books,Toys"))
        list.add(item2ScroollDataClass(R.drawable.img_11,"Appliances"))
        list.add(item2ScroollDataClass(R.drawable.img_12,"Essentials"))
    }
}
