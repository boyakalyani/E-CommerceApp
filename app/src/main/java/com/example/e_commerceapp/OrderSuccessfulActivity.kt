package com.example.e_commerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OrderSuccessActivity : AppCompatActivity() {
    private lateinit var btnOrderOk:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_successful)

        btnOrderOk=findViewById(R.id.btnOrderOk)
        btnOrderOk.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
        finishAffinity()
    }
}
