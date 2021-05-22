package com.upschool.team4project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.upschool.team4project.entity.YemeklerCevap
import com.upschool.team4project.retrofit.ApiUtils
import com.upschool.team4project.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var ydaoi:YemeklerDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ydaoi = ApiUtils.getYemeklerDaoInterface()
        tumYemekleriGoster()
    }
        fun tumYemekleriGoster(){
            ydaoi.tumYemekler().enqueue(object :Callback<YemeklerCevap>{
                override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                    val yemeklerListesi= response.body().yemekler

                    for(i in yemeklerListesi){
                        Log.e("***************","***************")
                        Log.e("yemek id:", i.yemek_id.toString())
                        Log.e("yemek adı:", i.yemek_adi)
                        Log.e("yemek fiyat :", i.yemek_fiyat.toString())


                    }
                }

                override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
            })
        }


}