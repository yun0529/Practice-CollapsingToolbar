package com.example.testpractice1.src.login.home

import com.example.testpractice1.config.ApplicationClass
import com.example.testpractice1.src.login.home.models.PostSignUpRequest
import com.example.testpractice1.src.login.home.models.SignUpResponse
import com.example.testpractice1.src.login.home.models.UserResponse
import com.example.testpractice1.src.login.home.models.UserSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val loginFragmentInterface: LoginFragmentInterface) {

    fun tryGetUsers() {
        val loginRetrofitInterface =
            ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                loginFragmentInterface.onGetUserSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                loginFragmentInterface.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse>{
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                loginFragmentInterface.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                loginFragmentInterface.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetUserSearch(word : String){
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.getUserSearch(word).enqueue(object : Callback<UserSearchResponse>{
            override fun onResponse(
                call: Call<UserSearchResponse>,
                response: Response<UserSearchResponse>
            ) {
                loginFragmentInterface.onGetUserSearchSuccess(response.body() as UserSearchResponse)
            }

            override fun onFailure(call: Call<UserSearchResponse>, t: Throwable) {
                loginFragmentInterface.onGetUserSearchFailure(t.message ?: "통신오류")
            }

        })

    }

}