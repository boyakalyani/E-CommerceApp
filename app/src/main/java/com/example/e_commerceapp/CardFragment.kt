package com.example.e_commerceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

@SuppressLint("MissingInflatedId")
class CardFragment : Fragment() {
    //    val api = "https://fakestoreapi.com/products/1"
    lateinit var cooldapter: CoolAdapter
    var recycler: RecyclerView? = null
    var userList = arrayListOf<CoolDataClass>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val jyothi = inflater.inflate(R.layout.fragment_card, container, false)
        recycler = jyothi.findViewById(R.id.recyclerDrik_id)

        val apiSample = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail"

        val reQueue: RequestQueue = Volley.newRequestQueue(this.requireContext())
        val request = JsonObjectRequest(Request.Method.GET, apiSample, null, { res ->
            Log.d("Volley sample", res.toString())

            val jsonArray = res.getJSONArray("drinks")
            for (i in 0 until jsonArray.length()) {
                val jsonobj = jsonArray.getJSONObject(i)
                Log.d("Volley Sample", jsonobj.toString())

                val drinks = CoolDataClass(
                    jsonobj.getString("strDrink"),
                    jsonobj.getString("strDrinkThumb"),
                    jsonobj.getString("idDrink")
                )
                userList.add(drinks)
                Log.d("Volley sample", userList.toString())
            }
            recycler?.layoutManager = LinearLayoutManager(requireContext())
            recycler?.adapter = CoolAdapter(userList)

        }, { err ->
            Log.d("Fail", err.message.toString())
        })
//        val request = StringRequest(Request.Method.GET,apiSample, { result ->
//            Log.d("Volley example", result.toString())
//        },{err ->
//            Log.d("volley Example",err.message.toString())
//        })
        reQueue.add(request)
        return jyothi
    }
}



//here to
//        val apiSample = "https://fakestoreapi.com/products/1"
//        val reQueue: RequestQueue = Volley.newRequestQueue(this.requireContext())
//        val request = StringRequest(Request.Method.GET, apiSample, { result ->
//            Log.d("Volley example", result.toString())
//        }, { err ->
//            Log.d("volley Example", err.message.toString())
//        })
//        reQueue.add(request)
        // check logcoat