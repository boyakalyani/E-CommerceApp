package com.example.e_commerceapp

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat


@SuppressLint("CheckResult")
class RegisterOrSigninActivity : AppCompatActivity() {
    private lateinit var fullName: EditText
    private lateinit var emailEt: EditText
    private lateinit var passEt: EditText
    private lateinit var CpassEt: EditText

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_or_signin)
//        this.textAutoCheck()
        val signUpBtn = findViewById<Button>(R.id.signUpBtn_signUpPage)
        var fullName = findViewById<EditText>(R.id.nameEt_signUpPage)
        emailEt = findViewById(R.id.emailEt_signUpPage)
        passEt = findViewById(R.id.PassEt_signUpPage)
        CpassEt = findViewById(R.id.cPassEt_signUpPage)
        val signInTv = findViewById<TextView>(R.id.signInTv_signUpPage)

//        val saveData=getSharedPreferences("loginEmail", MODE_PRIVATE)

        val Data=getSharedPreferences("studentData", MODE_PRIVATE)

        signUpBtn.setOnClickListener(){
            val UserName=emailEt.text.toString()
            Data.edit().putString("Name",UserName).apply()
            val passWord=passEt.text.toString()
            Data.edit().putString("pass",passWord).apply()
        }

        signUpBtn.setOnClickListener() {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        signInTv.setOnClickListener() {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
//
//    private fun textAutoCheck() {
//
//    fullName.addTextChangedListener(object : TextWatcher {
//
//        override fun afterTextChanged(s: Editable) {
//            if (fullName.text.isEmpty()) {
//                fullName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//
//            } else if (fullName.text.length >= 4) {
//                fullName.setCompoundDrawablesWithIntrinsicBounds(
//                    null, null, ContextCompat.getDrawable(
//                        applicationContext,
//                        R.drawable.ic_check
//                    ), null
//                )
//            }
//        }
//
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//
//            fullName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//        }
//
//        override fun onTextChanged(
//            s: CharSequence, start: Int,
//            before: Int, count: Int
//        ) {
//            if (count >= 4) {
//                fullName.setCompoundDrawablesWithIntrinsicBounds(
//                    null, null, ContextCompat.getDrawable(
//                        applicationContext,
//                        R.drawable.ic_check
//                    ), null
//                )
//            }
//        }
//    })
//
//        emailEt.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {
//                if (emailEt.text.isEmpty()){
//                    emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//
//                }
//                else if (emailEt.text.matches(emailPattern.toRegex())) {
//                    emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//
//                emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//                if (emailEt.text.matches(emailPattern.toRegex())) {
//                    emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//        })
//
//        passEt.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {
//                if (passEt.text.isEmpty()){
//                    passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//
//                }
//                else if (passEt.text.length > 5){
//                    passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//
//                passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//                if (count > 5){
//                    passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//        })
//
//        CpassEt.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {
//                if (CpassEt.text.isEmpty()){
//                    CpassEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//
//                }
//                else if (CpassEt.text.toString() == passEt.text.toString()){
//                    CpassEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//
//                CpassEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//                if (CpassEt.text.toString() == passEt.text.toString()){
//                    CpassEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//        })
//
//    }
//
//    private fun checkInput() {
//        var fullName = findViewById<EditText>(R.id.nameEt_signUpPage)
//        if (fullName.text.isEmpty()) {
//            Toast.makeText(this, "Name can't empty!", Toast.LENGTH_SHORT).show()
//            return
//        }
//        if (emailEt.text.isEmpty()) {
////            toast("Email can't empty!")
//            Toast.makeText(this, "Email can't empty!", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        if (!emailEt.text.matches(emailPattern.toRegex())) {
////            toast("Enter Valid Email")
//            Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show()
//            return
//        }
//        if (passEt.text.isEmpty()) {
////            toast("Password can't empty!")
//            Toast.makeText(this, "Password can't empty!", Toast.LENGTH_SHORT).show()
//            return
//        }
//        if (passEt.text.toString() != CpassEt.text.toString()) {
//            Toast.makeText(this, "Password not Match", Toast.LENGTH_SHORT).show()
//            return
//        }
//    }
}
