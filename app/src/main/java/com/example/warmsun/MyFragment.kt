package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    private lateinit var binding: FragmentMyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyBinding.inflate(inflater, container, false)


        binding.constraintLayout10.setOnClickListener {
            startFragment(FragmentType.PERSONAL_INFORMATION)
        }
        binding.constraintLayout8.setOnClickListener {
            startFragment(FragmentType.CONSULT)
        }
        return binding.root
    }

}