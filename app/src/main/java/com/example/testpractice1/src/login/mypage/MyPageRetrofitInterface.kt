package com.example.testpractice1.src.login.mypage

import com.example.testpractice1.src.login.mypage.model.WeatherResponse
import com.example.testpractice1.src.login.mypage.models.TestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyPageRetrofitInterface {
    @GET("onecall")
    fun getWeather(@Query("lat") lat : Double,
                   @Query("lon") lon : Double,
                   @Query("exclude") exclude : String,
                   @Query("appid") appid : String
    ) : Call<WeatherResponse>
}