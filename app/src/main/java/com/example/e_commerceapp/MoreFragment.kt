package com.example.e_commerceapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.findFragment


class MoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var k= inflater.inflate(R.layout.fragment_more, container, false)
        var candy=k.findViewById<TextView>(R.id.faq_id)
        var returnHome=k.findViewById<TextView>(R.id.txtreturn)
        var order=k.findViewById<TextView>(R.id.txtyour_order)

        returnHome.setOnClickListener(){
            startActivity(Intent(this.requireContext(),HomeFragment::class.java))
        }
        order.setOnClickListener(){
            startActivity(Intent(this.requireContext(),BeersActivity::class.java))
        }

        candy.setOnClickListener() {
            var intent=Intent(requireContext(),FaqActivity::class.java)
            startActivity(intent)
        }

        var jaji=k.findViewById<TextView>(R.id.orderSus_id)
        jaji.setOnClickListener() {
            var intent=Intent(requireContext(),OrderSuccessActivity::class.java)
            startActivity(intent)
        }
            return k
    }

}