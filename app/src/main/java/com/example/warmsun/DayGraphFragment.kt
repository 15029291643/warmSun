package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentDayGraphBinding

class DayGraphFragment : Fragment() {
    private lateinit var binding: FragmentDayGraphBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDayGraphBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()

    }
}