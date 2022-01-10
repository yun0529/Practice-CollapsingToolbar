package com.example.testpractice1.src.login.mypage.model

import com.google.gson.annotations.SerializedName

data class Hourly(
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("dew_point") val dew_point: Double,
    @SerializedName("dt") val dt: Int,
    @SerializedName("feels_like") val feels_like: Double,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("pop") val pop: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("temp") val temp: Double,
    @SerializedName("uvi") val uvi: Double,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("weather") val weather: List<WeatherXX>,
    @SerializedName("wind_deg") val wind_deg: Int,
    @SerializedName("wind_gust") val wind_gust: Double,
    @SerializedName("wind_speed") val wind_speed: Double
)