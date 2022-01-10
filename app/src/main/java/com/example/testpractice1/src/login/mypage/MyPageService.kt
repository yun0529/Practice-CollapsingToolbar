package com.example.testpractice1.src.login.mypage

import com.example.testpractice1.config.ApplicationClass
import com.example.testpractice1.src.login.mypage.model.WeatherResponse
import com.example.testpractice1.src.login.mypage.models.TestResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val myPageFragmentInterface: MyPageFragmentInterface) {

    fun tryGetWeather(lat : Double, lon : Double, exclude : String, key : String){
        val myPageRetrofitInterface = ApplicationClass.wRetrofit.create(MyPageRetrofitInterface::class.java)
        myPageRetrofitInterface.getWeather(lat,lon,exclude,key).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                myPageFragmentInterface.onGetWeatherSuccess(response.body() as WeatherResponse)
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                myPageFragmentInterface.onGetWeatherFailure(t.message ?: "통신 오류")
            }
        })
    }
}