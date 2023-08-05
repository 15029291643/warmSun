package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentConsultBinding

class ConsultFragment : Fragment() {
    private lateinit var binding: FragmentConsultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultBinding.inflate(inflater, container,false)
        binding.imageView23.setOnClickListener {
            startFragment(FragmentType.MAIN)
        }
        return binding.root
    }
}