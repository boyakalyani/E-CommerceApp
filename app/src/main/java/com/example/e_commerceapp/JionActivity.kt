package com.example.e_commerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class JionActivity : AppCompatActivity() {
    lateinit var join:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jion)
        var login=findViewById<Button>(R.id.main_login_btn)
        join=findViewById(R.id.main_join_btn)
        join.setOnClickListener(){
            startActivity(Intent(this,RegisterOrSigninActivity::class.java))
        }
        login.setOnClickListener(){
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}