package com.upschool.team4project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.upschool.team4project.databinding.FragmentDetailPageBinding
import kotlinx.android.synthetic.main.fragment_detail_page.*
import kotlinx.android.synthetic.main.fragment_detail_page.view.*


class DetailPageFragment : Fragment() {
    private lateinit var design:FragmentDetailPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_page, container, false)
        design.detailPageFragment=this

        val b:DetailPageFragmentArgs by navArgs()

        design.yemekNesne=b.nesne

        //Picasso part
       /* var image_name=b.nesne.yemek_resim_adi
        var url="http://kasimadalan.pe.hu/yemekler/resimler/" +image_name

        Picasso.get().load(url).into(imageView2);*/

        return design.root
    }


}