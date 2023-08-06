package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentWeekGraphBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import java.util.Random

class WeekGraphFragment : Fragment() {
    private lateinit var binding: FragmentWeekGraphBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekGraphBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val xAxisList = listOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
        val yAxisList = listOf("雪天", "雪天", "阴天", "多云", "晴天")
        val list = mutableListOf<BarEntry>()
        for (i in xAxisList.indices) {
            list += BarEntry(i.toFloat(), Random().nextInt(yAxisList.size).toFloat())
        }
        binding.barChart.run {
            // 数据
            data = BarData(BarDataSet(list, null))
            // 右下角文字消失
            description = null
            // 禁止所有点击,默认true
            setTouchEnabled(false)

            // 底部显示
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    if (value.toInt() in xAxisList.indices) {
                        return xAxisList[value.toInt()]
                    }
                    return super.getAxisLabel(value, axis)
                }
            }
            axisLeft.valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    if (value.toInt() in yAxisList.indices) {
                        return yAxisList[value.toInt()]
                    }
                    return super.getAxisLabel(value, axis)
                }
            }
            xAxis.setDrawGridLines(false)
            axisLeft.setDrawGridLines(false)
            axisRight.setDrawLabels(false)
            animateY(1000)
        }
    }
}