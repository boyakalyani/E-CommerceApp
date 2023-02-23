
package com.example.e_commerceapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage


class JionActivity : AppCompatActivity() {
    lateinit var join: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jion)


        val login = findViewById<Button>(R.id.main_login_btn)
        join = findViewById(R.id.main_join_btn)

        join.setOnClickListener() {
            startActivity(Intent(this, RegisterOrSigninActivity::class.java))
        }
        login.setOnClickListener() {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
























//
//import android.content.Intent
//import android.graphics.Color
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import androidx.fragment.app.FragmentManager
//import com.ramotion.paperonboarding.PaperOnboardingFragment
//import com.ramotion.paperonboarding.PaperOnboardingPage
//
//class JionActivity : AppCompatActivity() {
//    private var fragmentManager: FragmentManager? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_jion)
//        var login = findViewById<Button>(R.id.main_login_btn)
//        join = findViewById(R.id.main_join_btn)
//
//        fragmentManager = supportFragmentManager
//
//
//        //
//        val paperOnboardingFragment = PaperOnboardingFragment.newInstance(
//            dataforOnboarding
//        )
//        val fragmentTransaction = fragmentManager!!.beginTransaction()
//
//        fragmentTransaction.add(android.R.id.frame_id, paperOnboardingFragment)
//
//        fragmentTransaction.commit()
//
//    }
//    private val dataforOnboarding: ArrayList<PaperOnboardingPage>
//    replaceFragmentclass(HomeFragment())
//    private get()
//    {
//        val source = PaperOnboardingPage(
//            "Gfg",
//            "Welcome to GeeksForGeeks",
//            Color.parseColor("#ffb174"),
//            android.R.drawable.gfgimg,
//            android.R.drawable.search
//        )
//        val source1 = PaperOnboardingPage(
//            "Practice",
//            "Practice questions from all topics",
//            Color.parseColor("#22eaaa"),
//            android.R.drawable.practice_gfg,
//            android.R.drawable.training
//        )
//        val source2 = PaperOnboardingPage(
//            "",
//            " ",
//            Color.parseColor("#ee5a5a"),
//            android.R.drawable.,
//            android.R.drawable.contribution
//        )
//
//        // array list is used to store
//        // data of onbaording screen
//        val elements = ArrayList<PaperOnboardingPage>()
//
//        // all the sources(data to show on screens)
//        // are added to array list
//        elements.add(source)
//        elements.add(source1)
//        elements.add(source2)
//        return elements
//    }
//
//}