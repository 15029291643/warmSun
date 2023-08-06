package com.example.warmsun

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.warmsun.databinding.ActivityMainBinding


enum class FragmentType {
    MAIN,
    KNOWLEDGE,
    KNOWLEDGE_CONTENT,
    PERSONAL_INFORMATION,
    CONSULT,
    WARNING_DETAIL,
    GRAPH,
}

class MainActivity : AppCompatActivity() {

    private val fragmentMap = mutableMapOf<String, Fragment>()

    // 第一次返回时间
    private var exitTime: Long = 0

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 状态栏透明
        transparentStatusBar(window)
        startFragment(FragmentType.MAIN)
    }

    fun transparentStatusBar(window: Window) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        var systemUiVisibility = window.decorView.systemUiVisibility
        systemUiVisibility =
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.decorView.systemUiVisibility = systemUiVisibility
        window.statusBarColor = Color.TRANSPARENT

        //设置状态栏文字颜色
        setStatusBarTextColor(window)
    }

    fun setStatusBarTextColor(window: Window, light: Boolean = true) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var systemUiVisibility = window.decorView.systemUiVisibility
            systemUiVisibility = if (light) { //白色文字
                systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else { //黑色文字
                systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            window.decorView.systemUiVisibility = systemUiVisibility
        }
    }


    fun startFragment(type: FragmentType) {
        val transaction = supportFragmentManager.beginTransaction()
        // 隐藏所有
        fragmentMap.forEach { (name, fragment) ->
            transaction.hide(fragment)
        }
        // 没有，添加到map中，通过add展示
        if (type.name !in fragmentMap) {
            fragmentMap[type.name] = when (type) {
                FragmentType.MAIN -> MainFragment()
                FragmentType.KNOWLEDGE -> KnowledgeFragment()
                FragmentType.KNOWLEDGE_CONTENT -> KnowledgeContentFragment()
                FragmentType.PERSONAL_INFORMATION -> PersonalInformationFragment()
                FragmentType.CONSULT -> ConsultFragment()
                FragmentType.WARNING_DETAIL -> WarningDetailFragment()
                FragmentType.GRAPH -> GraphFragment()
            }
            transaction.add(binding.frameLayout.id, fragmentMap[type.name]!!)
        } else {
            // 有显示，show展示
            transaction.show(fragmentMap[type.name]!!)
            // 手动调用生命周期
            fragmentMap[type.name]!!.onResume()
        }
        transaction.commit()
    }


    // 两秒内，连续两次返回才能退出
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show()
                exitTime = System.currentTimeMillis()
                return true
            } else {
                finish()
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}

// 扩展fragment跳转
fun Fragment.startFragment(type: FragmentType) {
    (requireActivity() as MainActivity).startFragment(type)
}