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
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.Observable.merge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("Ckec")
class RegisterOrSigninActivity : AppCompatActivity() {
    private lateinit var fullName: EditText
    private lateinit var emailEt: EditText
    private lateinit var passEt: EditText
    private lateinit var CpassEt: EditText



//    lateinit var progressDialog: ProgressDialog

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_or_signin)

        val signUpBtn = findViewById<Button>(R.id.signUpBtn_signUpPage)
        fullName = findViewById(R.id.nameEt_signUpPage)
        emailEt = findViewById(R.id.emailEt_signUpPage)
        passEt = findViewById(R.id.PassEt_signUpPage)
        CpassEt = findViewById(R.id.cPassEt_signUpPage)
        val signInTv = findViewById<TextView>(R.id.signInTv_signUpPage)



        //ikkada nundi
        val nameStream=RxTextView.textChanges(fullName).skipInitialValue().map { name ->
            name.isEmpty()
        }
        nameStream.subscribe{
            showNameExistAlert(it)
        }
        val emailStream=RxTextView.textChanges(emailEt).skipInitialValue().map { email ->
            !Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        emailStream.subscribe{
            showEmailVallidAlert(it)
        }
        val fullNameStream=RxTextView.textChanges(fullName).skipInitialValue().map { fulname ->
            fulname.length < 6
        }
        fullNameStream.subscribe{
            showTextMinimAlert(it,"Username")
        }
        val passwordStream=RxTextView.textChanges(passEt).skipInitialValue().map { password ->
            password.length < 6
        }
        passwordStream.subscribe {
            showTextMinimAlert(it, "Password")
        }
        val passwordconfirmStream= Observable.merge(
            RxTextView.textChanges(passEt).skipInitialValue().map { password ->
                password.toString() != CpassEt.text.toString()
            },
            RxTextView.textChanges(CpassEt).skipInitialValue().map { confirmPassword ->
                confirmPassword.toString() != passEt.text.toString()
            })
        passwordconfirmStream.subscribe(){
            showPasswordConfirmaAlert(it)
        }
        val inaValidFiealdsStream=Observable.combineLatest(
            nameStream,
            emailStream,
            fullNameStream,
            passwordStream,
            passwordconfirmStream,
            {nameInvalid:Boolean, emailInvalid:Boolean,usernameInvalid:Boolean,passwordInvalid:Boolean,passwordConfirmInvalid:Boolean ->
                !nameInvalid && !emailInvalid && !usernameInvalid && !passwordInvalid && !passwordConfirmInvalid
            })
        inaValidFiealdsStream.subscribe { isValid ->
            if (isValid) {
                signUpBtn.isEnabled = true
                signUpBtn.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.black)
            } else {
                signUpBtn.isEnabled = false
                signUpBtn.backgroundTintList =
                    ContextCompat.getColorStateList(this, R.color.purple_700)
            }
        }



        signUpBtn.setOnClickListener() {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        signInTv.setOnClickListener() {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    private fun showNameExistAlert(isNotValid:Boolean){
        fullName.error=if (isNotValid) "Name tidak boleh kosong!" else null
    }
    private fun showTextMinimAlert(isNotValid: Boolean,text:String){
        if(text == "Username")
            fullName.error=if (isNotValid) "$text harus labin dari 6 huruf!" else null
        else if (text=="Password")
            passEt.error=if(isNotValid) "$text harus labin dari 8 huruf!" else null
    }
    private fun showEmailVallidAlert(isNotValid: Boolean){
        emailEt.error=if (isNotValid) "Email tidak valid!" else null
    }
    private fun showPasswordConfirmaAlert(isNotValid: Boolean){
        CpassEt.error=if (isNotValid) "Password tidak sama!" else null
    }
}

//        progressDialog = ProgressDialog(this)
//
//        textAutoCheck()
//
//        signInTv.setOnClickListener {
//            intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//
//
//        signUpBtn.setOnClickListener {
//            checkInput()
//
//        }
//        signUpBtn.setOnClickListener(){
//            startActivity(Intent(this,MainActivity::class.java))
//        }
//    }
//
//    private fun textAutoCheck() {
//
//        fullName.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {
//                if (fullName.text.isEmpty()){
//                    fullName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//
//                }
//                else if (fullName.text.length >= 4){
//                    fullName.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//
//                fullName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//                if (count >= 4){
//                    fullName.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(applicationContext,
//                        R.drawable.ic_check
//                    ), null)
//                }
//            }
//        })
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
//        if (fullName.text.isEmpty()){
//            Toast.makeText(this, "Name can't empty!", Toast.LENGTH_SHORT).show()
//            return
//        }
//        if (emailEt.text.isEmpty()){
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
//        if(passEt.text.isEmpty()){
////            toast("Password can't empty!")
//            Toast.makeText(this, "Password can't empty!", Toast.LENGTH_SHORT).show()
//            return
//        }
//        if (passEt.text.toString() != CpassEt.text.toString()){
////            toast("Password not Match")
//            Toast.makeText(this, "Password not Match", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        signIn()
//
//
//    }
//
//
//
//    private fun signIn() {
//
//        progressDialog.setTitle("Please Wait")
//        progressDialog.setMessage("Creating Account")
//        progressDialog.show()
//
//        val emailV: String = emailEt.text.toString()
//        val passV: String = passEt.text.toString()
//        val fullname : String = fullName.text.toString()
//        /*create a user*/
////        firebaseAuth.createUserWithEmailAndPassword(emailV,passV)
////
////            .addOnCompleteListener { task ->
////                if (task.isSuccessful) {
////                    progressDialog.setMessage("Save User Data")
////
////
////                    val user = User(fullname,"",firebaseAuth.uid.toString(),emailV,"","")
////
////                    storeUserData(user)
////
////                    val intent = Intent(this, HomeActivity::class.java)
////                    startActivity(intent)
////                    finish()
////                } else {
////                    progressDialog.dismiss()
////                    toast("failed to Authenticate !")
////                }
//            }
//
//    }

//    private fun storeUserData(user: User) = CoroutineScope(Dispatchers.IO).launch {
//        try {
//
//            userCollectionRef.document(firebaseAuth.uid.toString()).set(user).await()
//            withContext(Dispatchers.Main){
//                toast("Data Saved")
//                progressDialog.dismiss()
//            }
//
//        }catch (e:Exception){
//            withContext(Dispatchers.Main){
//                toast(""+ e.message.toString())
//                progressDialog.dismiss()
//            }
//        }
//    }

//    private fun sendEmailVerification() {
//        progressDialog.setMessage("Send Verification")
//        firebaseUser?.let {
//            it.sendEmailVerification().addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    progressDialog.dismiss()
//                    val intent = Intent(this, EmailVerifyActivity::class.java)
//                    intent.putExtra("EmailAddress", emailEt.text.toString().trim())
//                    intent.putExtra("loginPassword", passEt.text.toString().trim())
//                    startActivity(intent)
//                    finish()
//                }
//            }
//                .addOnFailureListener {
//                    progressDialog.dismiss()
//                    toast("Verification Link Send failed")
//                }
//        }
//    }


//}


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register_or_signin)
//        var btn=findViewById<Button>(R.id.btn1_id)
//        btn.setOnClickListener(){
//            startActivity(Intent(this,JionActivity::class.java))
//        }
//    }
//}