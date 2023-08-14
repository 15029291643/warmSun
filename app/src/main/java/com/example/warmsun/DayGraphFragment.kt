package com.example.warmsun

import android.graphics.Color
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
            // 数据大小
            val minY = 1
            val maxY = 2
            // 数据设置
            val bars = mutableListOf<BarEntry>()
            repeat(13) {
                val num = Random().nextInt(maxY - minY + 1) + minY
                bars += BarEntry(it.toFloat(), num.toFloat())
            }
            val set = BarDataSet(bars, "情绪波动与否，1是情绪正常，2是情绪异常")
            set.colors = listOf(0x7FB7A9F7)
//             set.colors = listOf(Color.WHITE)
            data = BarData(set)

            // X轴设置
            val xList = mutableListOf<String>()
            for (i in 0..24 step 2) {
                xList += "${i}点"
            }
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    return xList[value.toInt()]
                }
            }
            // 格式设置
            description = null
            setTouchEnabled(false)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            // 左Y轴设置
            axisLeft.labelCount = maxY + 1
            axisLeft.axisMinimum = 0f
            axisLeft.axisMaximum = (maxY + 1).toFloat()
            // 右Y轴设置
            axisRight.setDrawLabels(false)
            axisRight.setDrawGridLines(false)
            // 动画
            animateY(1000)
            invalidate()
        }
    }
}