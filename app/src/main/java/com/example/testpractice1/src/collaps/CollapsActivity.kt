package com.example.testpractice1.src.collaps

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testpractice1.config.BaseActivity
import com.example.testpractice1.databinding.ActivityCollapsBinding
import com.example.testpractice1.R
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

data class Anything(val title : String, val subtitle : String)
class CollapsActivity : BaseActivity<ActivityCollapsBinding>(ActivityCollapsBinding::inflate) {
    val data = arrayListOf<Anything>()
    lateinit var rvAdapter: AnythingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.collapsTbarTop.title = "Animal"

        binding.collapsCtlMenu.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.d("collaps","리스너에는 들어옴")
            when{
                //처음상태
                verticalOffset == 0 -> {
                    binding.collapsTbarImg.setImageResource(R.drawable.img_animal)
                    Log.d("collaps","그대로")

                }
                //완전히 접혔을 때
                abs(verticalOffset) >= appBarLayout.totalScrollRange -> {
                    binding.collapsTbarTop.title = "Collapsed"
                    binding.collapsTbarImg.setImageResource(R.drawable.img_animal)
                    Log.d("collaps","다접힘")
                    data.add(Anything("다접혔다", "추가된거 확인..."))
                    rvAdapter.notifyDataSetChanged()
                }
                //접히는 중
                else -> {
                    binding.collapsTbarImg.setImageResource(R.drawable.img_animal2)
                    Log.d("collaps","접히는중")
                }
            }
        })

        //binding.collapsTbarTop.setTitleTextColor(Color.WHITE)
        setSupportActionBar(binding.collapsTbarTop)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addData()
        rvAdapter = AnythingAdapter(data)
        binding.collapsRvAnything.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.collapsRvAnything.adapter = rvAdapter




    }

    fun addData(){
        for(i in 0 until 10){
            data.add(Anything("제목이다", "내용이다..."))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_collaps_tbar,menu)
        return super.onCreateOptionsMenu(menu)
    }
}