package com.upschool.team4project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.upschool.team4project.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {

    private lateinit var design:FragmentHomePageBinding
    private lateinit var foodList:ArrayList<Food>
    private lateinit var adapter:FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container, false)
        design.rvfood.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val f1 = Food(1,"Burger","burger", 15)
        val f2 = Food(1,"Burger", "burger",15)
        val f3 = Food(1,"Burger", "burger",15)
        val f4 = Food(1,"Burger", "burger",15)

        foodList = ArrayList()
        foodList.add(f1)
        foodList.add(f2)
        foodList.add(f3)
        foodList.add(f4)

        adapter = FoodAdapter(requireContext(),foodList)
        design.rvfood.adapter = adapter

        return design.root
    }

}