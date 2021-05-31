package com.upschool.team4project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.upschool.team4project.FoodAdapter
import com.upschool.team4project.R
import com.upschool.team4project.databinding.FragmentHomePageBinding
import com.upschool.team4project.viewModel.HomePageFragmentViewModel


class HomePageFragment : Fragment() {

    private lateinit var design:FragmentHomePageBinding
    //private lateinit var foodList:ArrayList<Food>
    private lateinit var adapter: FoodAdapter
    private lateinit var viewModel: HomePageFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        //design.rvfood.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        design.homePageFragment=this
        //design.rvfood.addItemDecoration(DividerItemDecoration(activity,StaggeredGridLayoutManager.HORIZONTAL))
        //design.rvfood.addItemDecoration(DividerItemDecoration(activity,StaggeredGridLayoutManager.VERTICAL))
        viewModel.yemeklerListesi.observe(viewLifecycleOwner,{ yemeklerListesi ->
            adapter = FoodAdapter(requireContext(),yemeklerListesi)
            design.adapter=adapter

        })
        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temp:HomePageFragmentViewModel by viewModels()
        viewModel=temp
    }

}