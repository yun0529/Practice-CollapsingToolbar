package com.example.testpractice1.src.login

import android.os.Bundle
import android.os.PersistableBundle
import com.example.testpractice1.R
import com.example.testpractice1.config.BaseActivity
import com.example.testpractice1.databinding.ActivityLoginBinding
import com.example.testpractice1.src.login.home.LoginFragment
import com.example.testpractice1.src.login.mypage.MyPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, LoginFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_login_btm_navi_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, LoginFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_login_btm_nav_my_page -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyPageFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            })
    }
}