package com.example.testpractice1.src.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.testpractice1.R
import com.example.testpractice1.config.BaseActivity
import com.example.testpractice1.databinding.ActivityMainBinding
import com.example.testpractice1.src.collaps.CollapsActivity
import com.example.testpractice1.src.login.LoginActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, CollapsActivity::class.java))
            finish()
        }, 1500)
    }
}