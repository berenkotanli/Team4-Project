package com.upschool.team4project.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.upschool.team4project.MainActivity
import com.upschool.team4project.R
import com.upschool.team4project.databinding.FragmentDetailPageBinding
import kotlinx.android.synthetic.main.fragment_detail_page.*


class DetailPageFragment : Fragment() {
    private lateinit var design:FragmentDetailPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_page, container, false)
        design.detailPageFragment=this

        val b: DetailPageFragmentArgs by navArgs()

        design.yemekNesne=b.nesne

        design.toolbarDetailPage.setNavigationOnClickListener {
            Log.e("iştee", "basıldıı")
            val myIntent = Intent(
                activity, MainActivity::class.java
            )
            startActivity(myIntent)
        }

        //Picasso part
        var image_name=b.nesne.yemek_resim_adi
        var url="http://kasimadalan.pe.hu/yemekler/resimler/"+image_name
        var id = design.imageView2
        Picasso.get().load(url).into(id)

        var isimNesne=b.nesne.yemek_adi
        var fiyatNesne=b.nesne.yemek_fiyat.toString()
        design.buttonEkle.setOnClickListener {
          var gecis= DetailPageFragmentDirections.sepeteGecis(isimNesne as String,fiyatNesne as String)
            Navigation.findNavController(it).navigate(gecis)
        }

        return design.root
    }


}