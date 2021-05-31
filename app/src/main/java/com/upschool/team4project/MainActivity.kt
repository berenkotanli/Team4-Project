package com.upschool.team4project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.upschool.team4project.entity.YemeklerCevap
import com.upschool.team4project.retrofit.ApiUtils
import com.upschool.team4project.retrofit.YemeklerDaoInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var ydaoi:YemeklerDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController)

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
                        Log.e("yemek resim :", i.yemek_resim_adi)

                    }
                }
                override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
            })
        }


}