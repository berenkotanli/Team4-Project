package com.beren.team4project.retrofit

import com.beren.team4project.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDaoInterface {
    //http://kasimadalan.pe.hu/yemekler/tum_yemekler.php
    @GET("yemekler/tum_yemekler.php")

    fun tumYemekler(): Call<YemeklerCevap>
}