package com.upschool.team4project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.upschool.team4project.R
import com.upschool.team4project.databinding.FragmentCartPageBinding
import kotlinx.android.synthetic.main.fragment_cart_page.view.*

class CartPageFragment : Fragment() {

    private lateinit var design: FragmentCartPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_cart_page, container, false)

        val b:  CartPageFragmentArgs by navArgs()
        if(b.isimNesne=="yemek" || b.fiyatNesne=="yemek"){
            design.textViewFiyatSepet.text= "Sepetinizde ürün bulunmamaktadır."
            design.textViewUrunSepet.text=""
            design.textView10.text=""
            design.textView8.text=""
        }
        else{
            design.textViewFiyatSepet.text=b.isimNesne
            design.textViewUrunSepet.text=b.fiyatNesne
        }

        return design.root
    }
}