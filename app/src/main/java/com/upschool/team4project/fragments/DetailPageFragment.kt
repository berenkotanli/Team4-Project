package com.upschool.team4project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso

import com.upschool.team4project.R
import com.upschool.team4project.databinding.FragmentDetailPageBinding


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

        //Picasso part
        var image_name=b.nesne.yemek_resim_adi
        var url="http://kasimadalan.pe.hu/yemekler/resimler/"+image_name
        var id = design.imageView2
        Picasso.get().load(url).into(id)
        return design.root
    }


}