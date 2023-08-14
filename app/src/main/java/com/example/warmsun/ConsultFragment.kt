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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultBinding.inflate(inflater, container,false)
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
}

private class ConsultAdapter(list: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class DoctorViewHolder(binding: AdapterConsultResultBinding) : RecyclerView.ViewHolder(binding.root) {
        val text = binding.textView8
    }

    class ConsultViewHolder(binding: AdapterConsultSentBinding) : RecyclerView.ViewHolder(binding.root) {
        val text = binding.textView10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}