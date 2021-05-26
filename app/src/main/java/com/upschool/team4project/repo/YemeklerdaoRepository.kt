package com.upschool.team4project.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.upschool.team4project.entity.Yemekler
import com.upschool.team4project.entity.YemeklerCevap
import com.upschool.team4project.retrofit.ApiUtils
import com.upschool.team4project.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerdaoRepository {

    private val yemeklerListesi:MutableLiveData<List<Yemekler>>
    private val ydaoi:YemeklerDaoInterface

    init{
        ydaoi=ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi= MutableLiveData()
    }

    fun yemekleriGetir():MutableLiveData<List<Yemekler>>{
        return yemeklerListesi
    }

    fun tumYemekleriAl(){
        ydaoi.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste= response.body().yemekler
                yemeklerListesi.value=liste

            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }



}