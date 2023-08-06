package com.example.warmsun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.warmsun.databinding.FragmentMoonBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import java.util.Random


class MoonGraphFragment : Fragment() {
    private lateinit var binding: FragmentMoonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoonBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onResume() {
        super.onResume()

        binding.barChart.run {
            val xAxisList = listOf("第一周", "第二周", "第三周", "第四周")
            val emos = mutableListOf<BarEntry>()
            val emos2 = mutableListOf<BarEntry>()
            for (i in xAxisList.indices) {
                val num = Random().nextInt(73)
                emos += BarEntry(i.toFloat(), num.toFloat())
                emos2 += BarEntry(i.toFloat(), (72 - num).toFloat())
            }
            val set = BarDataSet(emos, "正常")
            set.color = R.color.bar1
            val set2 = BarDataSet(emos2, "异常")
            set2.color = R.color.bar2
            // 数据
            data = BarData(
                listOf(
                    set,
                    set2
                )
            )

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
            xAxis.setDrawGridLines(false)
            axisLeft.setDrawGridLines(false)
            axisRight.setDrawLabels(false)
            animateY(1000)
        }
    }
}

