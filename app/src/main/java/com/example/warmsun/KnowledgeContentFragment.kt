package com.example.warmsun

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentKnowledgeContentBinding

class KnowledgeContentFragment : Fragment() {
    private lateinit var binding: FragmentKnowledgeContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKnowledgeContentBinding.inflate(inflater, container, false)
        binding.imageView27.setOnClickListener {
            requireActivity().onKeyDown(KeyEvent.KEYCODE_BACK, null)
        }
        return binding.root
    }
}