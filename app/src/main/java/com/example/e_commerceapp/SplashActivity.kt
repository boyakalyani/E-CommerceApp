package com.example.e_commerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
var splash=findViewById<ConstraintLayout>(R.id.splash_id)
            splash.alpha=1f
            splash.animate().setDuration(3000).alpha(0f).withEndAction(){
                startActivity(Intent(this,JionActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            }
    }
}