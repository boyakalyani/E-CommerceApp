package com.example.e_commerceapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage

class OnBoardibng : AppCompatActivity() {
    private var fragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boardibng)

        val btn=findViewById<Button>(R.id.btnImg_id)
        btn.setOnClickListener(){
            startActivity(Intent(this,RegisterOrSigninActivity::class.java))
        }

        fragmentManager = supportFragmentManager

        val paperOnboardingFragment = PaperOnboardingFragment.newInstance(
            dataforOnboarding
        )
        val fragmentTransaction = fragmentManager!!.beginTransaction()

        fragmentTransaction.add(R.id.frame_layout, paperOnboardingFragment)

        fragmentTransaction.commit()
    }

    private val dataforOnboarding: ArrayList<PaperOnboardingPage>
        private get() {

            val source = PaperOnboardingPage(
                "",
                "",
                Color.parseColor("#ee5a5a"),
                R.drawable.homeimage,
                R.drawable.ic_baseline_home_24
            )
            val source1 = PaperOnboardingPage(
                "",
                "",
                Color.parseColor("#22eaaa"),
                R.drawable.card_image,
                R.drawable.ic_baseline_shopping_cart_24
            )
            val source2 = PaperOnboardingPage(
                "",
                " ",
                Color.parseColor("#ee5a5a"),
                R.drawable.succuss_image,
                R.drawable.ic_baseline_add_reaction_24
            )

            val elements = ArrayList<PaperOnboardingPage>()
            elements.add(source)
            elements.add(source1)
            elements.add(source2)
            return elements
    }
}