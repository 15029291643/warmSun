package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.warmsun.databinding.AdapterConsultResultBinding
import com.example.warmsun.databinding.AdapterConsultSentBinding
import com.example.warmsun.databinding.FragmentConsultBinding

class ConsultFragment : Fragment() {
    private lateinit var binding: FragmentConsultBinding
    private val adapter = ConsultAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultBinding.inflate(inflater, container,false)
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView2.adapter = adapter
        adapter.list += "你好欢迎使用问医生服务，请问您有什么病？"
        adapter.notifyDataSetChanged()
        binding.button.setOnClickListener {
            if (binding.editTextText.text.isNotBlank()) {
                adapter.list += binding.editTextText.text.toString()
                adapter.notifyDataSetChanged()
                binding.editTextText.setText("")
                Thread {
                    Thread.sleep(2000)
                    requireActivity().runOnUiThread {
                        adapter.list += "稍等，正在转接医生中"
                        adapter.notifyDataSetChanged()
                    }
                }.start()
            }
        }
        return binding.root
    }
}

private class ConsultAdapter(val list: MutableList<String> = mutableListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class DoctorViewHolder(binding: AdapterConsultResultBinding) : RecyclerView.ViewHolder(binding.root) {
        val text = binding.textView8
    }

    class ConsultViewHolder(binding: AdapterConsultSentBinding) : RecyclerView.ViewHolder(binding.root) {
        val text = binding.textView10
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            DoctorViewHolder(
                AdapterConsultResultBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            ConsultViewHolder(
                AdapterConsultSentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            (holder as DoctorViewHolder).text.text = list[position]
        } else {
            (holder as ConsultViewHolder).text.text = list[position]
        }
    }
}