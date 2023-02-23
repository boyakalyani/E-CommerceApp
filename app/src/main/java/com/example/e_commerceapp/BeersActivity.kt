package com.example.e_commerceapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class BeersActivity : AppCompatActivity() {
    var recycler: RecyclerView?=null
    var userList= arrayListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beers)


        recycler = findViewById(R.id.recyclerView)
        val apiSample="https://api.punkapi.com/v2/beers?brewed_before=11-2012&abv_gt=6"

        val reQueue: RequestQueue = Volley.newRequestQueue(this)
        val request = JsonArrayRequest(Request.Method.GET, apiSample, null, { res ->
            Log.d("Volley sample", res.toString())
            recycler?.setOnClickListener {
                val intent = Intent(this, CardFragment::class.java)
                intent.putExtra("user_list", userList)
                startActivity(intent)
            }
            val jsonArray = res.getJSONObject(0)
            Log.d("Volley sample",jsonArray.toString())
            for (i in 0 until jsonArray.length()) {
                println(i)
//                val jsonobj = jsonArray.getJSONObject("name")//i
//                Log.d("Volley Sample", jsonobj.toString())

                val user = User(
                    jsonArray.getInt("id"),
                    jsonArray.getString("name"),
                    jsonArray.getString("tagline"),
                    jsonArray.getString("first_brewed"),
                    jsonArray.getString("description"),
                    jsonArray.getString("image_url"),
                    jsonArray.getInt("abv"),
                    jsonArray.getInt("ibu"),
                    jsonArray.getInt("target_fg"),
                    jsonArray.getInt("target_og"),
                    jsonArray.getInt("ebc"),
                    jsonArray.getInt("srm"),
                    jsonArray.getInt("ph"),
                    jsonArray.getInt("attenuation_level"),
                )
                userList.add(user)
                Log.d("Volley sample", userList.toString())
            }
            recycler?.layoutManager = LinearLayoutManager(this)
            recycler?.adapter = UserAdapter(userList,)

        }, { err ->
            Log.d("Fail", err.message.toString())
        })
//        val request = StringRequest(Request.Method.GET,apiSample, { result ->
//            Log.d("Volley example", result.toString())
//        },{err ->
//            Log.d("volley Example",err.message.toString())
//        })
        reQueue.add(request)
    }

    @SuppressLint("SuspiciousIndentation")
     fun onItemClick(item: User, position: Int) {
        Toast.makeText(this,item.id , Toast.LENGTH_SHORT).show()
        val intent= Intent(this@BeersActivity,CardFragment::class.java)
        intent.putExtra("CARNAME",item.id)
        intent.putExtra("CARDESCRIPTION",item.name)
        intent.putExtra("CARLOGO",item.tagline)
        intent.putExtra("jk",item.image_url)
        startActivity(intent)

    }
}
