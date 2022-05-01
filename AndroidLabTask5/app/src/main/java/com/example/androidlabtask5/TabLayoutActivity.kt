package com.example.androidlabtask5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlabtask5.LayoutAdapter
import com.example.androidlabtask5.databinding.TabLayoutActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

val tabNamesArray = arrayOf(
    "First",
    "Second",
    "Third"
)

class TabLayoutActivity : AppCompatActivity() {

    lateinit var binding: TabLayoutActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TabLayoutActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = LayoutAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNamesArray[position]
        }.attach()
    }
}