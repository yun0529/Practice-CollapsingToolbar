package com.example.testpractice1.src.login.mypage.model

import com.google.gson.annotations.SerializedName

data class FeelsLike(
    @SerializedName("day") val day: Double,
    @SerializedName("eve") val eve: Double,
    @SerializedName("morn") val morn: Double,
    @SerializedName("night") val night: Double
)