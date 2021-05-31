package com.upschool.team4project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.upschool.team4project.R
import com.upschool.team4project.databinding.FragmentProfilePageBinding

class ProfilePageFragment : Fragment() {

    private lateinit var design: FragmentProfilePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design=DataBindingUtil.inflate(inflater, R.layout.fragment_profile_page, container, false)

        //snack bar
        //Snackbar.make(it,"Kampanya kodu kaydedildi.",Snackbar.LENGTH_LONG).show()
        return design.root
    }
}