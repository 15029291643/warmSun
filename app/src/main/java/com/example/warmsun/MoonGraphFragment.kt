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
            val minY = 0
            val maxY = 84
            val bars1 = mutableListOf<BarEntry>()
            val bars2 = mutableListOf<BarEntry>()
            repeat(4) {
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
            xAxis.labelCount = 4
            val xList = listOf("第一周", "第二周", "第三周", "第四周")
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
            axisLeft.labelCount = 9
            axisLeft.axisMinimum = 0f
            axisLeft.axisMaximum = 90f
            // 右Y轴设置
            axisRight.setDrawLabels(false)
            axisRight.setDrawGridLines(false)
            // 动画
            animateY(1000)
            invalidate()
        }
    }
}

