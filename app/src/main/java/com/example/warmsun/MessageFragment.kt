
package com.example.warmsun

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
private lateinit var binding: FragmentMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        binding.constraintLayout2.setOnClickListener {
            replaceFragment(NothingFragment("通知公告"))
        }
        binding.constraintLayout4.setOnClickListener {
            replaceFragment(NothingFragment("系统通知"))
        }
        binding.constraintLayout5.setOnClickListener {
            replaceFragment(WarningDetailFragment())
        }
        // 返回
        binding.imageView2.setOnClickListener {


            requireActivity().onBackPressed()
        }
        return binding.root
    }
}