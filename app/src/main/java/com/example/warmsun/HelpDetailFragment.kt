package com.example.warmsun

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentHelpDetailBinding

class HelpDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHelpDetailBinding.inflate(inflater, container, false)
        binding.imageView3.setOnClickListener {


            requireActivity().onBackPressed()        }
        return binding.root
    }
}