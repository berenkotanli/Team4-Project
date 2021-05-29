package com.upschool.team4project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.upschool.team4project.R
import kotlinx.android.synthetic.main.fragment_cart_page.view.*

class CartPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var design = inflater.inflate(R.layout.fragment_cart_page, container, false)

        val b:  CartPageFragmentArgs by navArgs()

        design.textViewFiyatSepet.text=b.isimNesne
        design.textViewUrunSepet.text=b.fiyatNesne
        return design
    }
}