package com.example.testpractice1.src.login.mypage

import com.example.testpractice1.src.login.mypage.model.WeatherResponse

interface MyPageFragmentInterface {
    fun onGetWeatherSuccess(response : WeatherResponse)

    fun onGetWeatherFailure(message: String)
}