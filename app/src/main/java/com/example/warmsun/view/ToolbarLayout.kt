package com.example.warmsun.view

import android.content.Context
import android.opengl.Visibility
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.warmsun.R
import kotlin.math.log

class ToolbarLayout(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    init {
        val inflate = inflate(context, R.layout.view_toolbar, this)
        // 获取控件
        val img = inflate.findViewById<ImageView>(R.id.imageView22)
        val title = inflate.findViewById<TextView>(R.id.textView25)
        // 获取属性
        val array =
            context.obtainStyledAttributes(attrs, R.styleable.ToolbarLayout)
        val showBack = array.getBoolean(R.styleable.ToolbarLayout_show_back, true)
        val titleContent = array.getString(R.styleable.ToolbarLayout_title)
        haoLog(showBack)
        haoLog(titleContent)
        // 改变属性
        img.visibility = if (showBack) VISIBLE else GONE
        title.text = titleContent
    }
}

fun View.haoLog(context: Any?) = Log.e("haojinhui", context.toString())