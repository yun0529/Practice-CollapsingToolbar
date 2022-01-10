package com.example.testpractice1.src.login.home

import com.example.testpractice1.src.login.home.models.SignUpResponse
import com.example.testpractice1.src.login.home.models.UserResponse
import com.example.testpractice1.src.login.home.models.UserSearchResponse

interface LoginFragmentInterface {
    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)

    fun onGetUserSearchSuccess(response: UserSearchResponse)

    fun onGetUserSearchFailure(message: String)
}