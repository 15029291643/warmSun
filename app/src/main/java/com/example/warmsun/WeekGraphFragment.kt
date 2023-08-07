package com.example.warmsun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        binding.barChart.run {
            val minY = 0
            val maxY = 12
            val bars1 = mutableListOf<BarEntry>()
            val bars2 = mutableListOf<BarEntry>()
            repeat(7) {
                val num = Random().nextInt(maxY - minY + 1) + minY
                bars1 += BarEntry(it.toFloat(), num.toFloat())
                bars2 += BarEntry(it.toFloat(), (maxY - num).toFloat())
            }
            val set1 = BarDataSet(bars1, "正常")
            val num: Long = 0xFFFFFFFF
            set1.colors = listOf(0x7FB7A9F7)
            val set2 = BarDataSet(bars2, "异常")
            set2.colors = listOf(0x7FB3DBF0)
            // 数据
            data = BarData(
                listOf(
                    set1,
                    set2
                )
            )
            data.barWidth = 0.4f;//设置柱块的宽度
            data.groupBars(-0.5f,0.1f,0.05F);
            // 底部显示
            val xList = listOf("周一", "周二", "周三", "周四", "周五", "周六", "周天")
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    if (value.toInt() in xList.indices) {
                        return xList[value.toInt()]
                    }
                    return super.getAxisLabel(value, axis)
                }
            }
            // 格式设置
            description = null
            setTouchEnabled(false)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            // 左Y轴设置
            axisLeft.labelCount = 7
            axisLeft.axisMinimum = 0f
            axisLeft.axisMaximum = 14f
            // 右Y轴设置
            axisRight.setDrawLabels(false)
            axisRight.setDrawGridLines(false)
            // 动画
            animateY(1000)
            invalidate()
        }
    }
}