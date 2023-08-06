package com.example.warmsun

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        startFragment(FragmentType.MAIN)
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