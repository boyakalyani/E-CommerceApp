package com.example.e_commerceapp

import android.os.Parcelable

data class User(var id: Int, var name: String, var tagline:String, var first_brewed:String,
                var description:String, var image_url:String,var abv:Int, var ibu:Int,var target_fg:Int,
                var target_og:Int, var ebc:Int,var srm:Int,var ph:Int,var attenuation_level:Int )
