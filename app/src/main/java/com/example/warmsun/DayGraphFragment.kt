package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentDayGraphBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import java.util.Random

class DayGraphFragment : Fragment() {
    private lateinit var binding: FragmentDayGraphBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDayGraphBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        binding.barChart.run {
            // 12个小时
            val times = mutableListOf<String>()
            for (i in 0..24 step 2) {
                times += "${i}点"
            }
            val emotions = listOf("0", "1", "2")
            val bars = mutableListOf<BarEntry>()
            for (i in times.indices) {
                bars += BarEntry(i.toFloat(), (Random().nextInt(3)).toFloat())
            }
            data = BarData(BarDataSet(bars, "情绪波动与否，1是情绪正常，2是情绪异常"))
            // 右下角文字消失
            description = null
            // 禁止所有点击,默认true
            setTouchEnabled(false)
            // 底部显示
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    return times[value.toInt()]
                }
            }

//            axisLeft.valueFormatter = object : ValueFormatter() {
//                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
//                    return emotions[value.toInt()]
//                }
//            }
            axisLeft.setLabelCount(3, true)
            // 隐藏线条
            xAxis.setDrawGridLines(false)
            axisRight.setDrawLabels(false)
            animateY(1000)
        }
    }
}