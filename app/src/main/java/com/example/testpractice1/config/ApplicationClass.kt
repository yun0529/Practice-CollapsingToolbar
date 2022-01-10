package com.example.testpractice1.config

import android.app.Application
import android.content.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    val API_URL = "https://members.softsquared.com/"

    val WAPI_URL = "https://api.openweathermap.org/data/2.5/"
    // 테스트 서버 주소
    // val API_URL = "http://dev-api.test.com/"

    // 실 서버 주소
    // val API_URL = "http://api.test.com/"

    companion object{
        // 만들어져있는 SharedPreferences 를 사용
        lateinit var sSharedPreferences: SharedPreferences

        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        val WEATHER_TOKEN = "45f932fd7c76ec5414b5c8ec204ea5cf"

        lateinit var sRetrofit: Retrofit

        lateinit var wRetrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        sSharedPreferences = applicationContext.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        // 레트로핏 인스턴스 생성
        initRetrofitInstance()
    }

private fun initRetrofitInstance() {
    val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
        .build()

    // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
    // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
    sRetrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    wRetrofit = Retrofit.Builder()
        .baseUrl(WAPI_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
}