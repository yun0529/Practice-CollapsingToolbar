package com.example.testpractice1.src.login.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.testpractice1.R
import com.example.testpractice1.config.BaseFragment
import com.example.testpractice1.databinding.FragmentLoginBinding
import com.example.testpractice1.src.login.home.models.PostSignUpRequest
import com.example.testpractice1.src.login.home.models.SignUpResponse
import com.example.testpractice1.src.login.home.models.UserResponse
import com.example.testpractice1.src.login.home.models.UserSearchResponse

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::bind, R.layout.fragment_login),
    LoginFragmentInterface{
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeButtonTryGetJwt.setOnClickListener {
            showLoadingDialog(context!!)
            LoginService(this).tryGetUsers()
        }

        binding.homeBtnTryPostHttpMethod.setOnClickListener {
            val email = binding.homeEtId.text.toString()
            val password = binding.homeEtPw.text.toString()
            val postRequest = PostSignUpRequest(email = email, password = password,
                confirmPassword = password, nickname = "test", phoneNumber = "010-0000-0000")
            showLoadingDialog(context!!)
            LoginService(this).tryPostSignUp(postRequest)
        }

        binding.homeBtnTest.setOnClickListener {
            showCustomToast("테스트중")
        }

        binding.homeBtnSearch.setOnClickListener {
            var word = binding.homeEtUserName.text.toString()
            showLoadingDialog(context!!)
            LoginService(this).tryGetUserSearch(word)
        }
    }

    override fun onGetUserSuccess(response: UserResponse) {
        dismissLoadingDialog()
        for (User in response.result) {
            Log.d("HomeFragment", User.toString())
        }
        binding.homeButtonTryGetJwt.text = response.message
        showCustomToast("Get JWT 성공")
    }

    override fun onGetUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        binding.homeBtnTryPostHttpMethod.text = response.message
        response.message?.let { showCustomToast(it) }
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onGetUserSearchSuccess(response: UserSearchResponse) {
        dismissLoadingDialog()
        for(i in response.result){
            showCustomToast(i.email)
        }
    }

    override fun onGetUserSearchFailure(message: String) {
        dismissLoadingDialog()
    }
}