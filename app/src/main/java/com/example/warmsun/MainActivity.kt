package com.example.warmsun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.warmsun.databinding.ActivityMainBinding

enum class FragmentType(name: String) {
    HOME("home"),
    MAIN("main"),
    MESSAGE("message"),
    MY("my")
}

class MainActivity : AppCompatActivity() {


    private val fragmentMap = mutableMapOf<String, Fragment>()


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment(FragmentType.MAIN)
    }

    fun showFragment(type: FragmentType) {
        val transaction = supportFragmentManager.beginTransaction()
        // 隐藏所有
        fragmentMap.forEach { (name, fragment) ->
            transaction.hide(fragment)
        }
        // 没有，添加到map中
        if (type.name !in fragmentMap) {
            fragmentMap[type.name] = when (type) {
                FragmentType.HOME -> HomeFragment()
                FragmentType.MAIN -> MainFragment()
                FragmentType.MESSAGE -> MessageFragment()
                FragmentType.MY -> MyFragment()
            }
            transaction.add(binding.frameLayout.id, fragmentMap[type.name]!!)
        } else {
            // 有显示
            transaction.show(fragmentMap[type.name]!!)
        }
        transaction.commit()
    }
}