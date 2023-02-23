package com.example.e_commerceapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ActionTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.interfaces.TouchListener
import com.denzcoskun.imageslider.models.SlideModel

class HomeFragment : Fragment() {
    private lateinit var itemList2Adapter: ItemList2Adapter
    private lateinit var list: ArrayList<item2ScroollDataClass>

    private lateinit var adapterCatagores: AdapterCatagores
    private lateinit var adapterCatagoresSecond: AdapterCatagoresSecond
    private lateinit var list2: ArrayList<DataCatageroes>
    private lateinit var list3:ArrayList<DataCategeroes2>
    var itemClickListener: ItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var kalyani = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = kalyani.findViewById<RecyclerView>(R.id.main_recycler_id)
        val recyclerView2 = kalyani.findViewById<RecyclerView>(R.id.recycler2_id)
        val recyclerView3 = kalyani.findViewById<RecyclerView>(R.id.recycler3_id)

//        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recyclerView2.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        recyclerView3.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        list = ArrayList()
        itemList2Adapter = ItemList2Adapter(list)
        recyclerView.adapter = itemList2Adapter
        list.add(item2ScroollDataClass(R.drawable.mobi, "Mobiles"))
        list.add(item2ScroollDataClass(R.drawable.img_32, "Fashion"))
        list.add(item2ScroollDataClass(R.drawable.headset, "Electronics"))
        list.add(item2ScroollDataClass(R.drawable.homeimg, "Home"))
        list.add(item2ScroollDataClass(R.drawable.img_5, "miniTV"))
        list.add(item2ScroollDataClass(R.drawable.img_6, "Deals"))
        list.add(item2ScroollDataClass(R.drawable.img_8, "Fresh"))
        list.add(item2ScroollDataClass(R.drawable.img_9, "Beauty"))
        list.add(item2ScroollDataClass(R.drawable.img_10, "Books,Toys"))
        list.add(item2ScroollDataClass(R.drawable.img_11, "Appliances"))
        list.add(item2ScroollDataClass(R.drawable.img_12, "Essentials"))

        list2 = ArrayList()
        adapterCatagores = AdapterCatagores(list2)
        recyclerView2.adapter = adapterCatagores
        list2.add(DataCatageroes(R.drawable.cooldrinks, "Beers", R.drawable.beer, "Cooldrinks"))
        list2.add(DataCatageroes(R.drawable.grocery, "Vegetables", R.drawable.vegetabl, "Grocery"))
        list2.add(DataCatageroes(R.drawable.screenshot, "Shoes", R.drawable.shoes, "Clothing"))


        list3 = ArrayList()
        adapterCatagoresSecond = AdapterCatagoresSecond(list3)
        recyclerView3.adapter = adapterCatagoresSecond
        list3.add(DataCategeroes2(R.drawable.waterbottle, "WaterBottles", R.drawable.toys, "Toys"))
        list3.add(DataCategeroes2(R.drawable.beaty, "BeautyProducts", R.drawable.jewelery, "Jewellery") )
        list3.add(DataCategeroes2(R.drawable.mobiles, "Electronic devices", R.drawable.homeproducts, "Home Products"))

        val imageSlider = kalyani.findViewById<ImageSlider>(R.id.image_slider)
        // init imageSlider

        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel(R.drawable.img_25))
        imageList.add(SlideModel(R.drawable.img_26))
        imageList.add(SlideModel(R.drawable.img_27))
        imageList.add(SlideModel(R.drawable.img_24))
        imageList.add(SlideModel(R.drawable.img_23))
        imageList.add(SlideModel(R.drawable.img_31))

        imageSlider.setImageList(imageList)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
            }
        })

        imageSlider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
            }
        })

        imageSlider.setTouchListener(object : TouchListener {
            override fun onTouched(touched: ActionTypes) {
                if (touched == ActionTypes.DOWN) {
                    imageSlider.stopSliding()
                } else if (touched == ActionTypes.UP) {
                    imageSlider.startSliding(1000)
                }
            }
        })
        return kalyani
    }
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.newmenu, menu)
//        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)
//        val searchView: androidx.appcompat.widget.SearchView = searchItem.getActionView() as androidx.appcompat.widget.SearchView
//
//        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                return false
//            }
//            override fun onQueryTextChange(msg: String): Boolean {
//                filter(msg)
//                return false
//            }
//        })
//        return true
//    }
//
//
//    private fun filter(text: String) {
//        val filteredlist: ArrayList<DataCatageroes> = ArrayList()
//        for (item in list2) {
//            if (item.textCat.toLowerCase().contains(text.toLowerCase())) {
//                filteredlist.add(item)
//            }
//        }
//        if (filteredlist.isEmpty()) {
//            Toast.makeText(this@HomeFragment.requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show()
//        } else {
//            adapterCatagores.filterList()
//        }
//    }
}