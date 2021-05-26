package com.upschool.team4project



import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:set_price")
fun setPrice(textView: TextView,price:Int){
    textView.text="$price \u20BA"
}