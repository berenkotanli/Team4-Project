package com.upschool.team4project.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upschool.team4project.entity.Yemekler
import com.upschool.team4project.repo.YemeklerdaoRepository

class HomePageFragmentViewModel: ViewModel() {

    var yemeklerListesi=MutableLiveData<List<Yemekler>>()

    var ydaor= YemeklerdaoRepository()


    init{
        yemeklerYukle()
        yemeklerListesi=ydaor.yemekleriGetir()
    }

     fun yemeklerYukle() {
         ydaor.tumYemekleriAl()
    }

}