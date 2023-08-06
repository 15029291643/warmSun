package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentWarningDetailBinding

class WarningDetailFragment : Fragment() {

    private lateinit var binding: FragmentWarningDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWarningDetailBinding.inflate(inflater, container, false)
        binding.imageView25.setOnClickListener {
            startFragment(FragmentType.MESSAGE)
        }
        return binding.root
    }


}