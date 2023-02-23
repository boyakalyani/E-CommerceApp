package com.example.e_commerceapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.e_commerceapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val spFileName = "foodFlixFile"
//    lateinit var nav_view: NavigationView
//
//    lateinit var drawerLayout: DrawerLayout
//    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mainBinding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(mainBinding.root)

        sharedPreferences = getSharedPreferences(spFileName, MODE_PRIVATE)
//
//        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        val headerView = navigationView.getHeaderView(0)
//        val tvProfileName = headerView.findViewById<TextView>(R.id.tvProfileName)
////        val tvPhone = headerView.findViewById<TextView>(R.id.tvPhone)
//        tvProfileName.text = sharedPreferences.getString("name", "")
//        tvPhone.text = sharedPreferences.getString("phone", "")
//
//        drawerLayout = findViewById(R.id.drawer_layout)
//        val imgMenu = findViewById<ImageView>(R.id.imgView)
//
//        val navView = findViewById<NavigationView>(R.id.navDawar)
        val navigation= findViewById<BottomNavigationView>(R.id.navigationView_id)
//        navView.itemIconTintList = null
//        imgMenu.setOnClickListener {
//            drawerLayout.openDrawer(GravityCompat.START)
//        }
//        val navController = Navigation.findNavController(this,R.id.fragment_id)
//        NavigationUI.setupWithNavController(navView,navController)
//
//        val textTitle = findViewById<TextView>(R.id.title_id_t)
//        navController
//            .addOnDestinationChangedListener { controller, destination, arguments ->
//                textTitle.text = destination.label
//            }

//        navigation.setNavigationItemSelectedListener {
//            it.isChecked=true
//            when(it.itemId){
//                R.id.home_item->replaceFragmentclass(HomeFragment())
//                R.id.profile_item->replaceFragmentclass(MoreFragment())
//                R.id.faq_item->replaceFragmentclass(MoreFragment())
//                R.id.fav_item->replaceFragmentclass(CardFragment())
//                R.id.logout_item->replaceFragmentclass(MoreFragment())
//
//            }
//            true
//        }

        replaceFragmentclass(HomeFragment())

        navigation.setOnItemSelectedListener()
        {
            when (it.itemId) {
                R.id.homeFragment -> replaceFragmentclass(HomeFragment())   //setItembackgroundviewcolor(R.color.)change backgroundnavigation background
                R.id.cardFragment -> replaceFragmentclass(CardFragment())
                R.id.moreFragment -> replaceFragmentclass(MoreFragment())
                else -> {

                }

            }
            true
        }
    }
    private fun replaceFragmentclass(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frme_id, fragment)
        fragmentTransaction.commit()
//        fragmentTransaction.addToBackStack(null)
//        drawerLayout.closeDrawers()
    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }
}

