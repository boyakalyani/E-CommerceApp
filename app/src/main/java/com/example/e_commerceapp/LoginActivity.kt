package com.example.e_commerceapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable

@SuppressLint("checkResult")
class LoginActivity : AppCompatActivity() {
    lateinit var signInEmail: String
    lateinit var signInPassword: String
    lateinit var signInBtn: Button
    lateinit var emailEt: EditText
    lateinit var passEt: EditText

    lateinit var loadingDialog: LoadingDialog

    lateinit var emailError: TextView
    lateinit var passwordError: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signUpTv = findViewById<TextView>(R.id.signUpTv)
        signInBtn = findViewById(R.id.loginBtn)
        emailEt = findViewById(R.id.emailEt_id)
        passEt = findViewById(R.id.PassEt)
        emailError = findViewById(R.id.emailError)
        passwordError = findViewById(R.id.passwordError)
        val login = findViewById<Button>(R.id.loginBtn)
        val account = findViewById<TextView>(R.id.signUpTv)

        val fullNameStream= RxTextView.textChanges(emailEt).skipInitialValue().map { fulname ->
            fulname.isEmpty()
        }
        fullNameStream.subscribe{
            showTextMinimAlert(it,"Email/Username")
        }
        val passwordStream= RxTextView.textChanges(passEt).skipInitialValue().map { password ->
            password.isEmpty()
        }
        val inaValidFiealdsStream= Observable.combineLatest(
            fullNameStream,
            passwordStream,
            {fullnameInvalid:Boolean, passwordInvalid:Boolean->
                !fullnameInvalid && !passwordInvalid
            })
        inaValidFiealdsStream.subscribe { isValid ->
            if (isValid) {
                login.isEnabled = true
                login.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.black)
            } else {
                login.isEnabled = false
                login.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.purple_700)
            }
        }


        login.setOnClickListener() {
                startActivity(Intent(this,MainActivity::class.java))
        }
        account.setOnClickListener(){
            startActivity(Intent(this,RegisterOrSigninActivity::class.java))
        }
    }
    private fun showTextMinimAlert(isNotValid: Boolean,text:String){
        if(text == "Email/Username")
            emailEt.error=if (isNotValid) "$text tidak boleh kosong!" else null
        else if (text=="Password")
            passEt.error=if(isNotValid) "$text tidak boleh kosong!" else null
    }
}

//        textAutoCheck()
//
//        loadingDialog = LoadingDialog(this)
//
//        signUpTv.setOnClickListener {
//            intent = Intent(this, RegisterOrSigninActivity::class.java)
//            startActivity(intent)
//        }
//
//        signInBtn.setOnClickListener {
//            checkInput()
//
//
//        }
//
//
//    }
//
//    private fun textAutoCheck() {
//
//
//
//        emailEt.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {
//                if (emailEt.text.isEmpty()){
//                    emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//
//                }
//                else if (Patterns.EMAIL_ADDRESS.matcher(emailEt.text).matches()) {
//                    emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                    emailError.visibility = View.GONE
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
//                if (Patterns.EMAIL_ADDRESS.matcher(emailEt.text).matches()) {
//                    emailEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                    emailError.visibility = View.GONE
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
//                else if (passEt.text.length > 4){
//                    passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//
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
//                passwordError.visibility = View.GONE
//                if (count > 4){
//                    passEt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//
//                }
//            }
//        })
//
//
//
//    }
//
//    private fun checkInput() {
//
//        if (emailEt.text.isEmpty()){
//            emailError.visibility = View.VISIBLE
//            emailError.text = "Email Can't be Empty"
//            return
//        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(emailEt.text).matches()) {
//            emailError.visibility = View.VISIBLE
//            emailError.text = "Enter Valid Email"
//            return
//        }
//        if(passEt.text.isEmpty()){
//            passwordError.visibility = View.VISIBLE
//            passwordError.text = "Password Can't be Empty"
//            return
//        }
//
//        if ( passEt.text.isNotEmpty() && emailEt.text.isNotEmpty()){
//            emailError.visibility = View.GONE
//            passwordError.visibility = View.GONE
//            signInUser()
//        }
//    }
//
//    private fun signInUser() {
////
////        loadingDialog.startLoadingDialog()
////        signInEmail = emailEt.text.toString().trim()
////        signInPassword = passEt.text.toString().trim()
////        firebaseAuth.signInWithEmailAndPassword(signInEmail, signInPassword)
////            .addOnCompleteListener { signIn ->
////                if (signIn.isSuccessful) {
////
////                    loadingDialog.dismissDialog()
////                    startActivity(Intent(this, HomeActivity::class.java))
////                    toast("signed in successfully")
////                    finish()
////
////                    /*
////                    if(FirebaseUtils.firebaseUser?.isEmailVerified == true){
////                        startActivity(Intent(this, HomeActivity::class.java))
////                        loadingDialog.dismissDialog()
////                        toast("signed in successfully")
////                        finish()
////                    }
////                    else {
////                        loadingDialog.dismissDialog()
////                        val intent = Intent(this, EmailVerifyActivity::class.java)
////                        intent.putExtra("EmailAddress", emailEt.text.toString().trim())
////                        intent.putExtra("loginPassword", passEt.text.toString().trim())
////                        startActivity(intent)
////                    }
////
////                    */
////
////                } else {
////                    toast("sign in failed")
////                    loadingDialog.dismissDialog()
////                }
////            }
////    }
//
//
//
//}
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_login)
////        var btn=findViewById<Button>(R.id.btn_id)
////        btn.setOnClickListener(){
////            startActivity(Intent(this,RegisterOrSigninActivity::class.java))
////        }
////    }
//}