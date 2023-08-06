package com.example.warmsun

import android.R.attr
import android.os.Bundle
import android.provider.CalendarContract.Colors
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
            val days = listOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")
            val emos =
                listOf(
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8",
                    "9",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14"
                )
            val bars = mutableListOf<BarEntry>()
            val bars2 = mutableListOf<BarEntry>()
            for (i in days.indices) {
                val num = Random().nextInt(13)
                bars += BarEntry(i.toFloat(), num.toFloat())
                bars2 += BarEntry(i.toFloat(), (12 - num).toFloat())
            }
            val set = BarDataSet(bars, "正常")
            set.color = R.color.bar1
            val set2 = BarDataSet(bars2, "异常")
            set2.color = R.color.bar2
            // 数据
            val barData = BarData(
                listOf(
                    set,
                    set2
                )
            )
            barData.barWidth = 0.3f;//设置柱块的宽度
            barData.groupBars(-0.35f,0.35f,0F);
            data = barData

            // 右下角文字消失
            description = null
            // 禁止所有点击,默认true
            setTouchEnabled(false)

            // 底部显示
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    if (value.toInt() in days.indices) {
                        return days[value.toInt()]
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