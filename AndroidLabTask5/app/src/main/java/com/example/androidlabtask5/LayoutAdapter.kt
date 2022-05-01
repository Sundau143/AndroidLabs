package com.example.androidlabtask5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidlabtask5.FirstTabFragment
import com.example.androidlabtask5.SecondTabFragment
import com.example.androidlabtask5.ThirdTabFragment

private const val NUM_TABS = 3

public class LayoutAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FirstTabFragment()
            1 -> return SecondTabFragment()
        }
        return ThirdTabFragment()
    }
}