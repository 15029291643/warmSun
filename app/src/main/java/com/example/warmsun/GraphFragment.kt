package com.example.warmsun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.warmsun.databinding.FragmentGraphBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter


class GraphFragment : Fragment() {

    private lateinit var binding: FragmentGraphBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGraphBinding.inflate(inflater, container, false)

        return binding.root
    }

    // 数据有关
    override fun onResume() {
        super.onResume()
        binding.imageView3.setOnClickListener {
            startFragment(FragmentType.MAIN)
        }
        val xAxisList = listOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
        val yAxisList = listOf("雪天", "雪天", "阴天", "多云", "晴天")
        val list = listOf(
            BarEntry(0F, 2F),
            BarEntry(1F, 4F),
            BarEntry(2F, 1F),
            BarEntry(3F, 5F),
            BarEntry(4F, 3F),
            BarEntry(5F, 2F),
            BarEntry(6F, 5F),
        )
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
            axisRight.setDrawLabels(false)
            animateY(1000)
        }
    }
}