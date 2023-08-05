package com.example.warmsun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.warmsun.databinding.ActivityMainBinding

enum class FragmentType(name: String) {
    MAIN("main"),
    KNOWLEDGE("knowledge"),
    KNOWLEDGE_CONTENT("knowledgeContent"),
    PERSONAL_INFORMATION("personalInformation"),
    CONSULT("consult"),
}

class MainActivity : AppCompatActivity() {

    private val fragmentMap = mutableMapOf<String, Fragment>()


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
            }
            transaction.add(binding.frameLayout.id, fragmentMap[type.name]!!)
        } else {
            // 有显示，show展示
            transaction.show(fragmentMap[type.name]!!)
        }
        transaction.commit()
    }
}