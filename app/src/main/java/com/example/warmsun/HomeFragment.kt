package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // 科普
        binding.textView21.setOnClickListener {
            startFragment(FragmentType.KNOWLEDGE)
        }
        // 日
        binding.textView31.setOnClickListener {
            startFragment(FragmentType.GRAPH)
        }
        // 周
        binding.textView32.setOnClickListener {
            startFragment(FragmentType.GRAPH)
        }
        // 月
        binding.textView33.setOnClickListener {
            startFragment(FragmentType.GRAPH)
        }
        return binding.root
    }
}