package com.example.warmsun

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.warmsun.databinding.AdapterKnowledgeBinding
import com.example.warmsun.databinding.FragmentKnowledgeBinding

class KnowledgeFragment : Fragment() {
    private lateinit var binding: FragmentKnowledgeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKnowledgeBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val list = listOf(
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
            "不知到些什么1",
        )
        binding.recyclerView.adapter = KnowledgeAdapter(requireActivity(), list)
        return binding.root
    }


}

class KnowledgeAdapter(private val activity: Activity, private val list: List<String>) :
    RecyclerView.Adapter<KnowledgeAdapter.ViewHolder>() {
    class ViewHolder(binding: AdapterKnowledgeBinding) : RecyclerView.ViewHolder(binding.root) {
        val text = binding.textView20
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterKnowledgeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = list[position]
        holder.itemView.setOnClickListener {
            (activity as MainActivity).startFragment(FragmentType.KNOWLEDGE_CONTENT)
        }
    }
}