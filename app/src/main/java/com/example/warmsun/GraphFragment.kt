package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentGraphBinding


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

    }
}