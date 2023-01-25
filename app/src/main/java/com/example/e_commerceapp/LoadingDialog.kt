package com.example.e_commerceapp


import android.app.Activity
import android.app.AlertDialog

class LoadingDialog(private val activity: Activity) {

    private var dialog: AlertDialog? = null

    fun startLoadingDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.custome_dailuge, null))
        builder.setCancelable(false)
        dialog = builder.create()
        dialog?.show()
    }

    fun dismissDialog() {
        dialog!!.dismiss()
    }
}