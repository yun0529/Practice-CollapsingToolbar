package com.example.testpractice1.src.login.mypage

import android.os.Bundle
import android.view.View
import com.example.testpractice1.R
import com.example.testpractice1.config.ApplicationClass.Companion.WEATHER_TOKEN
import com.example.testpractice1.config.BaseFragment
import com.example.testpractice1.databinding.FragmentMyPageBinding
import com.example.testpractice1.src.login.mypage.model.WeatherResponse
import com.example.testpractice1.src.login.mypage.models.TestResponse

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page),MyPageFragmentInterface {
    private var mCount = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonChangeCounterText.setOnClickListener {
            binding.textViewCounter.text =
                resources.getString(R.string.my_page_tv_counter, ++mCount)
        }
        MyPageService(this).tryGetWeather(33.4624,126.54039,"minutely",WEATHER_TOKEN)
    }

    override fun onGetWeatherSuccess(response: WeatherResponse) {
        binding.myPageTvTemp.text = response.current.temp.toString()
    }

    override fun onGetWeatherFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}