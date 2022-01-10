package com.example.testpractice1.src.login.home

import com.example.testpractice1.src.login.home.models.PostSignUpRequest
import com.example.testpractice1.src.login.home.models.SignUpResponse
import com.example.testpractice1.src.login.home.models.UserResponse
import com.example.testpractice1.src.login.home.models.UserSearchResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<UserResponse>

    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>

    @GET("/users")
    fun getUserSearch(@Query("word") word : String) : Call<UserSearchResponse>
}