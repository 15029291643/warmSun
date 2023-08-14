package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentMyBinding

class MyFragment : Fragment(),OnClickListener {

    private lateinit var binding: FragmentMyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyBinding.inflate(inflater, container, false)


        binding.constraintLayout10.setOnClickListener(this)
        binding.constraintLayout8.setOnClickListener(this)
        binding.constraintLayout9.setOnClickListener(this)
        binding.constraintLayout11.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(p0: View?) {
        p0?.run {
            when (id) {
                // 图像
                R.id.constraintLayout10 -> {
                    replaceFragment(PersonalInformationFragment())
                }
                // 消息中心
                R.id.constraintLayout8 -> {
                    replaceFragment(MessageFragment())
                }
                // 帮助反馈
                R.id.constraintLayout9 -> {
                    replaceFragment(HelpDetailFragment())
                }
                // 常用设置
                R.id.constraintLayout11 -> {
                    replaceFragment(NothingFragment("常用设置"))
                }
            }
        }
    }

}