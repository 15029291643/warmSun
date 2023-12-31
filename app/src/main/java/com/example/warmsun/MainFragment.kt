package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.warmsun.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val fragmentList = listOf(
            HomeFragment(),
            ConsultFragment(),
            MyFragment()
        )
        binding.viewPager2.adapter = FragmentAdapter(this, fragmentList)
        val tabNames = listOf("情绪监测", "医生问答", "我的")
        val tabIcons = listOf(
            R.drawable.bottom_home,
            R.drawable.bottom_console,
            R.drawable.bottom_personal
        )
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.setIcon(tabIcons[position])
        }.attach()
        return binding.root
    }
}

// 主页切换
class FragmentAdapter(fragment: Fragment, private val fragmentList: List<Fragment>) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}