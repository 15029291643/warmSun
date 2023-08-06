package com.example.warmsun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.warmsun.databinding.FragmentGraphBinding
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.tabs.TabLayoutMediator


class GraphFragment : Fragment() {

    private lateinit var binding: FragmentGraphBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGraphBinding.inflate(inflater, container, false)

        return binding.root
    }

    // 数据有关
    override fun onResume() {
        super.onResume()
        binding.imageView3.setOnClickListener {
            startFragment(FragmentType.MAIN)
        }

        val textView = TextView(requireContext()).apply {
            text = "nihao"
        }
        binding.viewPager.adapter = GraphAdapter(
            this, listOf(
                DayGraphFragment(),
                WeekGraphFragment(),
                MoonGraphFragment(),
            )
        )
        val tabNames = listOf("日心情", "周心情", "月心情")
        TabLayoutMediator(binding.tabLayout2, binding.viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
}

private class GraphAdapter(fragment: Fragment, private val list: List<Fragment>) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}
