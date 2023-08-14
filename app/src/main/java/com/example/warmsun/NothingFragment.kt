package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentNothingBinding

class NothingFragment(private val title: String = "空页面") : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentNothingBinding.inflate(inflater, container, false)
        binding.textView2.text = title


        return binding.root
    }
}