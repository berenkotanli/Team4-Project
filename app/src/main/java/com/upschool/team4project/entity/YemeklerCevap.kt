package com.upschool.team4project.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class YemeklerCevap(
                        @SerializedName("yemekler")
                        @Expose
                        var yemekler: List<Yemekler>,
                        @SerializedName("success")
                        @Expose
                        var success:Int) {
}